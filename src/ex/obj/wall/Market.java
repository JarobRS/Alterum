
package ex.obj.wall;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Market {

    @SerializedName("availability")
    private Long mAvailability;
    @SerializedName("category")
    private Category mCategory;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("price")
    private Price mPrice;
    @SerializedName("thumb_photo")
    private String mThumbPhoto;
    @SerializedName("title")
    private String mTitle;

    public Long getAvailability() {
        return mAvailability;
    }

    public void setAvailability(Long availability) {
        mAvailability = availability;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
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

    public Price getPrice() {
        return mPrice;
    }

    public void setPrice(Price price) {
        mPrice = price;
    }

    public String getThumbPhoto() {
        return mThumbPhoto;
    }

    public void setThumbPhoto(String thumbPhoto) {
        mThumbPhoto = thumbPhoto;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
