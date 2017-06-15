package ex.ui;

import com.sun.org.apache.regexp.internal.RE;
import ex.methods.JsonParser;
import ex.methods.PostBuilder;
import ex.methods.Requests;
import ex.obj.wall.Item;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainWindowController {
    @FXML private CustomTextField domainInputTextField;
    @FXML private StatusBar mainStatusBar;
    @FXML private ToggleSwitch toggleSwitch1;
    @FXML private FlowPane feedPane;
    @FXML private MaskerPane progressPane;
    @FXML private ScrollPane mainScrollPane;
    @FXML private WebView webView0;

    @FXML
    public void initialize() {
        setupClearButtonField(domainInputTextField);
        progressPane.setVisible(false);
        mainScrollPane.setStyle("-fx-background-color: #EDEEF0;" +
                "-fx-border-color: #EDEEF0;" +
                "-fx-focus-color: transparent;" +
                "-fx-faint-focus-color: transparent;");
    }

    public void getDataFromHttpRequest() throws IOException, InterruptedException, ExecutionException {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            Runnable task = () -> {
                try {
                    String domain = Requests.getDomain(domainInputTextField.getText());
                    List<String> domainList = new ArrayList<>();

                    domainList.add(domain);

                    progressPane.setVisible(true);
                    List<String> responseList = Requests.getPostContentHtml(domainList); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена;
                    Platform.runLater(() -> {
                        String CSS =
                                "body {"
                                        + "    background-color: #00ff80; "
                                        + "    font-family: Arial, Helvetica, san-serif;"
                                        + "}";

                        WebEngine webEngine = webView0.getEngine();
                        //webEngine.setUserStyleSheetLocation(getClass().getResource("post.css").toString());
                        webEngine.setUserStyleSheetLocation(CSS);
                        webView0.getEngine().loadContent(responseList.get(0));
                    });
                    final List<Item> postList = JsonParser.getPostContent(responseList.get(0)); // Преобразуем JSON в список постов.
                    progressPane.setVisible(false);

                    Platform.runLater(() -> {
                        feedPane.getChildren().clear();
                        VBox postSeparator = new VBox();
                        postSeparator.setMinHeight(14);
                        postSeparator.setMinWidth(2000);
                        feedPane.getChildren().add(postSeparator);
                    });

                    int postsByPage;
                    if (postList.size() <= 20)
                        postsByPage = postList.size();
                    else
                        postsByPage = 20;

                    for (int i = 0; i < postsByPage; i++) {

                        final int j = i;
                        Platform.runLater(() -> {

                            feedPane.getChildren().add((Node) PostBuilder.buildPost(postList.get(j)));

                            VBox postSeparator = new VBox();
                            postSeparator.setMinHeight(14);
                            postSeparator.setMinWidth(2000);
                            feedPane.getChildren().add(postSeparator);

                            mainStatusBar.setProgress((double) (j+1)/postsByPage);
                        });
                        Thread.sleep(400);
                    }
                    Platform.runLater(() -> mainStatusBar.setProgress(0));
                } catch (Exception e) {
                    e.printStackTrace();
                    domainInputTextField.clear();
                    domainInputTextField.setPromptText("Такой страницы не существует!");
                    progressPane.setVisible(false);
                    //throw new IllegalStateException("task interrupted", e);
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        } else {
            domainInputTextField.clear();
            domainInputTextField.setPromptText("Введена некорректная ссылка!");
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

    public void makeSomeRequest() {
        //
    }

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/kosmoshturm");
    }

    public void toggleSwitchOnMouseClicked() {
        if (toggleSwitch1.isSelected())
            domainInputTextField.setText("https://vk.com/greatredshift");
        else
            domainInputTextField.setText("https://vk.com/kosmoshturm");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}