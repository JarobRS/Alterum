package ex.obj.objPostData;

public class Response {
    private String text;
    private String copy_post_type;
    private Attachments attachment;
    private String date;
    private String copy_owner_id;
    private String id;
    private String copy_post_date;
    private String copy_post_id;
    private String to_id;
    private Reposts reposts;
    private String from_id;
    private Likes likes;
    private String post_type;
    private Attachments[] attachments;
    private Comments comments;
    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getCopy_post_type () {
        return copy_post_type;
    }

    public void setCopy_post_type (String copy_post_type) {
        this.copy_post_type = copy_post_type;
    }

    public Attachments getAttachment () {
        return attachment;
    }

    public void setAttachment (Attachments attachment) {
        this.attachment = attachment;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getCopy_owner_id () {
        return copy_owner_id;
    }

    public void setCopy_owner_id (String copy_owner_id) {
        this.copy_owner_id = copy_owner_id;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getCopy_post_date () {
        return copy_post_date;
    }

    public void setCopy_post_date (String copy_post_date) {
        this.copy_post_date = copy_post_date;
    }

    public String getCopy_post_id () {
        return copy_post_id;
    }

    public void setCopy_post_id (String copy_post_id) {
        this.copy_post_id = copy_post_id;
    }

    public String getTo_id () {
        return to_id;
    }

    public void setTo_id (String to_id) {
        this.to_id = to_id;
    }

    public Reposts getReposts () {
        return reposts;
    }

    public void setReposts (Reposts reposts) {
        this.reposts = reposts;
    }

    public String getFrom_id () {
        return from_id;
    }

    public void setFrom_id (String from_id) {
        this.from_id = from_id;
    }

    public Likes getLikes () {
        return likes;
    }

    public void setLikes (Likes likes) {
        this.likes = likes;
    }

    public String getPost_type () {
        return post_type;
    }

    public void setPost_type (String post_type) {
        this.post_type = post_type;
    }

    public Attachments[] getAttachments () {
        return attachments;
    }

    public void setAttachments (Attachments[] attachments) {
        this.attachments = attachments;
    }

    public Comments getComments () {
        return comments;
    }

    public void setComments (Comments comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ClassPojo [text = "+text+", copy_post_type = "+copy_post_type+", attachment = "+attachment+", date = "+date+", copy_owner_id = "+copy_owner_id+", id = "+id+", copy_post_date = "+copy_post_date+", copy_post_id = "+copy_post_id+", to_id = "+to_id+", reposts = "+reposts+", from_id = "+from_id+", likes = "+likes+", post_type = "+post_type+", attachments = "+attachments+", comments = "+comments+"]";
    }
}
