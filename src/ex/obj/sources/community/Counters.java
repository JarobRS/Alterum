
package ex.obj.sources.community;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Counters {

    @SerializedName("albums")
    private Long mAlbums;
    @SerializedName("photos")
    private Long mPhotos;
    @SerializedName("topics")
    private Long mTopics;
    @SerializedName("videos")
    private Long mVideos;

    public Long getAlbums() {
        return mAlbums;
    }

    public void setAlbums(Long albums) {
        mAlbums = albums;
    }

    public Long getPhotos() {
        return mPhotos;
    }

    public void setPhotos(Long photos) {
        mPhotos = photos;
    }

    public Long getTopics() {
        return mTopics;
    }

    public void setTopics(Long topics) {
        mTopics = topics;
    }

    public Long getVideos() {
        return mVideos;
    }

    public void setVideos(Long videos) {
        mVideos = videos;
    }

}
