package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;

public class RecommendHasVideoBase {
	private Integer id;

	private Integer recommendId;

	private Integer videoBaseId;

	private Date addTime;

	private Date topTime;

	private String videoType;

	private String dimension;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(Integer recommendId) {
		this.recommendId = recommendId;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public Date getAddTime() {
		return addTime;
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

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType == null ? null : videoType.trim();
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension == null ? null : dimension.trim();
	}
}