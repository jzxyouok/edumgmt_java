package net.shinc.orm.mybatis.bean;

public class VideoPastpaper {
    private Integer id;

    private Integer shVideoBaseId;

    private Integer shQuestionbankId;

    private Integer shQuestionbankYearId;

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

    public Integer getShQuestionbankId() {
        return shQuestionbankId;
    }

    public void setShQuestionbankId(Integer shQuestionbankId) {
        this.shQuestionbankId = shQuestionbankId;
    }

    public Integer getShQuestionbankYearId() {
        return shQuestionbankYearId;
    }

    public void setShQuestionbankYearId(Integer shQuestionbankYearId) {
        this.shQuestionbankYearId = shQuestionbankYearId;
    }
}