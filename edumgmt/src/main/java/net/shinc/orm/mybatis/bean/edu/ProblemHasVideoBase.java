package net.shinc.orm.mybatis.bean.edu;

public class ProblemHasVideoBase {
	private Integer id;

	private Integer problemId;

	private Integer videoBaseId;

	private String videoType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType == null ? null : videoType.trim();
	}
}