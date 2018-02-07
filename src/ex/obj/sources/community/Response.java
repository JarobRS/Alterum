
package ex.obj.sources.community;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("activity")
    private String mActivity;
    @SerializedName("contacts")
    private List<Contact> mContacts;
    @SerializedName("counters")
    private Counters mCounters;
    @SerializedName("cover")
    private Cover mCover;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("fixed_post")
    private Long mFixedPost;
    @SerializedName("id")
    private Long mId;
    @SerializedName("is_closed")
    private Long mIsClosed;
    @SerializedName("links")
    private List<Link> mLinks;
    @SerializedName("members_count")
    private Long mMembersCount;
    @SerializedName("name")
    private String mName;
    @SerializedName("photo_100")
    private String mPhoto100;
    @SerializedName("photo_200")
    private String mPhoto200;
    @SerializedName("photo_50")
    private String mPhoto50;
    @SerializedName("screen_name")
    private String mScreenName;
    @SerializedName("site")
    private String mSite;
    @SerializedName("start_date")
    private Long mStartDate;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("type")
    private String mType;
    @SerializedName("verified")
    private Long mVerified;

    public String getActivity() {
        return mActivity;
    }

    public void setActivity(String activity) {
        mActivity = activity;
    }

    public List<Contact> getContacts() {
        return mContacts;
    }

    public void setContacts(List<Contact> contacts) {
        mContacts = contacts;
    }

    public Counters getCounters() {
        return mCounters;
    }

    public void setCounters(Counters counters) {
        mCounters = counters;
    }

    public Cover getCover() {
        return mCover;
    }

    public void setCover(Cover cover) {
        mCover = cover;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getFixedPost() {
        return mFixedPost;
    }

    public void setFixedPost(Long fixedPost) {
        mFixedPost = fixedPost;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getIsClosed() {
        return mIsClosed;
    }

    public void setIsClosed(Long isClosed) {
        mIsClosed = isClosed;
    }

    public List<Link> getLinks() {
        return mLinks;
    }

    public void setLinks(List<Link> links) {
        mLinks = links;
    }

    public Long getMembersCount() {
        return mMembersCount;
    }

    public void setMembersCount(Long membersCount) {
        mMembersCount = membersCount;
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

    public String getPhoto200() {
        return mPhoto200;
    }

    public void setPhoto200(String photo200) {
        mPhoto200 = photo200;
    }

    public String getPhoto50() {
        return mPhoto50;
    }

    public void setPhoto50(String photo50) {
        mPhoto50 = photo50;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public void setScreenName(String screenName) {
        mScreenName = screenName;
    }

    public String getSite() {
        return mSite;
    }

    public void setSite(String site) {
        mSite = site;
    }

    public Long getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Long startDate) {
        mStartDate = startDate;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long getVerified() {
        return mVerified;
    }

    public void setVerified(Long verified) {
        mVerified = verified;
    }

}
