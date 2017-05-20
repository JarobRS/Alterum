package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class Main extends Application {

    private Stage window;
    Scene mainScene, sources;

    public static String SCOPE = "messages";
    private static String api_url = "https://api.vk.com/method/";
    private static String domain = "kosmoshturm";
    private static int count = 2;

    private static HttpResponse response;
    private static String response_text;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //////////////////////////////// Design ////////////////////////////////////////
        window = primaryStage;

        Label label1 = new Label("Greetings!");
        Label label2 = new Label("Sources");
        Button button1 = new Button("Post HTTP request");
        Button button2 = new Button("Check the sources list");
        Button button3 = new Button("Back");

        button1.setOnAction(e -> label1.setText(response_text));
        button2.setOnAction(e -> window.setScene(sources));
        button3.setOnAction(e -> window.setScene(mainScene));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2);
        mainScene = new Scene(layout1, 400, 350);

        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button3);
        sources = new Scene(layout2, 400, 350);

        window.setScene(mainScene);
        window.setTitle("Alterum");
        window.show();
        //////////////////////////// End of design /////////////////////////////////////

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(api_url + "wall.get?" +
                "domain=" + domain +
                "&count=" + count);

        response = httpClient.execute(httpPost);
        response_text = org.apache.http.util.EntityUtils.toString(response.getEntity());
        httpPost.abort();
    }
}