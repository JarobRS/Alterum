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

import static ex.methods.HtmlParser.pageProcessing;

public class MainWindowController {
    @FXML private CustomTextField mainInputField;
    @FXML private VBox mainVBoxRight;
    @FXML private ScrollPane mainListContainer;
    private MainList mainList;
    private List<Object> fullSourceList;
    private ControlPanel controlPanel;
    private WebView webView;

    private static long lastKeyPressTime = 0L;

    private String fullDomain = "https://vk.com/";
    private String mobileDomain = "https://m.vk.com/";

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

        mainInputField.textProperty().addListener((observable, oldValue, newValue) -> {                // строка поиска
            if (mainInputField.getText().length() > 4) {
                lastKeyPressTime = System.currentTimeMillis();
                int waitTime = 500;                                                  // задержка перед отправкой строки
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (lastKeyPressTime + waitTime <= System.currentTimeMillis()) {
                            Platform.runLater(() -> {
                                String params = Requests.getDomain(mainInputField.getText());
                                mainList.clear();
                                if (params != null && searchGlobally(params))                       // глобальный поиск
                                    mainList.add(generateSeparator());
                                searchLocally(fullSourceList, mainInputField.getText());             // локальный поиск
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

    // связь между web-интерфейсом и приложением
    public class Bridge {
        public void saveToBookmarks(int a) {

            System.out.println(a);
        }

        // догрузить старые посты
        public void pageGoForward(String startFrom) {

            String apiUrl = "https://vk.com/";
            String rawHtml = Requests.getPageContent(apiUrl + "al_wall.php" +
                    "?act=get_wall" +
                    "&al=1" +
                    "&offset=0" +
                    "&owner_id=-76769609" +
                    "&type=own" +
                    "&wall_start_from=0");

            rawHtml = rawHtml.substring(4);
            String webPage = pageProcessing(rawHtml, false);
            System.out.println(123);

            /*webView.getEngine().executeScript(
                    "var div = document.getElementById('page_wall_posts');" +
                            "div.innerHTML += " + escapeHtml4(rawHtml));*/

            webView.getEngine().loadContent(webPage);
        }
    }

    private void loadWebContent(String url) {
        Runnable task = () -> {
            String rawHtml = Requests.getPageContent(url);

            Platform.runLater(() -> {
                WebEngine webEngine = webView.getEngine();
                Worker<Void> worker = webEngine.getLoadWorker();
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

                worker.stateProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject jsObj = (JSObject) webEngine.executeScript("window");
                        jsObj.setMember("jfxOperations", new Bridge());
                    }
                });

                webEngine.setJavaScriptEnabled(true);
                webEngine.setUserStyleSheetLocation(getClass().getResource("resources/mainFeed.css").toString());
                String webPage = pageProcessing(rawHtml, true);
                webView.getEngine().loadContent(webPage);
            });
            Thread.currentThread().interrupt();
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private boolean searchGlobally(String params) {

        String response = Requests.getPageContent(mobileDomain + params);

        List<Object> sourceList = new ArrayList<>();
        VkSource source = HtmlParser.getSource(response, fullDomain + params);
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

    private void searchLocally(List<Object> fullList, String request) {

        request = request.toLowerCase().trim();

        List<Object> filteredList = new ArrayList<>();
        for (Object item : fullList) {
            VkSource aSource = VkSource.class.cast(item);
            if (aSource.getName().toLowerCase().contains(request) ||
                    aSource.getUrl().toLowerCase().contains(request) ||
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

    // добавить элементы на левую панель
    private void addItemsToMainList(List<Object> items) {

        for (Object item : items) {
            if (item instanceof VkSource) {
                VkSource aSource = VkSource.class.cast(item);
                mainList.add(aSource.getBody());

                // клик по элементу списка
                aSource.getBody().setOnMouseClicked(e -> {
                    loadWebContent(aSource.getUrl());
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