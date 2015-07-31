package net.shinc.orm.mybatis.bean;

/**
 * @ClassName: VideoPoint
 * @Description: 知识点信息
 * @author hushichong
 * @date 2015年7月31日 下午3:48:37
 */
public class VideoPoint {
	
	private Integer id;

	private Integer videoBaseId;

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

}