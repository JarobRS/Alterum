package ex.GUI;

import ex.methods.Requests;
import ex.methods.jsonParser;
import ex.obj.PostList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController {
    @FXML TextField domainInputTextField;
    //@FXML ImageV HTTPAnswer;
    @FXML FlowPane feedPane;

    public void getDataFromHttpRequest() throws IOException {
        //if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            List<String> responseList;
            List<String> domainList = new ArrayList<>();

            for (int i = 0; i < 1; i++) {
                domainList.add(i, "el_psy_congro");
            }
            responseList = Requests.getData(domainList,20); // Получаем список ответов по каждому домену в количестве 20 для отдельного домена
            for (int i = 0; i < responseList.size(); i++) {
                List<PostList> postList = jsonParser.getDataFromJson(responseList.get(i)); // Преобразуем JSON в список постов.
               // System.out.println(postList.get(0).toString());
            }

            /*
            Attachments attachment = new Attachments("photo");
            attachment.setPhoto(18484, 848185, 85151,
                    "https://cs540106.userapi.com/c540100/v540100219/442de/LkwZVqjjhhs.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442df/V6kYGdzZvSk.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442dd/uLKNf0mtBgk.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442e0/obgonTPVbiA.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442e1/BEAQUUqVCig.jpg",
            800, 1000, "", 1495479980,"4b561a917ba530152a");

            List<Attachments> attachments = new ArrayList<>();
            attachments.add(attachment);
            Comments comments = new Comments(1);
            Likes likes = new Likes(10);
            Reposts reposts = new Reposts(10);
            ObjPost post = new ObjPost(12, 12,435,34534,"photo", attachment, attachments, comments, likes, reposts);
            System.out.println(post.attachment.photo.src_xxbig);
            */

            //feedPane.(responseList.get(0));
        //} else {
        //    domainInputTextField.clear();
        //   domainInputTextField.setPromptText("Введена некорректная ссылка!");
        // }
    }

    public void domainInputTextFieldClick() {
        domainInputTextField.setPromptText("https://vk.com/el_psy_congro");
    }

    public void displayLicenseInfo() {
        AlertBox.display("License info", "THE SOFTWARE IS PROVIDED \"AS IS\"");
    }
}
