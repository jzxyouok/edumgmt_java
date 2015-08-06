package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.bean.edu.VideoBaseKnowledgePointKey;

/** 
 * @ClassName VideoBaseKnowledgePointMapper 
 * @Description 视频中的知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:55:53  
 */
public interface VideoBaseKnowledgePointMapper {
	
    int deleteVideoBaseKnowledgePoint(VideoBaseKnowledgePointKey key);

    int insert(VideoBaseKnowledgePointKey record);
    
    int insertBatch(List<VideoBaseKnowledgePointKey> record);

    int insertSelective(VideoBaseKnowledgePointKey record);
    
    Integer isUsedKnowledgePoint(KnowledgePoint record);
    
    List<KnowledgePoint> getKnowledgePointListByVideo(VideoBase record);
    
}