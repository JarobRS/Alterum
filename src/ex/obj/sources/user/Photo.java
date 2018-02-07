
package ex.obj.sources.user;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Photo {

    @SerializedName("album_id")
    private Long mAlbumId;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("height")
    private Long mHeight;
    @SerializedName("id")
    private Long mId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("photo_130")
    private String mPhoto130;
    @SerializedName("photo_604")
    private String mPhoto604;
    @SerializedName("photo_75")
    private String mPhoto75;
    @SerializedName("post_id")
    private Long mPostId;
    @SerializedName("text")
    private String mText;
    @SerializedName("width")
    private Long mWidth;

    public Long getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(Long albumId) {
        mAlbumId = albumId;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
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

    public String getPhoto130() {
        return mPhoto130;
    }

    public void setPhoto130(String photo130) {
        mPhoto130 = photo130;
    }

    public String getPhoto604() {
        return mPhoto604;
    }

    public void setPhoto604(String photo604) {
        mPhoto604 = photo604;
    }

    public String getPhoto75() {
        return mPhoto75;
    }

    public void setPhoto75(String photo75) {
        mPhoto75 = photo75;
    }

    public Long getPostId() {
        return mPostId;
    }

    public void setPostId(Long postId) {
        mPostId = postId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

}
