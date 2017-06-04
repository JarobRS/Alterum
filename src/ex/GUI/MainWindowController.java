package ex.GUI;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXScrollPane;
import ex.methods.Requests;
import ex.methods.jsonParser;
import ex.obj.Response;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MainWindowController {
    @FXML CustomTextField domainInputTextField;
    @FXML StatusBar mainStatusBar;
    @FXML JFXScrollPane scrollPane1;
    @FXML ToggleSwitch toggleSwitch1;
    @FXML FlowPane feedPane;

    @FXML
    public void initialize() {
        setupClearButtonField(domainInputTextField);
    }

    public void setStatusBarValue(double value) {
        //
    }

    public void getDataFromHttpRequest() throws IOException {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            List<String> domainList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                domainList.add(i, "raisongran");
            }

            List<Response> postList;
            List<String> responseList = Requests.getData(domainList,20); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена
            for (int i = 0; i < responseList.size(); i++) {
                postList = jsonParser.getDataFromJson(responseList.get(i)); // Преобразуем JSON в список постов.

                final WebView browser = new WebView();
                final WebEngine webEngine = browser.getEngine();
                browser.setPrefSize(800, 800);

                String content = postList.get(i).getText();
                if (postList.get(i).getAttachment().getPhoto() != null)
                    content = "<p><img src=" + postList.get(i).getAttachment().getPhoto().getSrcBig() + "></p>" + content;
                webEngine.loadContent(content);

                feedPane.getChildren().add(browser);
                feedPane.getChildren().add(new Separator());

            }
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
        domainInputTextField.setPromptText("https://vk.com/el_psy_congro");
    }

    public void toggleSwitchOnMouseClicked() {
        if (toggleSwitch1.isSelected())
            domainInputTextField.setText("https://vk.com/el_psy_congro");
        else
            domainInputTextField.setText("");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}
