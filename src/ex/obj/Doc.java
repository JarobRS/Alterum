
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Doc {

    @SerializedName("access_key")
    private String mAccessKey;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("did")
    private Long mDid;
    @SerializedName("ext")
    private String mExt;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("size")
    private Long mSize;
    @SerializedName("thumb")
    private String mThumb;
    @SerializedName("thumb_s")
    private String mThumbS;
    @SerializedName("title")
    private String mTitle;
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

    public Long getDid() {
        return mDid;
    }

    public void setDid(Long did) {
        mDid = did;
    }

    public String getExt() {
        return mExt;
    }

    public void setExt(String ext) {
        mExt = ext;
    }

    public Long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(Long ownerId) {
        mOwnerId = ownerId;
    }

    public Long getSize() {
        return mSize;
    }

    public void setSize(Long size) {
        mSize = size;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getThumbS() {
        return mThumbS;
    }

    public void setThumbS(String thumbS) {
        mThumbS = thumbS;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
