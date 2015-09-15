package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;

public class Recommend {
	private Integer id;

	private Date addTime;

	private Date topTime;

	private String location;

	private String title;

	private String description;

	private String logo;
	
	private String videoBaseIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public String getVideoBaseIds() {
		return videoBaseIds;
	}

	public void setVideoBaseIds(String videoBaseIds) {
		this.videoBaseIds = videoBaseIds;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}
}