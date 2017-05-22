package ex.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ex.methods.Requests;

public class MainWindowController {
    @FXML TextField domainInputTextField;
    @FXML TextArea HTTPAnswer;

    public void getDataFromHttpRequest() {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            String data = Requests.getData(domain, 1);
            //ObjPost post = new ObjPost();
            HTTPAnswer.setText(data);
        } else {
            domainInputTextField.clear();
            domainInputTextField.setPromptText("Введена некорректная ссылка!");
        }
    }

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/sci_hub");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}
