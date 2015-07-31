package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionType 
 * @Description 题型
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:38  
 */
public class QuestionType {
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