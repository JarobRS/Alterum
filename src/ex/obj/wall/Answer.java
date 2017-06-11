
package ex.obj.wall;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Answer {

    @SerializedName("id")
    private Long mId;
    @SerializedName("rate")
    private Double mRate;
    @SerializedName("text")
    private String mText;
    @SerializedName("votes")
    private Long mVotes;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Double getRate() {
        return mRate;
    }

    public void setRate(Double rate) {
        mRate = rate;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Long getVotes() {
        return mVotes;
    }

    public void setVotes(Long votes) {
        mVotes = votes;
    }

}
