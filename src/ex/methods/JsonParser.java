package ex.methods;

import com.google.gson.Gson;
import ex.obj.wall.Item;
import ex.obj.wall.PostList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Item> getDataFromJson(String jsonData) throws IOException {
        Gson gson = new Gson();

        PostList resp = gson.fromJson(jsonData, PostList.class);
        List<Item> listOfPosts = new ArrayList<>();

        for (int i = 1; i < resp.getResponse().getItems().size() - 1; i++) {
            String s = gson.toJson(resp.getResponse().getItems().get(i - 1));
            listOfPosts.add(gson.fromJson(s, Item.class));
        }

        return listOfPosts;
    }
}