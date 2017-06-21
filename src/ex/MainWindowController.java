package ex;

import ex.methods.HtmlParser;
import ex.methods.Requests;
import ex.obj.subscriptions.VkSource;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
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
        mainList.getStylesheets().add("ex/resources/mainList.css");
        fullSourceList = new ArrayList<>();
        addItemsToMainList(fullSourceList);

        mainInputField.textProperty().addListener(e -> {

            mainList.getChildren().clear();
            if (!Objects.equals(mainInputField.getText(), "")) {

                String domain = Requests.getDomain(mainInputField.getText());
                if (domain != null && domain.length() > 4) {
                    searchDomainGlobally(domain);
                    mainList.getChildren().add(generateSeparator());
                }

                List<VkSource> localSearchResults = getFilteredData(fullSourceList, mainInputField.getText());
                addItemsToMainList(localSearchResults);

                if (localSearchResults.size() == 0) {
                    Label noResults = new Label("Локальный поиск не дал результатов");
                    noResults.setMinWidth(mainList.getWidth());
                    noResults.setAlignment(Pos.TOP_CENTER);
                    noResults.setPadding(new Insets(10, 10, 10, 10));
                    mainList.getChildren().add(noResults);
                }
            } else {
                mainList.getChildren().clear();
                addItemsToMainList(fullSourceList);
            }
        });
    }

    private void loadWebContent(String domain) {
        Runnable task = () -> {
            String response = Requests.getDomainContent(domain, false);

            Platform.runLater(() -> {
                WebEngine webEngine = webView.getEngine();
                webEngine.setJavaScriptEnabled(true);
                webEngine.setUserStyleSheetLocation(getClass().getResource("resources/mainFeed.css").toString());
                webView.getEngine().loadContent(HtmlParser.buildFeed(response));
            });
            Thread.currentThread().interrupt();
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void searchDomainGlobally(String domain) {

        Runnable task = () -> {
            String response = Requests.getDomainContent(domain, true);
            ArrayList<VkSource> sourceList = new ArrayList<>();
            VkSource source = HtmlParser.getSource(response, domain);
            if (source != null) {
                sourceList.add(source);

                Platform.runLater(() -> {
                    mainList.getChildren().clear();
                    addItemsToMainList(sourceList);
                });
            }

            Thread.currentThread().interrupt();
        };
        Thread thread = new Thread(task);
        thread.start();
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

    public void mainSandwichButtonOnClick() {

        //
    }

    private List<VkSource> getFilteredData(List<VkSource> fullList, String request) {

        request = request.toLowerCase().trim();

        List<VkSource> filteredList = new ArrayList<>();
        for (VkSource aSource : fullList) {
            if (aSource.getName().toLowerCase().contains(request) ||
                    aSource.getDomain().toLowerCase().contains(request) ||
                    aSource.getLore().toLowerCase().contains(request))
                filteredList.add(aSource);
        }
        return filteredList;
    }

    private void addItemsToMainList(List<VkSource> sourceList) {

        for (VkSource aSource : sourceList) {
            mainList.getChildren().add(aSource.getBody());
            aSource.getBody().setOnMouseClicked(e -> loadWebContent(aSource.getDomain()));
        }
    }

    private Separator generateSeparator() {

        Separator separator = new Separator();
        separator.setPadding(new Insets(10, 0, 0, 15));
        return separator;
    }
}