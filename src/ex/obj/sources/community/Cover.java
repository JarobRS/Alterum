
package ex.obj.sources.community;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Cover {

    @SerializedName("enabled")
    private Long mEnabled;
    @SerializedName("images")
    private List<Image> mImages;

    public Long getEnabled() {
        return mEnabled;
    }

    public void setEnabled(Long enabled) {
        mEnabled = enabled;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

}
