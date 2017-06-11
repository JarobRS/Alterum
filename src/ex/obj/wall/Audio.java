
package ex.obj.wall;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Audio {

    @SerializedName("album_id")
    private Long mAlbumId;
    @SerializedName("artist")
    private String mArtist;
    @SerializedName("content_restricted")
    private Long mContentRestricted;
    @SerializedName("date")
    private Long mDate;
    @SerializedName("duration")
    private Long mDuration;
    @SerializedName("genre_id")
    private Long mGenreId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("lyrics_id")
    private Long mLyricsId;
    @SerializedName("owner_id")
    private Long mOwnerId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;

    public Long getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(Long albumId) {
        mAlbumId = albumId;
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

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long duration) {
        mDuration = duration;
    }

    public Long getGenreId() {
        return mGenreId;
    }

    public void setGenreId(Long genreId) {
        mGenreId = genreId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
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
