package net.shinc.orm.mybatis.bean.edu;

public class Problem {
	private Integer id;

	private Integer bookId;

	private String status;

	private String content;
	
	private String videoBaseIds;
	
	private String twoCode;
	
	private String videoNum;

	public Integer getId() {
		return id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public String getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public String getVideoBaseIds() {
		return videoBaseIds;
	}

	public String getTwoCode() {
		return twoCode;
	}

	public void setTwoCode(String twoCode) {
		this.twoCode = twoCode;
	}

	public void setVideoBaseIds(String videoBaseIds) {
		this.videoBaseIds = videoBaseIds;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}