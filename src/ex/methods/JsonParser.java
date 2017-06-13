package ex.methods;

import com.google.gson.Gson;
import ex.obj.sources.community.Community;
import ex.obj.sources.commutinyShort.CommunityShort;
import ex.obj.sources.user.User;
import ex.obj.sources.userShort.UserShort;
import ex.obj.wall.Item;
import ex.obj.wall.PostList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Item> getPostContent(String jsonData) throws IOException {
        Gson gson = new Gson();

        PostList resp = gson.fromJson(jsonData, PostList.class);
        List<Item> listOfPosts = new ArrayList<>();

        for (int i = 1; i < resp.getResponse().getItems().size() - 1; i++) {
            String s = gson.toJson(resp.getResponse().getItems().get(i - 1));
            listOfPosts.add(gson.fromJson(s, Item.class));
        }

        return listOfPosts;
    }

    public static User getUserInfo(String jsonData) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, User.class);
    }

    public static Community getCommunityInfo(String jsonData) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, Community.class);
    }

    public static UserShort getUserShortInfo(String jsonData) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, UserShort.class);
    }

    public static CommunityShort getCommunityShortInfo(String jsonData) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, CommunityShort.class);
    }
}