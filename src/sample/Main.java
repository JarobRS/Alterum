package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button button1;

    public static String SCOPE = "messages";
    private static String api_url = "https://api.vk.com/method/";
    private static String domain = "kosmoshturm";
    private static int count = 2;

    private static HttpResponse response;
    private static String response_text;

    public static void main(String[] args) throws IOException, URISyntaxException, AWTException, InterruptedException, NoSuchAlgorithmException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //////////////////////////////// Design ///////////////////////////////////////
        primaryStage.setTitle("Title of the Window");
        button1 = new Button();
        button1.setText("Button!");
        button1.setOnAction(this);

        StackPane layout1 = new StackPane();
        layout1.getChildren().add(button1);

        Scene scene1 = new Scene(layout1, 300, 250);
        primaryStage.setScene(scene1);
        primaryStage.show();
        //////////////////////////// End of Design ////////////////////////////////////

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(api_url + "wall.get?" +
                "domain=" + domain +
                "&count=" + count);

        response = httpClient.execute(httpPost);
        response_text = org.apache.http.util.EntityUtils.toString(response.getEntity());
        httpPost.abort();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button1) {
            System.out.println(response_text);
        }
    }
}