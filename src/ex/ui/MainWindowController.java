package ex.ui;

import ex.methods.HtmlParser;
import ex.methods.Requests;
import ex.obj.subscriptions.VkSource;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainWindowController {
    @FXML private CustomTextField mainInputField;
    @FXML private WebView webView;
    @FXML private VBox mainVBoxRight;
    @FXML private VBox mainList;
    private List<VkSource> fullSourceList;

    @FXML
    public void initialize() {
        setupClearButtonField(mainInputField);
        webView.prefWidthProperty().bind(mainVBoxRight.widthProperty());
        webView.prefHeightProperty().bind(mainVBoxRight.heightProperty());

        fullSourceList = new ArrayList<>();
        updateMainList(fullSourceList);
    }

    private void getDataFromHttpRequest() {
        if (Requests.getDomain(mainInputField.getText()) != null) {
            Runnable task = () -> {                                             //web-запросы в отдельном потоке
                String domain = Requests.getDomain(mainInputField.getText());
                String response = Requests.getSourcePostsHtml(domain);

                Platform.runLater(() -> {
                    WebEngine webEngine = webView.getEngine();
                    webEngine.setJavaScriptEnabled(true);
                    webEngine.setUserStyleSheetLocation(getClass().getResource("css/mainFeed.css").toString());

                    VkSource source = HtmlParser.getSource(response);
                    if(!Objects.equals(source.getName(), "")) {
                        fullSourceList.add(HtmlParser.getSource(response));
                        updateMainList(fullSourceList);
                        webView.getEngine().loadContent(HtmlParser.buildFeed(response));
                    } else {
                        webView.getEngine().loadContent("Такой страницы не существует!");
                    }
                });
            };
            Thread thread = new Thread(task);
            thread.start();
        } else {
            mainInputField.clear();
            mainInputField.setPromptText("Введена некорректная ссылка!");
        }
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mainInputFieldOnClicked() {

        mainInputField.setPromptText("https://vk.com/kosmoshturm");
    }

    public void mainSandwichButtonOnClick() {

        //
    }

    public void mainInputFieldOnKeyReleased(KeyEvent e){

        if(e.getCode().equals(KeyCode.ENTER)) {
            getDataFromHttpRequest();
        }

        if (!Objects.equals(mainInputField.getText(), "")) {
            List<VkSource> searchResults = getFilteredData(mainInputField.getText());
            updateMainList(searchResults);
        } else {
            updateMainList(fullSourceList);
        }
    }

    private List<VkSource> getFilteredData(String input) {

        //

        return null;
    }

    private void updateMainList(List<VkSource> sourceList) {

        for (VkSource aSource : sourceList) {

            HBox sourceBox = new HBox();
            VBox icon = new VBox();
            VBox desc = new VBox();

            icon.getChildren().addAll(new ImageView(aSource.getIconUrl()));
            desc.getChildren().add(new Label(aSource.getName()));
            desc.getChildren().add(new Label(aSource.getLore()));
            sourceBox.getChildren().addAll(icon, desc);

            mainList.getChildren().add(sourceBox);
        }
    }
}