package ex.ui;

import ex.obj.subscriptions.VkSource;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ControlPanel extends HBox {

    public ControlPanel() {

        this.setMaxHeight(0);
        this.setVisible(false);
    }

    public void showMeta(VkSource source) {

        this.setMaxHeight(Double.MAX_VALUE);
        this.setMinHeight(59);
        this.getChildren().clear();
        this.getChildren().addAll(buildPanel(source));
        this.setVisible(true);
    }

    private HBox buildPanel(VkSource source) {

        HBox mainBox = new HBox();
        VBox leftBlock = new VBox();
        VBox rightBlock = new VBox();
        rightBlock.setMaxWidth(Double.MAX_VALUE);

        Label header = new Label(source.getName());
        Label lore = new Label(source.getLore());
        header.setFont(Font.font("Veranda", 14));
        lore.setFont(Font.font("Veranda",12));
        leftBlock.getChildren().addAll(header, lore);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(mainBox, Priority.ALWAYS);
        VBox propertiesButton = new VBox();
        ImageView propertiesIcon = new ImageView(new Image("ex/resources/dots-vertical.png"));
        propertiesButton.getChildren().addAll(propertiesIcon);
        rightBlock.getChildren().addAll(propertiesButton);

        mainBox.setPadding(new Insets(10,13,10,13));
        mainBox.getChildren().addAll(leftBlock, spacer, rightBlock);
        return mainBox;
    }
}
