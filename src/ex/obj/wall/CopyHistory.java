
package ex.obj.wall;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CopyHistory {

    @SerializedName("attachments")
    private List<Attachment> mAttachments;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("from_id")
    private Long mFromId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("post_source")
    private PostSource mPostSource;
    @SerializedName("post_type")
    private String mPostType;
    @SerializedName("signer_id")
    private Long mSignerId;
    @SerializedName("text")
    private String mText;

    public List<Attachment> getAttachments() {
        return mAttachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        mAttachments = attachments;
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

    public Long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(Long ownerId) {
        mOwnerId = ownerId;
    }

    public PostSource getPostSource() {
        return mPostSource;
    }

    public void setPostSource(PostSource postSource) {
        mPostSource = postSource;
    }

    public String getPostType() {
        return mPostType;
    }

    public void setPostType(String postType) {
        mPostType = postType;
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

}
