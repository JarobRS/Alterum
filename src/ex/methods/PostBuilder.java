package ex.methods;

import ex.obj.sources.community.Community;
import ex.obj.sources.commutinyShort.CommunityShort;
import ex.obj.sources.user.User;
import ex.obj.sources.userShort.UserShort;
import ex.obj.wall.CopyHistory;
import ex.obj.wall.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
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
        HBox titleBox = buildPrimaryTitleInfo(rawPost);

        primaryPostBox.getChildren().add(titleBox);
        primaryPostBox.getChildren().add(buildPrimaryPost(rawPost));

        GridPane secondaryPostBox;
        if(rawPost.getCopyHistory() != null) {
            secondaryPostBox = buildSecondaryPost(rawPost.getCopyHistory().get(0));
            primaryPostBox.getChildren().add(secondaryPostBox);
        }

        Separator separator = new Separator();
        separator.setMinHeight(38);
        separator.setMaxWidth(496);
        separator.setOpacity(0.65);
        separator.setPadding(new Insets(0, -1, 0, -11));
        primaryPostBox.getChildren().add(separator);

        primaryPostBox.getChildren().add(buildUnderlineBox(rawPost));
        borderBox.getChildren().addAll(primaryPostBox);

        return borderBox;
    }

    private static String prevPID, prevSID;
    private static Image prevPImage, prevSImage;
    private static String prevPName, prevPFirstName, prevPLastName, prevSName, prevSFirstName, prevSLastName;

    private static HBox buildPrimaryTitleInfo(Item rawPost) {

        HBox borderBox = new HBox();
        borderBox.setStyle("-fx-background-color: #FFFFFF;");
        borderBox.setPrefWidth(510);
        borderBox.setMaxSize(510,210);
        borderBox.setPadding(new Insets(16, 0, 0, -4));

        GridPane titleBox = new GridPane();

        String response;
        User user;
        Community community;
        Image avatar = null;
        String name = null, firstName = null, lastName = null;

        String id = rawPost.getFromId().toString();
        if (!Objects.equals(id, prevPID)) {
            try {
                if (id.toCharArray()[0] == '-') {
                    response = Requests.getCommutityShortInfo(String.valueOf(id.substring(1)));
                    community = JsonParser.getCommunityInfo(response);

                    name = community.getResponse().get(0).getName();
                    avatar = new Image(community.getResponse().get(0).getPhoto50());
                } else {
                    response = Requests.getUserShortInfo(String.valueOf(id));
                    user = JsonParser.getUserInfo(response);

                    firstName = user.getResponse().get(0).getFirstName();
                    lastName = user.getResponse().get(0).getLastName();
                    avatar = new Image(user.getResponse().get(0).getPhoto50());
                }
                prevPID = id;
                prevPImage = avatar;
                prevPName = name;
                prevPFirstName = firstName;
                prevPLastName = lastName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            avatar = prevPImage;
            name = prevPName;
            firstName = prevPFirstName;
            lastName = prevPLastName;
        }

        titleBox.add(new ImageView(avatar), 0, 0);

        VBox nameAndDateBox = new VBox();
        nameAndDateBox.setPadding(new Insets(0, 16, 0, 16));
        if (name != null)
            nameAndDateBox.getChildren().add(new Label(name));
        else
            nameAndDateBox.getChildren().add(new Label(firstName+" "+lastName));
        //nameAndDateBox.getChildren().add(new Label("-"));
        titleBox.add(nameAndDateBox, 1, 0);

        Region divider = new Region();
        HBox.setHgrow(divider, Priority.ALWAYS);
        borderBox.getChildren().addAll(titleBox, divider, new Button("..."));
        return borderBox;
    }

    private static GridPane buildSecondaryTitleInfo(CopyHistory rawPost) {

        GridPane titleBox = new GridPane();
        titleBox.setStyle("-fx-background-color: #FFFFFF;");
        titleBox.setPrefWidth(510);
        titleBox.setMaxSize(510,210);

        String response;
        UserShort user;
        CommunityShort community;
        Image avatar = null;
        String name = null, firstName = null, lastName = null;

        String id = rawPost.getFromId().toString();
        if (!Objects.equals(id, prevSID)) {
            try {
                if (id.toCharArray()[0] == '-') {
                    response = Requests.getCommutityShortInfo(String.valueOf(id.substring(1)));
                    community = JsonParser.getCommunityShortInfo(response);

                    name = community.getResponse().get(0).getName();
                    avatar = new Image(community.getResponse().get(0).getPhoto50());
                } else {
                    response = Requests.getUserShortInfo(String.valueOf(id));
                    user = JsonParser.getUserShortInfo(response);

                    firstName = user.getResponse().get(0).getFirstName();
                    lastName = user.getResponse().get(0).getLastName();
                    avatar = new Image(user.getResponse().get(0).getPhoto50());
                }
                prevSID = id;
                prevSImage = avatar;
                prevSName = name;
                prevSFirstName = firstName;
                prevSLastName = lastName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            avatar = prevSImage;
            name = prevSName;
            firstName = prevSFirstName;
            lastName = prevSLastName;
        }

        titleBox.add(new ImageView(avatar), 0, 0);

        VBox nameAndDateBox = new VBox();
        nameAndDateBox.setPadding(new Insets(0, 16, 0, 16));
        if (name != null)
            nameAndDateBox.getChildren().add(new Label(name));
        else
            nameAndDateBox.getChildren().add(new Label(firstName+" "+lastName));
        //nameAndDateBox.getChildren().add(new Label("-"));
        titleBox.add(nameAndDateBox, 1, 0);
        return titleBox;
    }

    private static VBox buildPrimaryPost(Item rawPost) {

        VBox postBox = new VBox();
        postBox.setStyle("-fx-background-color: #FFFFFF;");
        postBox.setMaxWidth(Double.MAX_VALUE);
        postBox.setAlignment(Pos.TOP_CENTER);
        postBox.setPrefWidth(510);
        postBox.setPadding(new Insets(14, 0, 0, 0));

        if (!Objects.equals(rawPost.getText(), ""))
            postBox.getChildren().add(buildTextArea(rawPost.getText(), 540));

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

    private static GridPane buildSecondaryPost(CopyHistory rawPost) {

        GridPane mainGrid = new GridPane();

        HBox indentBox = new HBox();
        HBox indent1 = new HBox();
        HBox indent2 = new HBox();
        indent1.setMinWidth(15);
        indent2.setMinWidth(10);

        HBox line = new HBox();
        line.setMinWidth(2);
        line.setStyle("-fx-background-color: #DEE6EE;");
        indentBox.getChildren().addAll(indent1, line, indent2);

        VBox postBox = new VBox();
        postBox.setMaxWidth(Double.MAX_VALUE);
        postBox.setAlignment(Pos.TOP_CENTER);
        postBox.setPrefWidth(496);

        postBox.getChildren().add(buildSecondaryTitleInfo(rawPost));

        VBox intent = new VBox();
        intent.setMinHeight(14);
        postBox.getChildren().add(intent);

        if (!Objects.equals(rawPost.getText(), ""))
            postBox.getChildren().add(buildTextArea(rawPost.getText(), 496));

        try {
            Image image = new Image(rawPost.getAttachments().get(0).getPhoto().getPhoto604());
            ImageView imageView = new ImageView(image);

            double w = image.getWidth();
            if (w > 496) {
                double p = (w - 496) / w;
                imageView.setFitWidth(496);
                imageView.setFitHeight(image.getHeight() - (image.getHeight() * p));
            }

            double h = image.getHeight();
            if (h > 496) {
                double p = (h - 496) / h;
                imageView.setFitHeight(496);
                imageView.setFitWidth(image.getWidth() - (image.getWidth() * p));
            }

            postBox.getChildren().add(imageView);
        } catch (Exception ignored) {}

        mainGrid.add(indentBox, 0, 0);
        mainGrid.add(postBox, 1, 0);

        return mainGrid;
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

    private static TextArea buildTextArea(String rawText, int width) {

        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-background-color: #ffffff;" +
                "-fx-border-color: #ffffff;" +
                "-fx-focus-color: transparent;" +
                "-fx-faint-focus-color: transparent;");
        textArea.setMaxWidth(width);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setText(rawText);

        textArea.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            if (!newPropertyValue)
                textArea.deselect();}
        );

        Text textHolder = new Text();
        textArea.setFont(Font.font("Open Sans", 13.780538082125)); // даже не спрашивайте, зачем здесь это число и как я его вычислил
        textHolder.setText(textArea.getText());
        textHolder.setFont(Font.font("Open Sans", 15));
        textHolder.setWrappingWidth(width);

        textArea.setPrefHeight(textHolder.getLayoutBounds().getHeight() + 20);
        return textArea;
    }
}
