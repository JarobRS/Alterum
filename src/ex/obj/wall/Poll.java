
package ex.obj.wall;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Poll {

    @SerializedName("anonymous")
    private Long mAnonymous;
    @SerializedName("answer_id")
    private Long mAnswerId;
    @SerializedName("answers")
    private List<Answer> mAnswers;
    @SerializedName("created")
    private Long mCreated;
    @SerializedName("id")
    private Long mId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("question")
    private String mQuestion;
    @SerializedName("votes")
    private Long mVotes;

    public Long getAnonymous() {
        return mAnonymous;
    }

    public void setAnonymous(Long anonymous) {
        mAnonymous = anonymous;
    }

    public Long getAnswerId() {
        return mAnswerId;
    }

    public void setAnswerId(Long answerId) {
        mAnswerId = answerId;
    }

    public List<Answer> getAnswers() {
        return mAnswers;
    }

    public void setAnswers(List<Answer> answers) {
        mAnswers = answers;
    }

    public Long getCreated() {
        return mCreated;
    }

    public void setCreated(Long created) {
        mCreated = created;
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

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public Long getVotes() {
        return mVotes;
    }

    public void setVotes(Long votes) {
        mVotes = votes;
    }

}
