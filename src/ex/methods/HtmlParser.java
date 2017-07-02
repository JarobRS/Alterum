package ex.methods;

import ex.obj.subscriptions.VkSource;
import ex.obj.wall.Post;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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

        if (checkForAuthorizedAccess(feed)) {
            if (checkForFilledWall(feed)) {
                if (checkForGroupOpened(feed)) {
                    feed = deleteTrashBlocks(feed);
                    List<Post> postList = extractPosts(feed);
                    feed = clearFeed(feed);
                    feed = addPosts(feed, postList);
                    feed = addScripts(feed, rawHtml);
                    mainContent.append(feed);

                    return mainContent.toString();
                } else {
                    return generateMessage("Это закрытое сообщество", "К сожалению, закрытые сообщества для вас недоступны.");
                }
            } else
                return generateMessage("На стене пока нет ни одной записи", "Возможно, они появятся позже.");
        } else {
            return generateMessage("Стена скрыта от неавторизованных пользвателей", "Похоже, владелец аккаунта запретил просмотр своей страницы неавторизованным пользователям.");
        }
    }

    private static String generateMessage(String header, String lore) {

        String message = "<div class=\"page_block\"> " +
                " <div id=\"page_info_wrap\" class=\"page_info_wrap\">" +
                "  <div id=\"profile_info\">" +
                "   <div class=\"page_top\">" +
                "    <div class=\"page_current_info\" id=\"page_current_info\">" +
                header +
                "    </div>" +
                "   </div>" +
                "   <h5 class=\"profile_deleted_text\">" +
                lore +
                "</h5>" +
                "  </div>" +
                " </div>" +
                "</div>";

        return message;
    }

    private static boolean checkForAuthorizedAccess(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return Objects.equals(doc.body().getElementsByAttributeValue("class", "profile_deleted_text").html(), "");
    }

    private static boolean checkForFilledWall(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return !Objects.equals(doc.body().getElementsByAttributeValue("class", "_post post page_block all own post_fixed").html(), "");
    }

    private static boolean checkForGroupOpened(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return Objects.equals(doc.body().getElementsByAttributeValue("class", "group_closed_text").text(), "");
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

        for (int i = 0; i < posts.get(0).children().size(); i++) {
            Post post = new Post();

            try {
                post.setAuthorID(posts.get(0).getElementsByAttributeValue("class", "author").get(i).text());
                post.setContent(posts.get(0).child(i).html());
                post.setDateTime(null);

                postList.add(post);
            } catch (Exception ignored) {
            }
        }

        return postList;
    }

    private static String addPosts(String rawHtml, List<Post> postList) {

        Document feed = Jsoup.parse(rawHtml);
        Element div = feed.body().getElementsByAttributeValue("id", "page_wall_posts").get(0);

        for (Post aPost : postList) {
            String postDiv = Jsoup.parse(aPost.getContent()).html();
            postDiv = addPropertiesButtonToPost(postDiv);
            div.append(postDiv);
        }

        return feed.html();
    }

    private static String addScripts(String feed, String rawHtml) {

        Document scripts = Jsoup.parse(rawHtml);
        Document mainContent = Jsoup.parse(feed);

        mainContent.head().html(scripts.head().html() +
                "<script language='javascript'> function callJfxOperations() {" +
                "jfxOperations.saveToBookmarks();" +
                "}</script>");

        return mainContent.html();
    }

    private static String addPropertiesButtonToPost(String postDiv) {

        Document post = Jsoup.parse(postDiv);
        Elements div = post.body().getElementsByAttributeValue("class", "ui_actions_menu_wrap _ui_menu_wrap");
        div.append("<button onclick='callJfxOperations();'>Сохранить в закладки</button>");

        return post.html();
    }

    public static VkSource getSource(String rawHtml, String domain) {

        Document doc = Jsoup.parse(rawHtml);
        VkSource source = new VkSource();

        source.setName(doc.body().getElementsByAttributeValueContaining("class", "op_header").text());
        source.setLore(doc.body().getElementsByAttributeValue("class", "pp_status").text());
        source.setDomain(domain);
        source.setIconUrl(doc.body().getElementsByAttributeValue("class", "pp_img").attr("src"));

        if (Objects.equals(source.getName(), ""))
            return null;

        GridPane sourceBox = new GridPane();
        sourceBox.setId("sourceBox");

        if (!Objects.equals(source.getIconUrl(), "")
                && !Objects.equals(source.getIconUrl(), "/images/deactivated_hid_100.gif")
                && !Objects.equals(source.getIconUrl(), "/images/community_100.png")) {
            ImageView icon = new ImageView(source.getIconUrl());
            icon.setFitHeight(50);
            icon.setFitWidth(50);
            sourceBox.add(icon, 0, 0);
        } else {
            Label customIcon = new Label(String.valueOf(source.getName().toUpperCase().charAt(0)));
            customIcon.setMinSize(50, 50);
            customIcon.setAlignment(Pos.CENTER);
            customIcon.setStyle("-fx-background-color: #C1C5CC;");
            customIcon.setFont(new Font("Arial", 36));
            sourceBox.add(customIcon, 0, 0);
        }

        VBox desc = new VBox();
        desc.setPadding(new Insets(2,0,2,6));
        desc.getChildren().add(new Label(source.getName()));
        desc.getChildren().add(new Label(source.getLore()));
        sourceBox.add(desc, 1, 0);
        source.setBody(sourceBox);

        return source;
    }
}
