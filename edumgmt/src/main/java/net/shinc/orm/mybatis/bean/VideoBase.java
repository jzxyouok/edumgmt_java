package net.shinc.orm.mybatis.bean;

import java.util.Date;

public class VideoBase {
    private Integer id;

    private Integer shAdminUserId;

    private Integer shCourseId;

    private Integer shQuestionTypeId;

    private Integer shLectureId;

    private String questionId;

    private String title;

    private String desc;

    private String difficulty;

    private String status;

    private String questionNumber;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShAdminUserId() {
        return shAdminUserId;
    }

    public void setShAdminUserId(Integer shAdminUserId) {
        this.shAdminUserId = shAdminUserId;
    }

    public Integer getShCourseId() {
        return shCourseId;
    }

    public void setShCourseId(Integer shCourseId) {
        this.shCourseId = shCourseId;
    }

    public Integer getShQuestionTypeId() {
        return shQuestionTypeId;
    }

    public void setShQuestionTypeId(Integer shQuestionTypeId) {
        this.shQuestionTypeId = shQuestionTypeId;
    }

    public Integer getShLectureId() {
        return shLectureId;
    }

    public void setShLectureId(Integer shLectureId) {
        this.shLectureId = shLectureId;
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