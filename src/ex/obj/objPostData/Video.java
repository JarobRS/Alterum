package ex.obj.objPostData;

public class Video {
    private String platform;
    private String duration;
    private String title;
    private String views;
    private String description;
    private String image_xbig;
    private String owner_id;
    private String image_small;
    private String image;
    private String access_key;
    private String date;
    private String vid;
    private String image_big;

    public String getPlatform () {
        return platform;
    }

    public void setPlatform (String platform) {
        this.platform = platform;
    }

    public String getDuration () {
        return duration;
    }

    public void setDuration (String duration) {
        this.duration = duration;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getViews () {
        return views;
    }

    public void setViews (String views) {
        this.views = views;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getImage_xbig () {
        return image_xbig;
    }

    public void setImage_xbig (String image_xbig) {
        this.image_xbig = image_xbig;
    }

    public String getOwner_id () {
        return owner_id;
    }

    public void setOwner_id (String owner_id) {
        this.owner_id = owner_id;
    }

    public String getImage_small () {
        return image_small;
    }

    public void setImage_small (String image_small) {
        this.image_small = image_small;
    }

    public String getImage () {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public String getAccess_key () {
        return access_key;
    }

    public void setAccess_key (String access_key) {
        this.access_key = access_key;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getVid () {
        return vid;
    }

    public void setVid (String vid) {
        this.vid = vid;
    }

    public String getImage_big () {
        return image_big;
    }

    public void setImage_big (String image_big) {
        this.image_big = image_big;
    }

    @Override
    public String toString() {
        return "ClassPojo [platform = "+platform+", duration = "+duration+", title = "+title+", views = "+views+", description = "+description+", image_xbig = "+image_xbig+", owner_id = "+owner_id+", image_small = "+image_small+", image = "+image+", access_key = "+access_key+", date = "+date+", vid = "+vid+", image_big = "+image_big+"]";
    }
}