package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName Keyword 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:18  
 */
public class Keyword {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}