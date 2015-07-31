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

	private String type;

	private Integer questionTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

}