package ex.methods;

import com.google.gson.Gson;
import ex.obj.PostList;
import ex.obj.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Response> getDataFromJson(String jsonData) throws IOException {
        Gson gson = new Gson();

        PostList resp = gson.fromJson(jsonData, PostList.class);
        List<Response> listOfPosts = new ArrayList<>();

        for (int i = 1; i < resp.getResponse().size() - 1; i++) {
            String s = gson.toJson(resp.getResponse().get(i));
            listOfPosts.add(gson.fromJson(s, Response.class));
        }

        return listOfPosts;
    }
}