package ex.methods;

import ex.obj.subscriptions.VkSource;
import ex.obj.wall.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HtmlParser {

    public static String buildFeed(String rawHtml) {

        StringBuilder mainContent = new StringBuilder();

        String feed = getFeedVisualComponents(rawHtml);

        if (checkForUnauthorizedAccess(feed) && checkForEmptyWall(feed)) {
            feed = deleteTrashBlocks(feed);

            List<Post> postList = extractPosts(feed);

            feed = clearFeed(feed);
            feed = addPosts(feed, postList);

            feed = addScripts(feed, rawHtml);
            mainContent.append(feed);

            return mainContent.toString();
        } else {
            return feed;
        }
    }

    private static boolean checkForUnauthorizedAccess(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return Objects.equals(doc.body().getElementsByAttributeValue("class", "profile_deleted_text").html(), "");
    }

    private static boolean checkForEmptyWall(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        System.out.println(doc.body().getElementsByAttributeValue("id", "page_wall_count_all").attr("value"));
        return !Objects.equals(doc.body().getElementsByAttributeValue("id", "page_wall_count_all").attr("value"), "0");
    }

    private static String getFeedVisualComponents(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        Element preWall = doc.body().getElementsByAttributeValue("class", "wide_column").first();

        return preWall.html();
    }

    private static String deleteTrashBlocks(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        doc.body().getElementsByAttributeValue("class", "page_block").remove();

        return doc.html();
    }

    private static String clearFeed(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        doc.body().getElementsByAttributeValue("id", "page_wall_posts").html("");

        return doc.html();
    }

    private static List<Post> extractPosts(String rawHtml) {

        List<Post> postList = new ArrayList<>();
        Document doc = Jsoup.parse(rawHtml);
        Elements posts = doc.body().getElementsByAttributeValue("class", "wall_module");

        for (int i=0; i < posts.get(0).children().size(); i++){
            Post post = new Post();

            try {
                post.setAuthorID(posts.get(0).getElementsByAttributeValue("class", "author").get(i).text());
                post.setContent(posts.get(0).child(i).html());
                post.setDateTime(null);

                postList.add(post);
            } catch (Exception ignored) {}
        }

        return postList;
    }

    private static String addPosts(String rawHtml, List<Post> postList) {

        Document feed = Jsoup.parse(rawHtml);
        Element div = feed.body().getElementsByAttributeValue("id", "page_wall_posts").get(0);

        for (Post aPost : postList)
            div.append(Jsoup.parse(aPost.getContent()).html());

        return feed.html();
    }

    private static String addScripts(String feed, String rawHtml) {

        Document scripts = Jsoup.parse(rawHtml);
        Document mainContent = Jsoup.parse(feed);

        mainContent.head().html(scripts.head().html());

        return mainContent.html();
    }

    public static VkSource getSource(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        VkSource source = new VkSource();

        source.setName(doc.body().getElementsByAttributeValue("class", "page_name").text());
        source.setLore(doc.body().getElementsByAttributeValue("class", "current_text").text());
        source.setIconUrl(doc.body().getElementsByAttributeValue("class", "post_img").attr("src"));

        return source;
    }
}
