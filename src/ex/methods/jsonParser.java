package ex.methods;

import com.google.gson.Gson;
import ex.obj.PostList;
import ex.obj.Response;
import javafx.geometry.Pos;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class jsonParser {

    public static List<PostList> getDataFromJson(String jsonData) throws IOException {
        Gson gson = new Gson();
        String jsonData2 = "{\"id\":1126,\"from_id\":-53447252,\"to_id\":-53447252,\"date\":1495567907,\"marked_as_ads\":0,\"post_type\":\"post\",\"text\":\"Лабмены #EPC! <br><br>Ни для кого не секрет, что ВК стал частым объектом внимания Организации. Мы не можем сидеть сложа руки и просто ждать, пока весь наш труд не будет безвозвратно уничтожен, а наш след во времени затоптан, обращен в прах и развеян над БАКом! <br><br>Посему, все записи теперь дублируются в Telegram-канал, куда Вас торжественно и приглашаем. Барбекю на крыше прилагается! <br><br>El.Psy.Congroo.<br>https:\\/\\/t.me\\/Future_Gadget_Laboratory\",\"is_pinned\":1,\"attachment\":{\"type\":\"photo\",\"photo\":{\"pid\":456239435,\"aid\":-5,\"owner_id\":53783338,\"src\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c970\\/xP7xDx8XPA8.jpg\",\"src_big\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c971\\/pi4Qvhc1uvo.jpg\",\"src_small\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c96f\\/8rYCnDemjWg.jpg\",\"src_xbig\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c972\\/1AZdj3IP1yc.jpg\",\"width\":513,\"height\":800,\"text\":\"\",\"created\":1495567854,\"access_key\":\"266404cd0abcc70c45\"}},\"attachments\":[{\"type\":\"photo\",\"photo\":{\"pid\":456239435,\"aid\":-5,\"owner_id\":53783338,\"src\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c970\\/xP7xDx8XPA8.jpg\",\"src_big\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c971\\/pi4Qvhc1uvo.jpg\",\"src_small\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c96f\\/8rYCnDemjWg.jpg\",\"src_xbig\":\"https:\\/\\/cs7053.userapi.com\\/c636327\\/v636327338\\/6c972\\/1AZdj3IP1yc.jpg\",\"width\":513,\"height\":800,\"text\":\"\",\"created\":1495567854,\"access_key\":\"266404cd0abcc70c45\"}},{\"type\":\"link\",\"link\":{\"url\":\"https:\\/\\/t.me\\/Future_Gadget_Laboratory\",\"title\":\"El.Psy.Congroo.\",\"description\":\"\",\"target\":\"external\"}}],\"comments\":{\"count\":2},\"likes\":{\"count\":10},\"reposts\":{\"count\":1}}";

        PostList resp = gson.fromJson(jsonData, PostList.class);
        List<String> listOfPosts = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            listOfPosts.add((String) resp.getResponse().get(i));
        }
        System.out.println((String) resp.getResponse().get(1));
        System.out.println(gson.fromJson(jsonData2, Response.class).getFromId());

        return null;
    }
}
