package ex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/mainWindow.fxml"));
        primaryStage.setMinWidth(1020);
        primaryStage.setMinHeight(450);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Alterum");
        primaryStage.show();
    }
}