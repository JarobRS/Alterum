package ex.obj.objPostData;

public class Link {
    private String title;
    private String description;
    private String target;
    private String url;

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getTarget () {
        return target;
    }

    public void setTarget (String target) {
        this.target = target;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPojo [title = "+title+", description = "+description+", target = "+target+", url = "+url+"]";
    }
}