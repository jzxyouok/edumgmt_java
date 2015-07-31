package net.shinc.orm.mybatis.bean;

public class VideoSelf {
    private Integer id;

    private Integer shVideoBaseId;

    private String type;

    private Integer shQuestionTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShVideoBaseId() {
        return shVideoBaseId;
    }

    public void setShVideoBaseId(Integer shVideoBaseId) {
        this.shVideoBaseId = shVideoBaseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getShQuestionTypeId() {
        return shQuestionTypeId;
    }

    public void setShQuestionTypeId(Integer shQuestionTypeId) {
        this.shQuestionTypeId = shQuestionTypeId;
    }
}