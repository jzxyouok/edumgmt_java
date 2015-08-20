package net.shinc.orm.mybatis.bean.edu;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: VideoPoint
 * @Description: 知识点信息
 * @author hushichong
 * @date 2015年7月31日 下午3:48:37
 */
public class VideoPoint {

	private Integer id;

	private Integer videoBaseId;

	// 基础信息
	@NotNull
	@Valid
	private VideoBase videoBase;

	// 有无视频
	private String hasVideo;

	private String kewordIds;
	
	private String knowledgePointIds;
	
	public Integer getId() {
		return id;
	}

	public String getKnowledgePointIds() {
		return knowledgePointIds;
	}

	public void setKnowledgePointIds(String knowledgePointIds) {
		this.knowledgePointIds = knowledgePointIds;
	}

	public String getKewordIds() {
		return kewordIds;
	}

	public void setKewordIds(String kewordIds) {
		this.kewordIds = kewordIds;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public String getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(String hasVideo) {
		this.hasVideo = hasVideo;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public VideoBase getVideoBase() {
		return videoBase;
	}

	public void setVideoBase(VideoBase videoBase) {
		this.videoBase = videoBase;
	}

}