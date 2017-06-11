
package ex.obj.wall;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Page {

    @SerializedName("created")
    private Long mCreated;
    @SerializedName("edited")
    private Long mEdited;
    @SerializedName("group_id")
    private Long mGroupId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("view_url")
    private String mViewUrl;
    @SerializedName("views")
    private Long mViews;
    @SerializedName("who_can_edit")
    private Long mWhoCanEdit;
    @SerializedName("who_can_view")
    private Long mWhoCanView;

    public Long getCreated() {
        return mCreated;
    }

    public void setCreated(Long created) {
        mCreated = created;
    }

    public Long getEdited() {
        return mEdited;
    }

    public void setEdited(Long edited) {
        mEdited = edited;
    }

    public Long getGroupId() {
        return mGroupId;
    }

    public void setGroupId(Long groupId) {
        mGroupId = groupId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
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

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

    public Long getWhoCanEdit() {
        return mWhoCanEdit;
    }

    public void setWhoCanEdit(Long whoCanEdit) {
        mWhoCanEdit = whoCanEdit;
    }

    public Long getWhoCanView() {
        return mWhoCanView;
    }

    public void setWhoCanView(Long whoCanView) {
        mWhoCanView = whoCanView;
    }

}
