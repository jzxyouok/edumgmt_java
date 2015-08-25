package net.shinc.orm.mybatis.bean.edu;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: VideoSelf
 * @Description: 自编题信息
 * @author hushichong
 * @date 2015年7月31日 下午3:51:17
 */
public class VideoSelf {

	private Integer id;

	private Integer videoBaseId;
	
	private String resource;

	private String type;

	@NotNull(message = "{videoSelf.questionTypeId.not.empty}")
	private Integer questionTypeId;

	// 基础信息
	@NotNull
	@Valid
	private VideoBase videoBase;

	// 题型 （单选、多选）
	private QuestionType questionType;

	// 题库 （中考真题，高考真题）
	private QuestionBank questionBank;

	// 有无视频
	private String hasVideo;

	private String kewordIds;
	
	private String knowledgePointIds;
	
	public Integer getId() {
		return id;
	}

	public String getKewordIds() {
		return kewordIds;
	}

	public String getKnowledgePointIds() {
		return knowledgePointIds;
	}

	public void setKnowledgePointIds(String knowledgePointIds) {
		this.knowledgePointIds = knowledgePointIds;
	}

	public void setKewordIds(String kewordIds) {
		this.kewordIds = kewordIds;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	public String getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(String hasVideo) {
		this.hasVideo = hasVideo;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
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

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

}