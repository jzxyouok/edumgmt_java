package net.shinc.orm.mybatis.bean.edu;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CourseGrade {
	private Integer id;

	private Integer courseId;

	@NotEmpty(message = "{courseGrade.name.not.empty}")
	private String name;

	@NotEmpty(message = "{courseGrade.type.not.empty}")
	private String type;

	@NotNull(message = "{courseGrade.materialVersionId.not.empty}")
	private Integer materialVersionId;
	
	private String videoBaseIds;
	
	private String materialVersionName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getMaterialVersionName() {
		return materialVersionName;
	}

	public void setMaterialVersionName(String materialVersionName) {
		this.materialVersionName = materialVersionName;
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