
package ex.obj;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PostList {

    @SerializedName("response")
    private List<Object> mResponse;

    public List<Object> getResponse() {
        return mResponse;
    }

    public void setResponse(List<Object> response) {
        mResponse = response;
    }

}
