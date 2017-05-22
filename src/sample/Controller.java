package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML TextField domainInputTextField;
    @FXML TextArea HTTPAnswer;

    public void getDataFromHttpRequest() {
        if (requests.getDomain(domainInputTextField.getText()) != null) {
            HTTPAnswer.setText(requests.getData(requests.getDomain(domainInputTextField.getText()), 1));
        } else {
            domainInputTextField.clear();
            domainInputTextField.setPromptText("Введена некорректная ссылка!");
        }
    }

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/sci_hub");
    }

    public void displayLicenseInfo() {
        alertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}
