package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionType;

/** 
 * @ClassName QuestionTypeMapper 
 * @Description 题型
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:55  
 */
public interface QuestionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}