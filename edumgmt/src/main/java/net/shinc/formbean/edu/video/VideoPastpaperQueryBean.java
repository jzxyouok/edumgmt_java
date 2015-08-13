package net.shinc.formbean.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.QueryBean;

/**
 * 查询真题模拟题，表单验证/绑定bean
 * @author zhangtaichao 2015年8月13日
 *
 */
public class VideoPastpaperQueryBean implements QueryBean {
	
	private String id;
	private String questionBankId;
	private String courseId;
	private String questionBankTypeId;
	private String questionbankYearId;
	private String questionTypeId;
	private String difficulty;
	private String lectureId;
	private String hasVideo;
	private String questionDesc;
	private List<String> keywordList;
	private List<String> knowledgePointList;
	public String getQuestionBankId() {
		return questionBankId;
	}
	public void setQuestionBankId(String questionBankId) {
		this.questionBankId = questionBankId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getQuestionBankTypeId() {
		return questionBankTypeId;
	}
	public void setQuestionBankTypeId(String questionBankTypeId) {
		this.questionBankTypeId = questionBankTypeId;
	}
	public String getQuestionbankYearId() {
		return questionbankYearId;
	}
	public void setQuestionbankYearId(String questionbankYearId) {
		this.questionbankYearId = questionbankYearId;
	}
	public String getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getLectureId() {
		return lectureId;
	}
	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}
	public String getHasVideo() {
		return hasVideo;
	}
	public void setHasVideo(String hasVideo) {
		this.hasVideo = hasVideo;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getKeywordList() {
		return keywordList;
	}
	public void setKeywordList(List<String> keywordList) {
		this.keywordList = keywordList;
	}
	public List<String> getKnowledgePointList() {
		return knowledgePointList;
	}
	public void setKnowledgePointList(List<String> knowledgePointList) {
		this.knowledgePointList = knowledgePointList;
	}
	
	

}
