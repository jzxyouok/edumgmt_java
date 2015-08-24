package net.shinc.orm.mybatis.bean.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName KnowledgePoint 
 * @Description 知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:51:30  
 */
public class KnowledgePoint {
	
    private Integer id;

    private Integer courseId;
    
    private Course course;

    private String name;
    
    private Integer parentId;
    
    private List children;
    
    public KnowledgePoint() {
	}
    
	public KnowledgePoint(Course course, String name) {
		super();
		this.course = course;
		this.name = name;
	}
	
	public KnowledgePoint(Integer id) {
		this.id = id;
	}



	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}