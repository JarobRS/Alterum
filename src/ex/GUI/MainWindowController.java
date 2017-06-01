package ex.GUI;

import ex.methods.Requests;
import ex.methods.jsonParser;
import ex.obj.PostList;
import ex.obj.Response;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController {
    @FXML TextField domainInputTextField;
    //@FXML ImageV HTTPAnswer;
    @FXML FlowPane feedPane;

    public void getDataFromHttpRequest() throws IOException {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            List<String> responseList;
            List<String> domainList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                domainList.add(i, "el_psy_congro");
            }
            responseList = Requests.getData(domainList,20); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена
            for (int i = 0; i < responseList.size(); i++) {
                List<Response> postList = jsonParser.getDataFromJson(responseList.get(i)); // Преобразуем JSON в список постов.
                try {
                    System.out.println(postList.get(i).getAttachment().getPhoto().getSrcXbig());
                } catch (Exception e) {}
            }
        
            // добавление в ленту

        } else {
            domainInputTextField.clear();
           domainInputTextField.setPromptText("Введена некорректная ссылка!");
         }
    }

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/el_psy_congro");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}
