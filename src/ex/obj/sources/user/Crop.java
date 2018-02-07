
package ex.obj.sources.user;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Crop {

    @SerializedName("x")
    private Double mX;
    @SerializedName("x2")
    private Double mX2;
    @SerializedName("y")
    private Double mY;
    @SerializedName("y2")
    private Double mY2;

    public Double getX() {
        return mX;
    }

    public void setX(Double x) {
        mX = x;
    }

    public Double getX2() {
        return mX2;
    }

    public void setX2(Double x2) {
        mX2 = x2;
    }

    public Double getY() {
        return mY;
    }

    public void setY(Double y) {
        mY = y;
    }

    public Double getY2() {
        return mY2;
    }

    public void setY2(Double y2) {
        mY2 = y2;
    }

}
