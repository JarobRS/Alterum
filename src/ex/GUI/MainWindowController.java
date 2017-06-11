package ex.GUI;

import ex.methods.JsonParser;
import ex.methods.PostBuilder;
import ex.methods.Requests;
import ex.obj.wall.Item;
import ex.obj.wall.Response;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

                    domainList.add(domain);

                    progressPane.setVisible(true);
                    List<String> responseList = Requests.getPostContent(domainList,200); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена;
                    final List<Item> postList = JsonParser.getDataFromJson(responseList.get(0)); // Преобразуем JSON в список постов.
                    progressPane.setVisible(false);

                    Platform.runLater(() -> {
                        feedPane.getChildren().clear();
                        VBox postSeparator = new VBox();
                        postSeparator.setMinHeight(14);
                        postSeparator.setMinWidth(2000);
                        feedPane.getChildren().add(postSeparator);
                    });

                    int postsByPage;
                    if (postList.size() <= 20)
                        postsByPage = postList.size();
                    else
                        postsByPage = 20;

                    for (int i = 0; i < postsByPage; i++) {

                        final int j = i;
                        Platform.runLater(() -> {

                            feedPane.getChildren().add((Node) PostBuilder.buildPost(postList.get(j)));

                            VBox postSeparator = new VBox();
                            postSeparator.setMinHeight(14);
                            postSeparator.setMinWidth(2000);
                            feedPane.getChildren().add(postSeparator);

                            mainStatusBar.setProgress((double) (j+1)/postsByPage);
                        });
                        Thread.sleep(200);
                    }
                    mainStatusBar.setProgress(0);
                }
                catch (Exception e) {
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

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/greatredshift");
    }

    public void toggleSwitchOnMouseClicked() {
        if (toggleSwitch1.isSelected())
            domainInputTextField.setText("https://vk.com/greatredshift");
        else
            domainInputTextField.setText("");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}