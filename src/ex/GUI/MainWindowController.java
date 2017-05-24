package ex.GUI;

import ex.methods.Requests;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.HTMLEditor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindowController {
    @FXML TextField domainInputTextField;
    @FXML ListView HTTPAnswer;

    public void getDataFromHttpRequest() throws IOException {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            List<String> responseList;
            List<String> domainList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                domainList.add(i, "el_psy_congro");
            }
            responseList = Requests.getData(domainList,20);
            System.out.println(responseList.get(0));

            /*
            Attachment attachment = new Attachment("photo");
            attachment.setPhoto(18484, 848185, 85151,
                    "https://cs540106.userapi.com/c540100/v540100219/442de/LkwZVqjjhhs.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442df/V6kYGdzZvSk.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442dd/uLKNf0mtBgk.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442e0/obgonTPVbiA.jpg",
                    "https://cs540106.userapi.com/c540100/v540100219/442e1/BEAQUUqVCig.jpg",
            800, 1000, "", 1495479980,"4b561a917ba530152a");

            List<Attachment> attachments = new ArrayList<>();
            attachments.add(attachment);
            Comments comments = new Comments(1);
            Likes likes = new Likes(10);
            Reposts reposts = new Reposts(10);
            ObjPost post = new ObjPost(12, 12,435,34534,"photo", attachment, attachments, comments, likes, reposts);
            System.out.println(post.attachment.photo.src_xxbig);
            */

            HTTPAnswer.setItems(responseList);
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
