package ex.methods;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import ex.obj.PostList;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jsonParser {

    public static List<PostList> getDataFromJson(String jsonData) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        PostList.Response[] response = {gson.fromJson(jsonData, PostList.Response.class)};

        PostList.Response.Attachment attachment = new PostList.Response.Attachment("photo", new PostList.Response.Attachment.Photo(515,484,8548,48,null,null,null,null,151,84818,"fgdf",51,1511,null));
        List<PostList.Response.Attachment> attachments = new ArrayList<>();
        attachments.add(attachment);

        PostList.Response resp1 = new PostList.Response((long) 5114, (long) 848,(long) 848,(long) 848,"photo","dfgdgdgd4ge4",(long) 848,"photo",(long) 848,(long) 848, attachment, null, new PostList.Response.Comments(50), new PostList.Response.Likes(50), new PostList.Response.Reposts(50) , 5881, "gdrgdrgdrg");
        PostList.Response resp2 = new PostList.Response((long) 5116, (long) 848,(long) 848,(long) 848,"photo","dfgdgdgd4ge4",(long) 848,"photo",(long) 848,(long) 848, attachment, null, new PostList.Response.Comments(50), new PostList.Response.Likes(50), new PostList.Response.Reposts(50) , 5881, "gdrgdrgdrg");
        Object[] respA = {555, resp1, resp2};
        PostList pstlst = new PostList(respA);
        System.out.println("Синт: " + gson.toJson(pstlst));
        System.out.println("Ориг: " + jsonData);
        System.out.println("Пров: " + gson.toJson(response[0]));

        //PostList.Response response2 = gson.fromJson(string, PostList.Response.class);
        //System.out.println(response2);

        //List<PostList> answer = new ArrayList<>();
        //answer.add(post);

        return null;
    }
}
