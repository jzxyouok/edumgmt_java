package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName VideoBaseKnowledgePointKey 
 * @Description 视频中的知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:55:44  
 */
public class VideoBaseKnowledgePointKey {
    private Integer videoBaseId;

    private Integer knowledgePointId;

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public Integer getKnowledgePointId() {
		return knowledgePointId;
	}

	public void setKnowledgePointId(Integer knowledgePointId) {
		this.knowledgePointId = knowledgePointId;
	}

}