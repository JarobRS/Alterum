package ex.obj.objPostData;

public class Audio {
    private String genre;
    private String duration;
    private String title;
    private String owner_id;
    private String performer;
    private String artist;
    private String aid;
    private String url;
    public String getGenre () {
        return genre;
    }

    public void setGenre (String genre) {
        this.genre = genre;
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

    public String getOwner_id () {
        return owner_id;
    }

    public void setOwner_id (String owner_id) {
        this.owner_id = owner_id;
    }

    public String getPerformer () {
        return performer;
    }

    public void setPerformer (String performer) {
        this.performer = performer;
    }

    public String getArtist () {
        return artist;
    }

    public void setArtist (String artist) {
        this.artist = artist;
    }

    public String getAid () {
        return aid;
    }

    public void setAid (String aid) {
        this.aid = aid;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPojo [genre = "+genre+", duration = "+duration+", title = "+title+", owner_id = "+owner_id+", performer = "+performer+", artist = "+artist+", aid = "+aid+", url = "+url+"]";
    }
}