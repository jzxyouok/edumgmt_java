package net.shinc.orm.mybatis.bean.edu;

import java.text.MessageFormat;

/** 
 * @ClassName VideoPic 
 * @Description 视频截图
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:03  
 */
public class VideoPic {
    private Integer id;

    private Integer videoBaseId;

    private String title;

    private String description;

    private String storeInfo;

    private String storeType;

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

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

	public VideoPic() {
		super();
	}

	public VideoPic(Integer id, Integer videoBaseId, String title, String description, String storeInfo, String storeType) {
		super();
		this.id = id;
		this.videoBaseId = videoBaseId;
		this.title = title;
		this.description = description;
		this.storeInfo = storeInfo;
		this.storeType = storeType;
	}

	public VideoPic(Integer id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("id:{0}\ttitle:{1}", this.id,this.title);
	}
}