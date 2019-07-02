package com.gaurav.exoplayerandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("coverUrl")
    @Expose
    private String coverUrl;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;

    public VideoModel(Integer id, String title, String userName, String coverUrl, String videoUrl) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.coverUrl = coverUrl;
        this.videoUrl = videoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
