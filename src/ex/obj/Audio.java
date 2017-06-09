
package ex.obj;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Audio {

    @SerializedName("aid")
    private Long mAid;
    @SerializedName("album")
    private Long mAlbum;
    @SerializedName("artist")
    private String mArtist;
    @SerializedName("content_restricted")
    private Long mContentRestricted;
    @SerializedName("duration")
    private Long mDuration;
    @SerializedName("genre")
    private Long mGenre;
    @SerializedName("lyrics_id")
    private Long mLyricsId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("performer")
    private String mPerformer;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;

    public Long getAid() {
        return mAid;
    }

    public void setAid(Long aid) {
        mAid = aid;
    }

    public Long getAlbum() {
        return mAlbum;
    }

    public void setAlbum(Long album) {
        mAlbum = album;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public Long getContentRestricted() {
        return mContentRestricted;
    }

    public void setContentRestricted(Long contentRestricted) {
        mContentRestricted = contentRestricted;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Long getGenre() {
        return mGenre;
    }

    public void setGenre(Long genre) {
        mGenre = genre;
    }

    public Long getLyricsId() {
        return mLyricsId;
    }

    public void setLyricsId(Long lyricsId) {
        mLyricsId = lyricsId;
    }

    public Long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(Long ownerId) {
        mOwnerId = ownerId;
    }

    public String getPerformer() {
        return mPerformer;
    }

    public void setPerformer(String performer) {
        mPerformer = performer;
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
