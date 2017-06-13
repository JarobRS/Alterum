
package ex.obj.sources.community;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Link {

    @SerializedName("desc")
    private String mDesc;
    @SerializedName("edit_title")
    private Long mEditTitle;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("photo_100")
    private String mPhoto100;
    @SerializedName("photo_50")
    private String mPhoto50;
    @SerializedName("url")
    private String mUrl;

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public Long getEditTitle() {
        return mEditTitle;
    }

    public void setEditTitle(Long editTitle) {
        mEditTitle = editTitle;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhoto100() {
        return mPhoto100;
    }

    public void setPhoto100(String photo100) {
        mPhoto100 = photo100;
    }

    public String getPhoto50() {
        return mPhoto50;
    }

    public void setPhoto50(String photo50) {
        mPhoto50 = photo50;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
