
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Page {

    @SerializedName("gid")
    private Long mGid;
    @SerializedName("pid")
    private String mPid;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("view_url")
    private String mViewUrl;

    public Long getGid() {
        return mGid;
    }

    public void setGid(Long gid) {
        mGid = gid;
    }

    public String getPid() {
        return mPid;
    }

    public void setPid(String pid) {
        mPid = pid;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getViewUrl() {
        return mViewUrl;
    }

    public void setViewUrl(String viewUrl) {
        mViewUrl = viewUrl;
    }

}
