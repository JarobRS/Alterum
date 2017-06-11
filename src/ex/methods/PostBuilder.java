package ex.methods;

import ex.obj.wall.CopyHistory;
import ex.obj.wall.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.fxmisc.richtext.StyleClassedTextArea;

import java.util.Objects;

public class PostBuilder {

    public static Object buildPost(Item rawPost) {

        VBox borderBox = new VBox();
        borderBox.setMaxWidth(Double.MAX_VALUE);
        borderBox.setAlignment(Pos.TOP_CENTER);
        borderBox.setPrefWidth(550);
        borderBox.setStyle(
                "-fx-border-color: #D7D8DB;" +
                "-fx-background-color: #FFFFFF;");

        VBox primaryPostBox = new VBox();
        primaryPostBox.setMaxWidth(Double.MAX_VALUE);
        primaryPostBox.setAlignment(Pos.TOP_CENTER);
        primaryPostBox.setPrefWidth(510);
        GridPane titleBox = buildTitleInfo(rawPost);

        primaryPostBox.getChildren().add(titleBox);
        primaryPostBox.getChildren().add(buildPrimaryPost(rawPost));

        VBox secondaryPostBox;
        if(rawPost.getCopyHistory() != null) {
            secondaryPostBox = buildSecondaryPost(rawPost.getCopyHistory().get(0));
            primaryPostBox.getChildren().add(secondaryPostBox);
        }

        Separator separator = new Separator();
        separator.setMinHeight(38);
        separator.setMaxWidth(510);
        separator.setOpacity(0.65);
        primaryPostBox.getChildren().add(separator);

        primaryPostBox.getChildren().add(buildUnderlineBox(rawPost));
        borderBox.getChildren().addAll(primaryPostBox);

        return borderBox;
    }

    private static GridPane buildTitleInfo(Item rawPost) {

        GridPane titleBox = new GridPane();
        titleBox.setStyle("-fx-background-color: #FFFFFF;");
        titleBox.setPrefWidth(510);
        titleBox.setMaxSize(510,210);
        titleBox.setPadding(new Insets(16, 0, 0, 0));

        ImageView imageView = new ImageView(new Image("https://pp.userapi.com/c840231/v840231349/a734/yS_sfGwbUaY.jpg"));
        titleBox.add(imageView, 0, 0);

        VBox nameAndDateBox = new VBox();
        nameAndDateBox.setPadding(new Insets(0, 16, 0, 16));
        nameAndDateBox.getChildren().add(new Label("Томас Азенкур"));
        nameAndDateBox.getChildren().add(new Label("26 Mar 19:45"));
        titleBox.add(nameAndDateBox, 1, 0);

        titleBox.add(new Button("Details"), 2, 0);
        return titleBox;
    }

    private static VBox buildPrimaryPost(Item rawPost) {

        VBox postBox = new VBox();
        postBox.setStyle("-fx-background-color: #FFFFFF;");
        postBox.setMaxWidth(Double.MAX_VALUE);
        postBox.setAlignment(Pos.TOP_CENTER);
        postBox.setPrefWidth(510);
        postBox.setPadding(new Insets(14, 0, 0, 0));

        if (!Objects.equals(rawPost.getText(), "")) {
            StyleClassedTextArea textArea = new StyleClassedTextArea();
            textArea.setWrapText(true);
            textArea.setDisable(true);
            textArea.setMaxSize(510,210);
            textArea.appendText(rawPost.getText());
            postBox.getChildren().add(textArea);
        }

        try {
            Image image = new Image(rawPost.getAttachments().get(0).getPhoto().getPhoto604());
            ImageView imageView = new ImageView(image);

            double w = image.getWidth();
            if (w > 510) {
                double p = (w - 510) / w;
                imageView.setFitWidth(510);
                imageView.setFitHeight(image.getHeight() - (image.getHeight() * p));
            }

            double h = image.getHeight();
            if (h > 510) {
                double p = (h - 510) / h;
                imageView.setFitHeight(510);
                imageView.setFitWidth(image.getWidth() - (image.getWidth() * p));
            }

            postBox.getChildren().add(imageView);
        } catch (Exception ignored) {}

        return postBox;
    }

    private static VBox buildSecondaryPost(CopyHistory rawPost) {

        VBox postBox = new VBox();
        postBox.setMaxWidth(Double.MAX_VALUE);
        postBox.setAlignment(Pos.TOP_CENTER);
        postBox.setPrefWidth(510);
        postBox.setPadding(new Insets(14, 0, 0, 0));

        if (!Objects.equals(rawPost.getText(), "")) {
            StyleClassedTextArea textArea = new StyleClassedTextArea();
            textArea.setWrapText(true);
            textArea.setDisable(true);
            textArea.setMaxSize(510,210);
            textArea.appendText(rawPost.getText());
            postBox.getChildren().add(textArea);
        }

        try {
            Image image = new Image(rawPost.getAttachments().get(0).getPhoto().getPhoto604());
            ImageView imageView = new ImageView(image);

            double w = image.getWidth();
            if (w > 510) {
                double p = (w - 510) / w;
                imageView.setFitWidth(510);
                imageView.setFitHeight(image.getHeight() - (image.getHeight() * p));
            }

            double h = image.getHeight();
            if (h > 510) {
                double p = (h - 510) / h;
                imageView.setFitHeight(510);
                imageView.setFitWidth(image.getWidth() - (image.getWidth() * p));
            }

            postBox.getChildren().add(imageView);
        } catch (Exception ignored) {}

        return postBox;
    }

    private static HBox buildUnderlineBox(Item rawPost) {

        HBox underlineBox = new HBox();
        underlineBox.setMaxWidth(500);
        underlineBox.setPadding(new Insets(-3, 0, 16, 0));
        Label likesLabel, commentsLabel, repostsLabel, viewsLabel = new Label();
        likesLabel = new Label("Нравится " + rawPost.getLikes().getCount());
        commentsLabel = new Label("Комментарии " + rawPost.getComments().getCount());
        repostsLabel = new Label("Поделилось " + rawPost.getReposts().getCount());

        if (rawPost.getViews() != null) {
            viewsLabel = new Label("Просмотров " + rawPost.getViews().getCount());
            viewsLabel.setAlignment(Pos.TOP_RIGHT);
        }

        likesLabel.setPadding(new Insets(0, 12, 0, 0));
        commentsLabel.setPadding(new Insets(0, 12, 0, 0));

        Region divider = new Region();
        HBox.setHgrow(divider, Priority.ALWAYS);
        underlineBox.getChildren().addAll(likesLabel, commentsLabel, repostsLabel, divider, viewsLabel);

        return underlineBox;
    }
}
