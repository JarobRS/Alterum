
package ex.obj.wall;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Doc {

    @SerializedName("access_key")
    private String mAccessKey;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("ext")
    private String mExt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("preview")
    private Preview mPreview;
    @SerializedName("size")
    private Long mSize;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private Long mType;
    @SerializedName("url")
    private String mUrl;

    public String getAccessKey() {
        return mAccessKey;
    }

    public void setAccessKey(String accessKey) {
        mAccessKey = accessKey;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public String getExt() {
        return mExt;
    }

    public void setExt(String ext) {
        mExt = ext;
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

    public Preview getPreview() {
        return mPreview;
    }

    public void setPreview(Preview preview) {
        mPreview = preview;
    }

    public Long getSize() {
        return mSize;
    }

    public void setSize(Long size) {
        mSize = size;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
