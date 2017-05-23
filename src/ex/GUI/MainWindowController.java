package ex.GUI;

import com.sun.org.apache.regexp.internal.RE;
import ex.obj.ObjPost;
import ex.obj.objPostData.Attachment;
import ex.obj.objPostData.Comments;
import ex.obj.objPostData.Likes;
import ex.obj.objPostData.Reposts;
import ex.obj.objPostData.types.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ex.methods.Requests;

import java.util.ArrayList;
import java.util.List;

public class MainWindowController {
    @FXML TextField domainInputTextField;
    @FXML TextArea HTTPAnswer;

    public void getDataFromHttpRequest() {
        if (Requests.getDomain(domainInputTextField.getText()) != null) {
            String domain = Requests.getDomain(domainInputTextField.getText());
            String data = Requests.getData(domain, 1);

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
            System.out.println(post.attachments.get(0).photo.src_xxbig);

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
