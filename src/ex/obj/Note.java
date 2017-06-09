
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Note {

    @SerializedName("ncom")
    private Long mNcom;
    @SerializedName("nid")
    private Long mNid;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("title")
    private String mTitle;

    public Long getNcom() {
        return mNcom;
    }

    public void setNcom(Long ncom) {
        mNcom = ncom;
    }

    public Long getNid() {
        return mNid;
    }

    public void setNid(Long nid) {
        mNid = nid;
    }

    public Long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(Long ownerId) {
        mOwnerId = ownerId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
