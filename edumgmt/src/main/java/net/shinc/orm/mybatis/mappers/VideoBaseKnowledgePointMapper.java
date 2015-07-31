package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;

public interface VideoBaseKnowledgePointMapper {
    int deleteByPrimaryKey(VideoBaseKnowledgePointKey key);

    int insert(VideoBaseKnowledgePointKey record);

    int insertSelective(VideoBaseKnowledgePointKey record);
}