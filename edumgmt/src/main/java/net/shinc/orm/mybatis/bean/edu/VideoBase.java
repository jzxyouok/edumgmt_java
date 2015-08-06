package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.shinc.orm.mybatis.bean.common.AdminUser;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName: VideoBase
 * @Description: 视频公共基础信息
 * @author hushichong
 * @date 2015年7月31日 下午3:31:12
 */
public class VideoBase {

	private Integer id;

	@NotNull(message = "{videoBase.adminUserId.not.empty}")
	private Integer adminUserId;

	@NotNull(message = "{videoBase.courseId.not.empty}")
	private Integer courseId;

	@NotNull(message = "{videoBase.lectureId.not.empty}")
	private Integer lectureId;

	private String questionId;

	@NotEmpty(message = "{videoBase.title.not.empty}")
	private String title;

	@NotEmpty(message = "{videoBase.desc.not.empty}")
	private String desc;

	@NotEmpty(message = "{videoBase.profile.not.empty}")
	private String profile;

	@NotEmpty(message = "{videoBase.difficulty.not.empty}")
	private String difficulty;

	private String status;

	@NotEmpty(message = "{videoBase.questionNumber.not.empty}")
	private String questionNumber;

	private Date updatetime;
	
	private AdminUser adminUser;

	// 课程
	private Course course;

	// 讲解人
	private Lecture lecture;
	
	// 关键字
	private List<Keyword> keywordList;

	// 知识点
	private List<KnowledgePoint> knowledgetPointList;

	// 视频详情
	@NotNull
	@Valid
	private List<VideoDetail> videoDetailList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminUserId() {
		return adminUserId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Keyword> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(List<Keyword> keywordList) {
		this.keywordList = keywordList;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	public List<KnowledgePoint> getKnowledgetPointList() {
		return knowledgetPointList;
	}

	public void setKnowledgetPointList(List<KnowledgePoint> knowledgetPointList) {
		this.knowledgetPointList = knowledgetPointList;
	}

	public List<VideoDetail> getVideoDetailList() {
		return videoDetailList;
	}

	public void setVideoDetailList(List<VideoDetail> videoDetailList) {
		this.videoDetailList = videoDetailList;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getLectureId() {
		return lectureId;
	}

	public void setLectureId(Integer lectureId) {
		this.lectureId = lectureId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId == null ? null : questionId.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc == null ? null : desc.trim();
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty == null ? null : difficulty.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber == null ? null : questionNumber.trim();
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}