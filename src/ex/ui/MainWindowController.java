package ex.ui;

import ex.methods.HtmlParser;
import ex.methods.Requests;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController {
    @FXML private CustomTextField domainInputTextField;
    @FXML private StatusBar mainStatusBar;
    @FXML private ToggleSwitch toggleSwitch1;
    @FXML private WebView webView;
    @FXML private VBox mainVBoxRight;

    @FXML
    public void initialize() {
        setupClearButtonField(domainInputTextField);
        webView.prefWidthProperty().bind(mainVBoxRight.heightProperty());
        webView.prefHeightProperty().bind(mainVBoxRight.heightProperty());
    }

    public void getDataFromHttpRequest() {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            Runnable task = () -> {
                try {
                    String domain = Requests.getDomain(domainInputTextField.getText());
                    List<String> domainList = new ArrayList<>();

                    domainList.add(domain);
                    domainList.add("kosmoshturm");
                    mainStatusBar.setProgress(0.6);

                    List<String> responseList = Requests.getPostContentHtml(domainList); // Получаем список ответов по каждому домену
                    Platform.runLater(() -> {
                        WebEngine webEngine = webView.getEngine();
                        webEngine.setJavaScriptEnabled(true);
                        webEngine.setUserStyleSheetLocation(getClass().getResource("styles/mainFeed.css").toString());

                        webView.getEngine().loadContent(HtmlParser.buildFeed(responseList));
                    });


                    Platform.runLater(() -> mainStatusBar.setProgress(0));
                } catch (Exception e) {
                    e.printStackTrace();
                    domainInputTextField.clear();
                    domainInputTextField.setPromptText("Такой страницы не существует!");
                    throw new IllegalStateException("task interrupted", e);
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