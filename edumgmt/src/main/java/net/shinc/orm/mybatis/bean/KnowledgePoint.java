package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName KnowledgePoint 
 * @Description 知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:51:30  
 */
public class KnowledgePoint {
    private Integer id;

    private Integer courseId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}