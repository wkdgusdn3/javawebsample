package com.girltv.core.model;

public class Video {
	private int videoId;
	private String videoTitle;
	private String videoUrl;
	private String videoArticle;
	private String singerName;
	
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoArticle() {
		return videoArticle;
	}
	public void setVideoArticle(String videoArticle) {
		this.videoArticle = videoArticle;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
}
