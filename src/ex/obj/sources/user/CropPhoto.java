
package ex.obj.sources.user;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CropPhoto {

    @SerializedName("crop")
    private Crop mCrop;
    @SerializedName("photo")
    private Photo mPhoto;
    @SerializedName("rect")
    private Rect mRect;

    public Crop getCrop() {
        return mCrop;
    }

    public void setCrop(Crop crop) {
        mCrop = crop;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    public Rect getRect() {
        return mRect;
    }

    public void setRect(Rect rect) {
        mRect = rect;
    }

}
