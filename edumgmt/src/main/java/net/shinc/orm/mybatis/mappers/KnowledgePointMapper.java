package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.KnowledgePoint;

public interface KnowledgePointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgePoint record);

    int insertSelective(KnowledgePoint record);

    KnowledgePoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgePoint record);

    int updateByPrimaryKey(KnowledgePoint record);
}