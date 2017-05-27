package ex.methods;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import ex.obj.objPostData.PostList;
import ex.obj.objPostData.Response;

import java.util.ArrayList;
import java.util.List;

public class jsonParser {

    public static List<PostList> getDataFromJson(String jsonData) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        Response post = gson.fromJson(jsonData, Response.class);

        System.out.println(post.toString());

        List<PostList> answer = new ArrayList<>();
        //answer.add(post);

        return answer;
    }
}
