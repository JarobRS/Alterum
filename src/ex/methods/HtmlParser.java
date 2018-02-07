package ex.methods;

import ex.MainWindowController;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HtmlParser {

    private static String getFile(String filePath) {
        InputStream data = MainWindowController.class.getResourceAsStream(filePath);
        if (data == null) {
            return null;
        }

        Scanner s = new java.util.Scanner(data);
        s.useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        s.close();

        assert content != null;
        return content;
    }

    public static String pageProcessing(String rawHtml, boolean isFirst) {

        if (isFirst) {
            // общая проверка на тип страницы
            if (getFeedVisualComponents(rawHtml) == null)
                return generateMessage("Страница недоступна", "Возможно, она заблокирована администрацией или вы указали некорректный запрос.");

            if (checkUnauthorized(rawHtml))
                return generateMessage("Страница скрыта от неавторизованных пользвателей", "Похоже, владелец аккаунта запретил просмотр своей страницы неавторизованным пользователям.");

            if (checkEmptyWall(rawHtml))
                return generateMessage("На стене пока нет ни одной записи", "Возможно, они появятся позже.");

            if (checkGroupClosed(rawHtml))
                return generateMessage("Это закрытое сообщество", "К сожалению, закрытые сообщества недоступны для анонимного просмотра.");
        }

        // загрузка постов в определенный блок html
        List<Post> postList = extractPosts(rawHtml);
        String webPage = loadPosts(getFile("resources/html/FeedTemplate.html"), postList);

        assert (webPage != null);
        List<String> scriptList = new ArrayList<>();
        scriptList.add("resources/js/jquery.js");
        scriptList.add("resources/js/common.js");
        scriptList.add("resources/js/page.js");
        webPage = addScripts(webPage, scriptList);
        webPage = modifyPage(webPage);

        return webPage;
    }

    private static List<Post> extractPosts(String rawHtml) {

        List<Post> postList = new ArrayList<>();
        Document doc = Jsoup.parse(rawHtml);
        Elements posts = doc.body().getElementsByAttributeValueContaining("class", "_post post page_block");

        for (int i = 0; i < posts.size(); i++) {
            Post post = new Post();

            try {
                post.setAuthorID(posts.get(0).getElementsByAttributeValue("class", "author").get(0).text());
                post.setContent(posts.get(i).outerHtml());
                post.setDateTime(null);

                postList.add(post);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return postList;
    }

    // генерация сообщения в общепринятом стиле
    private static String generateMessage(String header, String lore) {

        return "<div class=\"page_block\"><div id=\"page_info_wrap\" class=\"page_info_wrap\"><div id=\"profile_info\">" +
                "<div class=\"page_top\"><div class=\"page_current_info\" id=\"page_current_info\">" +
                header + "</div></div><h5 class=\"profile_deleted_text\">" +
                lore + "</h5></div></div></div>";
    }

    // проверка на доступ к страничке
    private static boolean checkUnauthorized(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return !Objects.equals(doc.body().getElementsByAttributeValue("class", "profile_deleted_text").html(), "");
    }

    // проверка стены на заполненность
    private static boolean checkEmptyWall(String rawHtml) {
        Document doc = Jsoup.parse(rawHtml);

        return !Objects.equals(doc.body().getElementsByAttributeValue("class", "page_wall_no_posts").text(), "");
    }

    // проверка, открыта ли группа для свободного просмотра
    private static boolean checkGroupClosed(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        return Objects.equals(doc.body().getElementsByAttributeValue("class", "wall_module").html(), "");
    }

    // проверка наличия блока, способного вмещать посты
    private static String getFeedVisualComponents(String rawHtml) {

        Document doc = Jsoup.parse(rawHtml);
        Element wall = doc.body().getElementsByAttributeValue("class", "wide_column_wrap").first();
        if (wall == null)
            return null;
        return wall.html();
    }

    // парсинг сырого html и формирование списка постов в виде объекта-списка
    private static String loadPosts(String placeholder, List<Post> postList) {

        Document page = Jsoup.parse(placeholder);
        Element postStack = page.body().getElementsByAttributeValueContaining("class", "wall_posts").get(0);

        assert (postList.size() > 0);
        for (Post aPost : postList) {
            String postContent = Jsoup.parse(aPost.getContent()).html();
            postContent = modifyPost(postContent);
            postStack.append(postContent);
        }

        return page.html();
    }

    private static String modifyPost(String postDiv) {

        Document post = Jsoup.parse(postDiv);
        Elements div = post.body().getElementsByAttributeValue("class", "ui_actions_menu_wrap _ui_menu_wrap");
        div.append("<button class='flat_button secondary_dark' id='wall_more_link' style='display: block;' onclick='loadingStarted = false;'>Сохранить в закладки</button>");

        return post.html();
    }

    private static String modifyPage(String pageHtml) {

        Document page = Jsoup.parse(pageHtml);
        Elements div = page.body().getElementsByAttributeValue("class", "wide_column_wrap");
        div.append("<button class='page_switcher flat_button' onclick='pageGoBack();'>Назад</button>");
        div.append("<button class='page_switcher flat_button' onclick='pageGoForward();'>Далее</button>");

        return page.html();
    }

    // добавление скриптов из списка файлов
    private static String addScripts(String rawHtml, List<String> scriptList) {

        Document webPage = Jsoup.parse(rawHtml);
        for (String script : scriptList) {
            webPage.head().html(webPage.head().html() + "<script>" + getFile(script) + "</script>");
        }

        return webPage.html();
    }

    // определяем информационный источник(страница/группа/пр.) по коду страницы
    public static VkSource getSource(String rawHtml, String url) {

        Document doc = Jsoup.parse(rawHtml);
        VkSource source = new VkSource();

        source.setName(doc.body().getElementsByAttributeValueContaining("class", "op_header").text());
        source.setLore(doc.body().getElementsByAttributeValue("class", "pp_status").text());
        source.setUrl(url);
        source.setIconUrl(doc.body().getElementsByAttributeValue("class", "pp_img").attr("src"));

        if (Objects.equals(source.getName(), ""))
            return null;

        GridPane sourceBox = new GridPane();
        sourceBox.setId("sourceBox");

        // если установлен аватар, то [...], иначе отрисовать собственный аватар
        if (!Objects.equals(source.getIconUrl(), "")
                && !Objects.equals(source.getIconUrl(), "/images/deactivated_hid_100.gif")
                && !Objects.equals(source.getIconUrl(), "/images/deactivated_100.png")
                && !Objects.equals(source.getIconUrl(), "/images/camera_100.png")
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

        // добавление текстовой информации и финальное конструирование
        VBox desc = new VBox();
        desc.setPadding(new Insets(2,0,2,6));
        desc.getChildren().add(new Label(source.getName()));
        desc.getChildren().add(new Label(source.getLore()));
        sourceBox.add(desc, 1, 0);
        source.setBody(sourceBox);

        return source;
    }
}
