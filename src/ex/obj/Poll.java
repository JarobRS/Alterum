
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Poll {

    @SerializedName("poll_id")
    private Long mPollId;
    @SerializedName("question")
    private String mQuestion;

    public Long getPollId() {
        return mPollId;
    }

    public void setPollId(Long pollId) {
        mPollId = pollId;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

}
