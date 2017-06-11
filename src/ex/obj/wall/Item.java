
package ex.obj.wall;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item {

    @SerializedName("attachments")
    private List<Attachment> mAttachments;
    @SerializedName("comments")
    private Comments mComments;
    @SerializedName("copy_history")
    private List<CopyHistory> mCopyHistory;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("from_id")
    private Long mFromId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("is_pinned")
    private Long mIsPinned;
    @SerializedName("likes")
    private Likes mLikes;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("post_type")
    private String mPostType;
    @SerializedName("reposts")
    private Reposts mReposts;
    @SerializedName("text")
    private String mText;
    @SerializedName("views")
    private Views mViews;

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

    public List<CopyHistory> getCopyHistory() {
        return mCopyHistory;
    }

    public void setCopyHistory(List<CopyHistory> copyHistory) {
        mCopyHistory = copyHistory;
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

    public Long getIsPinned() {
        return mIsPinned;
    }

    public void setIsPinned(Long isPinned) {
        mIsPinned = isPinned;
    }

    public Likes getLikes() {
        return mLikes;
    }

    public void setLikes(Likes likes) {
        mLikes = likes;
    }

    public Long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(Long ownerId) {
        mOwnerId = ownerId;
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

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Views getViews() {
        return mViews;
    }

    public void setViews(Views views) {
        mViews = views;
    }

}
