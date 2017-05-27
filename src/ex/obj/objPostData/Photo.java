package ex.obj.objPostData;

public class Photo {
    private String text;
    private String height;
    private String src_small;
    private String created;
    private String width;
    private String owner_id;
    private String pid;
    private String access_key;
    private String src;
    private String aid;
    private String src_xbig;
    private String src_big;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSrc_small() {
        return src_small;
    }

    public void setSrc_small(String src_small) {
        this.src_small = src_small;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getSrc_xbig() {
        return src_xbig;
    }

    public void setSrc_xbig(String src_xbig) {
        this.src_xbig = src_xbig;
    }

    public String getSrc_big() {
        return src_big;
    }

    public void setSrc_big(String src_big) {
        this.src_big = src_big;
    }

    @Override
    public String toString() {
        return "ClassPojo [text = " + text + ", height = " + height + ", src_small = " + src_small + ", created = " + created + ", width = " + width + ", owner_id = " + owner_id + ", pid = " + pid + ", access_key = " + access_key + ", src = " + src + ", aid = " + aid + ", src_xbig = " + src_xbig + ", src_big = " + src_big + "]";
    }
}