package ex.obj.subscriptions;

import javafx.scene.layout.GridPane;

public class VkSource {

    private String name;
    private String iconUrl;
    private String lore;
    private String domain;
    private GridPane body;

    public void setName(String mName) {
        this.name = mName;
    }

    public String getName() {
        return this.name;
    }

    public void setIconUrl(String mIconUrl) {
        this.iconUrl = mIconUrl;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setLore(String mLore) {
        this.lore = mLore;
    }

    public String getLore() {
        return this.lore;
    }

    public void setDomain(String mDomain) {
        this.domain = mDomain;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setBody(GridPane mGridPane) {
        this.body = mGridPane;
    }

    public GridPane getBody() {
        return this.body;
    }
}
