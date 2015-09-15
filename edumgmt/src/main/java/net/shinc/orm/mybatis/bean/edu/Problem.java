package net.shinc.orm.mybatis.bean.edu;

public class Problem {
    private Integer id;

    private Integer shBookId;

    private String status;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShBookId() {
        return shBookId;
    }

    public void setShBookId(Integer shBookId) {
        this.shBookId = shBookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}