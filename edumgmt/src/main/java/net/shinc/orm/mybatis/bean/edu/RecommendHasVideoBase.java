package net.shinc.orm.mybatis.bean.edu;

import java.util.Date;

public class RecommendHasVideoBase {
    private Integer id;

    private Integer shRecommendId;

    private Integer shVideoBaseId;

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

    public Integer getShRecommendId() {
        return shRecommendId;
    }

    public void setShRecommendId(Integer shRecommendId) {
        this.shRecommendId = shRecommendId;
    }

    public Integer getShVideoBaseId() {
        return shVideoBaseId;
    }

    public void setShVideoBaseId(Integer shVideoBaseId) {
        this.shVideoBaseId = shVideoBaseId;
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