package net.shinc.orm.mybatis.bean;
/**
  * @ClassName: VideoSelf
  * @Description: 自编题信息
  * @author hushichong
  * @date 2015年7月31日 下午3:51:17
 */
public class VideoSelf {
	
	private Integer id;

	private Integer videoBaseId;

	private VideoBase videoBase;
	
	private String type;

	private Integer questionTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public VideoBase getVideoBase() {
		return videoBase;
	}

	public void setVideoBase(VideoBase videoBase) {
		this.videoBase = videoBase;
	}

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

}