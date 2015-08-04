package net.shinc.orm.mybatis.bean;

import java.util.List;

/**
 * @ClassName: VideoPastpaper
 * @Description: 真题模拟题具体信息
 * @author hushichong
 * @date 2015年7月31日 下午3:41:54
 */
public class VideoPastpaper {

	private Integer id;

	private Integer videoBaseId;

	private Integer questionbankId;

	private Integer questionbankYearId;

	// 关键字
	private List<Keyword> keywordList;
	
	// 知识点
	private List<KnowledgePoint> knowledgetPointList;
	
	// 视频详情
	private List<VideoDetail> videoDetailList;
	
	// 基础信息
	private VideoBase videoBase;
	
	// 课程
	private Course course;
	
	// 讲解人
	private Lecture lecture;
	
	// 题库版本（北京卷，河北卷）
	private QuestionBankType questionBankType;
	
	// 题库版本（北京卷，河北卷）
	private QuestionBankYear questionBankYear;
	
	// 题型 （单选、多选）
	private QuestionType questionType;
	
	// 题库 （中考真题，高考真题）
	private QuestionBank questionBank;
	
	// 有无视频
	private String hasVideo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<VideoDetail> getVideoDetailList() {
		return videoDetailList;
	}

	public void setVideoDetailList(List<VideoDetail> videoDetailList) {
		this.videoDetailList = videoDetailList;
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

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		this.keywordList = keywordList;
	}

	public List<KnowledgePoint> getKnowledgetPointList() {
		return knowledgetPointList;
	}

	public void setKnowledgetPointList(List<KnowledgePoint> knowledgetPointList) {
		this.knowledgetPointList = knowledgetPointList;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
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