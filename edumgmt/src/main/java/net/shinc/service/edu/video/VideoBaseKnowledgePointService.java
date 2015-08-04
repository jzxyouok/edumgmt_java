package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;

/**
 * @ClassName VideoBaseKnowledgePointService 
 * @Description 视频与知识点关系服务接口
 * @author guoshijie 
 * @date 2015年8月4日 下午1:08:43
 */
public interface VideoBaseKnowledgePointService {
	
	/**
	 * 判断该知识点是否被使用
	 * @param knowledgePoint
	 * @return
	 */
	public Boolean isUsedKnowledgePoint(KnowledgePoint knowledgePoint);
	
	/**
	 * 查询视频拥有的知识点
	 * @return
	 */
	public List<KnowledgePoint> getKnowledgePointListByVideo(VideoBase videoBase);
	
	/**
	 * 给视频添加知识点
	 * @return
	 */
	public Integer addKnowledgePointForVideoBase(VideoBaseKnowledgePointKey record);
	
	/**
	 * 删除视频某知识点
	 * @return
	 */
	public Integer deleteKnowledgePointForVideoBase(VideoBaseKnowledgePointKey record);

}
