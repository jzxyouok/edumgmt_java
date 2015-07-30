package net.shinc.orm.mybatis.bean;

public class ThirdpartLogin {
    private Integer id;

    private Integer shUserId;

    private String thirdpart;

    private String key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShUserId() {
        return shUserId;
    }

    public void setShUserId(Integer shUserId) {
        this.shUserId = shUserId;
    }

    public String getThirdpart() {
        return thirdpart;
    }

    public void setThirdpart(String thirdpart) {
        this.thirdpart = thirdpart == null ? null : thirdpart.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }
}