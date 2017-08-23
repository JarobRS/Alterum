package ex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage window;
    private Scene sourceInfo;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/mainWindow.fxml"));
        window = primaryStage;
        Scene mainScene = new Scene(root);

        window.setMinWidth(1000);
        window.setMinHeight(438);
        mainScene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());
        window.setScene(mainScene);
        window.setTitle("Alterum");
        window.show();
    }
}