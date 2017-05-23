package ex.obj;

import java.util.List;
import ex.obj.objPostData.*;

    public class ObjPost {
        public int id;
        public int from_id;
        public int to_id;
        public int date;
        public String post_type;
        public String text;

        public Attachment attachment;
        public List<Attachment> attachments;
        public Comments comments;
        public Likes likes;
        public Reposts reposts;

        public ObjPost() {
        }

        public ObjPost(int _id, int _from_id, int _to_id, int _date, String _post_type,
                       Attachment _attachment,
                       List<Attachment> _attachments,
                       Comments _comments,
                       Likes _likes,
                       Reposts _reposts) {
            id = _id;
            from_id = _from_id;
            to_id = _to_id;
            date = _date;
            post_type = _post_type;
            attachment = _attachment;
            attachments = _attachments;
            comments = _comments;
            likes = _likes;
            reposts = _reposts;
        }

        public List<Attachment> getAttachments() {
            return attachments;
        }

        public int getLikes() {
            return likes.count;
        }

        public void setAttachments(List<Attachment> _attachments) {
            this.attachments = _attachments;
        }

        /*
        @Override
        public String toString() {
            return "User [name=" + name + ", age=" + age + ", messages="
                    + messages + "]";
        }
        */
    }