package ex.obj.objPostData;

public class Attachments {
    private String type;
    private Photo photo;

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public Photo getPhoto () {
        return photo;
    }

    public void setPhoto (Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ClassPojo [type = "+type+", photo = "+photo+"]";
    }
}