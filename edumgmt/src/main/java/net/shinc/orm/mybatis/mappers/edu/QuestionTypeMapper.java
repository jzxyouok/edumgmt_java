package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionType;


/** 
 * @ClassName QuestionTypeMapper 
 * @Description 题型
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:55  
 */
public interface QuestionTypeMapper {
	
	public Integer deleteQuestionTypeById(Integer id);

	public Integer insertQuestionType(QuestionType questionType);

	public Integer updateQuestionType(QuestionType questionType);

	public QuestionType getQuestionTypeById(Integer id);

	public List<QuestionType> getQuestionTypeList(QuestionType questionType);

	public Integer getQuestionTypeListCount(QuestionType questionType);
	

}