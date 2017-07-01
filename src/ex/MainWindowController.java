package ex;

import ex.methods.HtmlParser;
import ex.methods.Requests;
import ex.obj.subscriptions.VkSource;
import ex.ui.ControlPanel;
import ex.ui.MainList;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.lang.reflect.Method;
import java.util.*;

public class MainWindowController {
    @FXML private CustomTextField mainInputField;
    @FXML private VBox mainVBoxRight;
    @FXML private ScrollPane mainListContainer;
    private MainList mainList;
    private List<Object> fullSourceList;
    private ControlPanel controlPanel;
    private WebView webView;

    private static long lastKeyPressTime = 0L;

    @FXML
    public void initialize() {

        webView = new WebView();
        webView.prefWidthProperty().bind(mainVBoxRight.widthProperty());
        webView.prefHeightProperty().bind(mainVBoxRight.heightProperty());

        controlPanel = new ControlPanel();
        mainVBoxRight.getChildren().addAll(controlPanel, webView);

        mainList = new MainList();
        mainListContainer.setContent(mainList);
        mainList.getStylesheets().add("ex/resources/mainList.css");
        fullSourceList = new ArrayList<>();
        addItemsToMainList(fullSourceList);

        mainInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (mainInputField.getText().length() > 4) {
                lastKeyPressTime = System.currentTimeMillis();
                int waitTime = 500;                                                  // задержка перед отправкой строки
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (lastKeyPressTime + waitTime <= System.currentTimeMillis()) {
                            Platform.runLater(() -> {
                                String domain = Requests.getDomain(mainInputField.getText());
                                mainList.clear();
                                if (searchDomainGlobally(domain))                                   // глобальный поиск
                                    mainList.add(generateSeparator());
                                searchDomainLocally(fullSourceList, mainInputField.getText());       // локальный поиск
                                timer.cancel();
                            });
                        }
                    }
                }, waitTime);
            } else {
                mainList.clear();
                addItemsToMainList(fullSourceList);          // если запрос пустой, то показать пользовательский список
            }
        });

        setupClearButtonField(mainInputField);
    }


    public class Bridge {

        public void keyToggle() {
            System.out.println("123");
        }
    }

    private void loadWebContent(String domain) {
        Runnable task = () -> {
            String response = Requests.getDomainContent(domain, false);

            Platform.runLater(() -> {
                WebEngine webEngine = webView.getEngine();
                Worker<Void> worker = webEngine.getLoadWorker();

                worker.stateProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject jsObj = (JSObject) webEngine.executeScript("window");
                        jsObj.setMember("jfxOperations", new Bridge());
                    }
                });

                webEngine.setJavaScriptEnabled(true);
                webEngine.setUserStyleSheetLocation(getClass().getResource("resources/mainFeed.css").toString());
                webView.getEngine().loadContent(HtmlParser.buildFeed(response));
            });
            Thread.currentThread().interrupt();
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private boolean searchDomainGlobally(String domain) {

        String response = Requests.getDomainContent(domain, true);

        List<Object> sourceList = new ArrayList<>();
        VkSource source = HtmlParser.getSource(response, domain);
        if (source != null) {
            sourceList.add(source);
            addItemsToMainList(sourceList);
            return true;
        } else
            return false;
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

    private void searchDomainLocally(List<Object> fullList, String request) {

        request = request.toLowerCase().trim();

        List<Object> filteredList = new ArrayList<>();
        for (Object item : fullList) {
            VkSource aSource = VkSource.class.cast(item);
            if (aSource.getName().toLowerCase().contains(request) ||
                    aSource.getDomain().toLowerCase().contains(request) ||
                    aSource.getLore().toLowerCase().contains(request))
                filteredList.add(aSource);
        }

        if (filteredList.size() == 0) {            // если локальный не дал результатов
            List<Object> noResults = new ArrayList<>();
            Label noResultsLabel = new Label("Локальный поиск не дал результатов");
            noResultsLabel.setMinWidth(mainList.getWidth());
            noResultsLabel.setAlignment(Pos.TOP_CENTER);
            noResultsLabel.setPadding(new Insets(10, 10, 10, 10));
            noResults.add(noResultsLabel);
            addItemsToMainList(noResults);
        } else
            addItemsToMainList(filteredList);
    }

    private void addItemsToMainList(List<Object> items) {

        for (Object item : items) {
            if (item instanceof VkSource) {
                VkSource aSource = VkSource.class.cast(item);
                mainList.add(aSource.getBody());
                aSource.getBody().setOnMouseClicked(e -> {
                    loadWebContent(aSource.getDomain());
                    controlPanel.showMeta(aSource);
                });
            } else
                mainList.add(item);
        }

    }

    private Separator generateSeparator() {

        Separator separator = new Separator();
        separator.setPadding(new Insets(10, 15, 0, 15));
        return separator;
    }
}