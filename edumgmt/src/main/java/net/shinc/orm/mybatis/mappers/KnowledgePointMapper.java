package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.KnowledgePoint;

/** 
 * @ClassName KnowledgePointMapper 
 * @Description 知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:51:19  
 */
public interface KnowledgePointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgePoint record);

    int insertSelective(KnowledgePoint record);

    KnowledgePoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgePoint record);

    int updateByPrimaryKey(KnowledgePoint record);
}