
package ex.obj;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("attachment")
    private Attachment mAttachment;
    @SerializedName("attachments")
    private List<Attachment> mAttachments;
    @SerializedName("comments")
    private Comments mComments;
    @SerializedName("copy_owner_id")
    private Long mCopyOwnerId;
    @SerializedName("copy_post_date")
    private Long mCopyPostDate;
    @SerializedName("copy_post_id")
    private Long mCopyPostId;
    @SerializedName("copy_post_type")
    private String mCopyPostType;
    @SerializedName("copy_text")
    private String mCopyText;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("from_id")
    private Long mFromId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("likes")
    private Likes mLikes;
    @SerializedName("post_type")
    private String mPostType;
    @SerializedName("reposts")
    private Reposts mReposts;
    @SerializedName("signer_id")
    private Long mSignerId;
    @SerializedName("text")
    private String mText;
    @SerializedName("to_id")
    private Long mToId;

    public Attachment getAttachment() {
        return mAttachment;
    }

    public void setAttachment(Attachment attachment) {
        mAttachment = attachment;
    }

    public List<Attachment> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        mAttachments = attachments;
    }

    public Comments getComments() {
        return mComments;
    }

    public void setComments(Comments comments) {
        mComments = comments;
    }

    public Long getCopyOwnerId() {
        return mCopyOwnerId;
    }

    public void setCopyOwnerId(Long copyOwnerId) {
        mCopyOwnerId = copyOwnerId;
    }

    public Long getCopyPostDate() {
        return mCopyPostDate;
    }

    public void setCopyPostDate(Long copyPostDate) {
        mCopyPostDate = copyPostDate;
    }

    public Long getCopyPostId() {
        return mCopyPostId;
    }

    public void setCopyPostId(Long copyPostId) {
        mCopyPostId = copyPostId;
    }

    public String getCopyPostType() {
        return mCopyPostType;
    }

    public void setCopyPostType(String copyPostType) {
        mCopyPostType = copyPostType;
    }

    public String getCopyText() {
        return mCopyText;
    }

    public void setCopyText(String copyText) {
        mCopyText = copyText;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getFromId() {
        return mFromId;
    }

    public void setFromId(Long fromId) {
        mFromId = fromId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Likes getLikes() {
        return mLikes;
    }

    public void setLikes(Likes likes) {
        mLikes = likes;
    }

    public String getPostType() {
        return mPostType;
    }

    public void setPostType(String postType) {
        mPostType = postType;
    }

    public Reposts getReposts() {
        return mReposts;
    }

    public void setReposts(Reposts reposts) {
        mReposts = reposts;
    }

    public Long getSignerId() {
        return mSignerId;
    }

    public void setSignerId(Long signerId) {
        mSignerId = signerId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Long getToId() {
        return mToId;
    }

    public void setToId(Long toId) {
        mToId = toId;
    }

}
