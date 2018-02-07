
package ex.obj.sources.user;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Personal {

    @SerializedName("alcohol")
    private Long mAlcohol;
    @SerializedName("inspired_by")
    private String mInspiredBy;
    @SerializedName("life_main")
    private Long mLifeMain;
    @SerializedName("people_main")
    private Long mPeopleMain;
    @SerializedName("religion")
    private String mReligion;
    @SerializedName("smoking")
    private Long mSmoking;

    public Long getAlcohol() {
        return mAlcohol;
    }

    public void setAlcohol(Long alcohol) {
        mAlcohol = alcohol;
    }

    public String getInspiredBy() {
        return mInspiredBy;
    }

    public void setInspiredBy(String inspiredBy) {
        mInspiredBy = inspiredBy;
    }

    public Long getLifeMain() {
        return mLifeMain;
    }

    public void setLifeMain(Long lifeMain) {
        mLifeMain = lifeMain;
    }

    public Long getPeopleMain() {
        return mPeopleMain;
    }

    public void setPeopleMain(Long peopleMain) {
        mPeopleMain = peopleMain;
    }

    public String getReligion() {
        return mReligion;
    }

    public void setReligion(String religion) {
        mReligion = religion;
    }

    public Long getSmoking() {
        return mSmoking;
    }

    public void setSmoking(Long smoking) {
        mSmoking = smoking;
    }

}
