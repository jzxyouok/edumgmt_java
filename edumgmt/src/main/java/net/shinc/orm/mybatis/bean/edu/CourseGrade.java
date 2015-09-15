package net.shinc.orm.mybatis.bean.edu;

public class CourseGrade {
	private Integer id;

	private Integer courseId;

	private String name;

	private String type;

	private Integer materialVersionId;
	
	private String videoBaseIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getVideoBaseIds() {
		return videoBaseIds;
	}

	public void setVideoBaseIds(String videoBaseIds) {
		this.videoBaseIds = videoBaseIds;
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getMaterialVersionId() {
		return materialVersionId;
	}

	public void setMaterialVersionId(Integer materialVersionId) {
		this.materialVersionId = materialVersionId;
	}

}