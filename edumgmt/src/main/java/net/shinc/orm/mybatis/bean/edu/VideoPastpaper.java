package net.shinc.orm.mybatis.bean.edu;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: VideoPastpaper
 * @Description: 真题、模拟题具体信息
 * @author hushichong
 * @date 2015年7月31日 下午3:41:54
 */
public class VideoPastpaper {

	private Integer id;

	private Integer videoBaseId;

	@NotNull(message = "{videoPastpaper.questionbankId.not.empty}")
	private Integer questionbankId;

	@NotNull(message = "{videoPastpaper.questionbankYearId.not.empty}")
	private Integer questionbankYearId;

	@NotNull(message = "{videoPastpaper.questionTypeId.not.empty}")
	private Integer questionTypeId;

	@NotNull(message = "{videoPastpaper.questionbankTypeId.not.empty}")
	private Integer questionbankTypeId;

	// 基础信息
	@NotNull
	@Valid
	private VideoBase videoBase;

	// 题库版本（北京卷，河北卷）
	private QuestionBankType questionBankType;

	// 题库年份
	private QuestionBankYear questionBankYear;

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

	public Integer getQuestionTypeId() {
		return questionTypeId;
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

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Integer getQuestionbankTypeId() {
		return questionbankTypeId;
	}

	public void setQuestionbankTypeId(Integer questionbankTypeId) {
		this.questionbankTypeId = questionbankTypeId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionBankType getQuestionBankType() {
		return questionBankType;
	}

	public void setQuestionBankType(QuestionBankType questionBankType) {
		this.questionBankType = questionBankType;
	}

	public QuestionBankYear getQuestionBankYear() {
		return questionBankYear;
	}

	public void setQuestionBankYear(QuestionBankYear questionBankYear) {
		this.questionBankYear = questionBankYear;
	}

	public String getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(String hasVideo) {
		this.hasVideo = hasVideo;
	}

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public Integer getQuestionbankId() {
		return questionbankId;
	}

	public VideoBase getVideoBase() {
		return videoBase;
	}

	public void setVideoBase(VideoBase videoBase) {
		this.videoBase = videoBase;
	}

	public void setQuestionbankId(Integer questionbankId) {
		this.questionbankId = questionbankId;
	}

	public Integer getQuestionbankYearId() {
		return questionbankYearId;
	}

	public void setQuestionbankYearId(Integer questionbankYearId) {
		this.questionbankYearId = questionbankYearId;
	}

}