package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;

/** 
 * @ClassName VideoBaseKnowledgePointMapper 
 * @Description 视频中的知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:55:53  
 */
public interface VideoBaseKnowledgePointMapper {
    int deleteByPrimaryKey(VideoBaseKnowledgePointKey key);

    int insert(VideoBaseKnowledgePointKey record);

    int insertSelective(VideoBaseKnowledgePointKey record);
}