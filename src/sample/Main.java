package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

    Label label1 = new Label("Greetings!");
    Label label2 = new Label("Sources");
    Button button1 = new Button("Post HTTP request");
    Button button2 = new Button("Check the sources list");
    Button button3 = new Button("Back");

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        button1.setOnAction(e -> {
            label1.setText(getData("kosmoshturm", 1));
        });
        button2.setOnAction(e -> window.setScene(sources));
        button3.setOnAction(e -> {
            window.setScene(mainScene);
            label1.setText("Greetings!");
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2);
        mainScene = new Scene(layout1, 400, 350);

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button3);
        sources = new Scene(layout2, 400, 350);

        window.setScene(mainScene);
        window.setTitle("Alterum");
        window.show();
    }

    public String getData(String domain, int count) {
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
}