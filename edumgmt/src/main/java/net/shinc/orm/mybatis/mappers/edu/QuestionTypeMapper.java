package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.QuestionType;

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

    QuestionType selectQuestionTypeById(Integer id);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}