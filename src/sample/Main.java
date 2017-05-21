package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Main extends Application {

    private Stage window;
    Scene mainScene, sources;

    private TextArea HTTPanswer = new TextArea();
    private TextArea domainInput = new TextArea();
    private Label label2 = new Label("Sources");
    private Button button1 = new Button("Request data");
    private Button button2 = new Button("Sources list");
    private Button button3 = new Button("Back");
    private Button button4 = new Button("License info");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        button1.setOnAction(e -> {
            if (getDomain(domainInput.getText()) != null) {
                HTTPanswer.setText(getData(getDomain(domainInput.getText()), 1));
            } else {
                domainInput.clear();
                domainInput.setPromptText("Введена некорректная строка!");
            }
        });
        button2.setOnAction(e -> window.setScene(sources));
        button3.setOnAction(e -> window.setScene(mainScene));
        button4.setOnAction(e -> alertBox.display("License", "THE SOFTWARE IS PROVIDED \"AS IS\""));
        domainInput.setOnMouseClicked(e -> domainInput.setPromptText("https://vk.com/sci_hub"));

        domainInput.setPromptText("https://vk.com/sci_hub");
        domainInput.setMaxHeight(10);
        HTTPanswer.setWrapText(true);
        HTTPanswer.setMinHeight(320);

        VBox centerMenu = new VBox();
        VBox leftMenu = new VBox();
        centerMenu.getChildren().addAll(domainInput, HTTPanswer);
        leftMenu.getChildren().addAll(button1, button2, button4);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerMenu);
        borderPane.setLeft(leftMenu);

        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(10, 10, 10, 10));
        mainGrid.setVgap(8);
        mainGrid.setHgap(10);
        GridPane.setConstraints(leftMenu,0,0);
        GridPane.setConstraints(centerMenu,1,0);
        mainGrid.getChildren().addAll(leftMenu,centerMenu);

        mainScene = new Scene(mainGrid, 680, 380);

        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(label2, button3);
        sources = new Scene(layout2, 400, 350);

        window.setScene(mainScene);
        window.setTitle("Alterum");
        window.show();
    }

    private String getData(String domain, int count) {
        String api_url = "https://api.vk.com/method/";
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        HttpPost httpPost = new HttpPost(api_url + "wall.get?" +
                "domain=" + domain +
                "&count=" + count);
        String response_text = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            response_text = org.apache.http.util.EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpPost.abort();
        return response_text;
    }

    private String getDomain(String domain) {
        domain = domain.toLowerCase();
        domain = domain.trim();
        if (domain.matches("^((https|http)(:)(/)(/)(www.vk.com|vk.com)(/)(?:[a-z0-9][a-z0-9_][a-z0-9]*))|((www.vk.com|vk.com)(/)(?:[a-z0-9][a-z0-9_][a-z0-9]*))$")) {
            domain = domain.replaceFirst("^((https|http)(:)(/)(/)(www.vk.com|vk.com)(/))|((www.vk.com|vk.com)(/))$","");
            domain = domain.replaceFirst("^((www.vk.com|vk.com)(/))|((https|http)(:)(/)(/)(www.vk.com|vk.com)(/))$","");
        } else {
            return null;
        }
        return domain;
    }
}