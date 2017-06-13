
package ex.obj.sources.user;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LastSeen {

    @SerializedName("platform")
    private Long mPlatform;
    @SerializedName("time")
    private Long mTime;

    public Long getPlatform() {
        return mPlatform;
    }

    public void setPlatform(Long platform) {
        mPlatform = platform;
    }

    public Long getTime() {
        return mTime;
    }

    public void setTime(Long time) {
        mTime = time;
    }

}
