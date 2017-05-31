
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Link {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("image_big")
    private String mImageBig;
    @SerializedName("image_src")
    private String mImageSrc;
    @SerializedName("target")
    private String mTarget;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageBig() {
        return mImageBig;
    }

    public void setImageBig(String imageBig) {
        mImageBig = imageBig;
    }

    public String getImageSrc() {
        return mImageSrc;
    }

    public void setImageSrc(String imageSrc) {
        mImageSrc = imageSrc;
    }

    public String getTarget() {
        return mTarget;
    }

    public void setTarget(String target) {
        mTarget = target;
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
