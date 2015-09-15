package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;

public class CourseGradeHasVideoBase {
    private Integer id;

    private Integer shCourseGradeId;

    private Integer shVideoBaseId;

    private Integer sort;

    private Date addTime;

    private String videoType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShCourseGradeId() {
        return shCourseGradeId;
    }

    public void setShCourseGradeId(Integer shCourseGradeId) {
        this.shCourseGradeId = shCourseGradeId;
    }

    public Integer getShVideoBaseId() {
        return shVideoBaseId;
    }

    public void setShVideoBaseId(Integer shVideoBaseId) {
        this.shVideoBaseId = shVideoBaseId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }
}