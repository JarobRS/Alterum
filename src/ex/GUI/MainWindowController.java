package ex.GUI;

import ex.methods.Requests;
import ex.methods.JsonParser;
import ex.obj.Response;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainWindowController {
    @FXML private CustomTextField domainInputTextField;
    @FXML private StatusBar mainStatusBar;
    @FXML private ToggleSwitch toggleSwitch1;
    @FXML private FlowPane feedPane;
    @FXML private MaskerPane progressPane;

    @FXML
    public void initialize() {
        setupClearButtonField(domainInputTextField);
        progressPane.setVisible(false);
    }

    public void getDataFromHttpRequest() throws IOException, InterruptedException, ExecutionException {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            Runnable task = () -> {
                try {
                    String domain = Requests.getDomain(domainInputTextField.getText());
                    List<String> domainList = new ArrayList<>();

                    for (int i = 0; i < 10; i++) {
                        domainList.add(i, "greatredshift");
                    }

                    List<Response> postList;
                    List<String> responseList;

                    progressPane.setVisible(true);
                    responseList = Requests.getData(domainList,200); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена;
                    progressPane.setVisible(false);

                    Platform.runLater(() -> feedPane.getChildren().clear());
                    for (int i = 0; i < responseList.size(); i++) {
                        postList = JsonParser.getDataFromJson(responseList.get(i)); // Преобразуем JSON в список постов.

                        String imageURI = "https://www.picclickimg.com/d/l400/pict/252711963244_/Samsung-control-panel-assembly-part-number-de94-02001b.jpg";
                        try {
                            imageURI = postList.get(i).getAttachment().getPhoto().getSrcBig();
                        } catch (Exception e) {}

                        Image image = new Image(imageURI);
                        ImageView imageView = new ImageView(image);
                        double w = image.getWidth();
                        if (w > 500) {
                            double p = (w - 500)/w;
                            imageView.setFitWidth(500);
                            imageView.setFitHeight(image.getHeight() - (image.getHeight() * p));
                        }

                        Platform.runLater(() -> {
                            feedPane.getChildren().add(imageView);
                            feedPane.getChildren().add(new Separator());
                        });
                        mainStatusBar.setProgress((double) (i+1)/responseList.size());
                    }
                    mainStatusBar.setProgress(0);
                }
                catch (Exception e) {
                    throw new IllegalStateException("task interrupted", e);
                }
            };
            //ExecutorService executor = Executors.newFixedThreadPool(1);
            //Future<List<String>> future = executor.submit(task);
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

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/raisongran");
    }

    public void toggleSwitchOnMouseClicked() {
        if (toggleSwitch1.isSelected())
            domainInputTextField.setText("https://vk.com/raisongran");
        else
            domainInputTextField.setText("");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}