package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionBank 
 * @Description 题库
 * @author guoshijie 
 * @date 2015年7月31日 下午4:49:01  
 */
public class QuestionBank {
    private Integer id;

    private String name;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}