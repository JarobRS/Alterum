package ex.obj;

public final class PostList {
    public final Response response[];

    public PostList(Response[] response){
        this.response = response;
    }

    public static final class Response {
        public final Long id;
        public final Long from_id;
        public final Long to_id;
        public final Long date;
        public final String post_type;
        public final String text;
        public final Long copy_post_date;
        public final String copy_post_type;
        public final Long copy_owner_id;
        public final Long copy_post_id;
        public final Attachment attachment;
        public final Attachment attachments[];
        public final Comments comments;
        public final Likes likes;
        public final Reposts reposts;
        public final long signer_id;
        public final String copy_text;

        public Response(Long id, Long from_id, Long to_id, Long date, String post_type, String text, Long copy_post_date, String copy_post_type, Long copy_owner_id, Long copy_post_id, Attachment attachment, Attachment[] attachments, Comments comments, Likes likes, Reposts reposts, long signer_id, String copy_text){
            this.id = id;
            this.from_id = from_id;
            this.to_id = to_id;
            this.date = date;
            this.post_type = post_type;
            this.text = text;
            this.copy_post_date = copy_post_date;
            this.copy_post_type = copy_post_type;
            this.copy_owner_id = copy_owner_id;
            this.copy_post_id = copy_post_id;
            this.attachment = attachment;
            this.attachments = attachments;
            this.comments = comments;
            this.likes = likes;
            this.reposts = reposts;
            this.signer_id = signer_id;
            this.copy_text = copy_text;
        }

        public static final class Attachment {
            public final String type;
            public final Photo photo;

            public Attachment(String type, Photo photo){
                this.type = type;
                this.photo = photo;
            }

            public static final class Photo {
                public final long pid;
                public final long aid;
                public final long owner_id;
                public final long user_id;
                public final String src;
                public final String src_big;
                public final String src_small;
                public final String src_xbig;
                public final long width;
                public final long height;
                public final String text;
                public final long created;
                public final long post_id;
                public final String access_key;

                public Photo(long pid, long aid, long owner_id, long user_id, String src, String src_big, String src_small, String src_xbig, long width, long height, String text, long created, long post_id, String access_key){
                    this.pid = pid;
                    this.aid = aid;
                    this.owner_id = owner_id;
                    this.user_id = user_id;
                    this.src = src;
                    this.src_big = src_big;
                    this.src_small = src_small;
                    this.src_xbig = src_xbig;
                    this.width = width;
                    this.height = height;
                    this.text = text;
                    this.created = created;
                    this.post_id = post_id;
                    this.access_key = access_key;
                }
            }
        }

        public static final class Comments {
            public final long count;

            public Comments(long count){
                this.count = count;
            }
        }

        public static final class Likes {
            public final long count;

            public Likes(long count){
                this.count = count;
            }
        }

        public static final class Reposts {
            public final long count;

            public Reposts(long count){
                this.count = count;
            }
        }
    }
}