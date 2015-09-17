package net.shinc.orm.mybatis.bean.edu;

public class RecommendHasCourseGrade {
	private Integer id;

	private Integer recommendId;

	private Integer courseGradeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(Integer recommendId) {
		this.recommendId = recommendId;
	}

	public Integer getCourseGradeId() {
		return courseGradeId;
	}

	public void setCourseGradeId(Integer courseGradeId) {
		this.courseGradeId = courseGradeId;
	}

}