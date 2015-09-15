package net.shinc.orm.mybatis.bean.edu;

public class ProblemHasVideoBase {
    private Integer id;

    private Integer shProblemId;

    private Integer shVideoBaseId;

    private String videoType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShProblemId() {
        return shProblemId;
    }

    public void setShProblemId(Integer shProblemId) {
        this.shProblemId = shProblemId;
    }

    public Integer getShVideoBaseId() {
        return shVideoBaseId;
    }

    public void setShVideoBaseId(Integer shVideoBaseId) {
        this.shVideoBaseId = shVideoBaseId;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }
}