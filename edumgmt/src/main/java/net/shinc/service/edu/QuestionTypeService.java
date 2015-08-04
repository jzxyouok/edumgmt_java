package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionType;

/**
 * @ClassName QuestionTypeService 
 * @Description 题型接口
 * @author guoshijie 
 * @date 2015年8月4日 上午10:09:12
 */
public interface QuestionTypeService {
	
	public Integer addQuestionType(QuestionType questionType);
	
	public Integer deleteQuestionType(QuestionType questionType);
	
	public Integer updateQuestionType(QuestionType questionType);
	
	public QuestionType getQuestionTypeById(Integer id);
	
	public List<QuestionType> getAllQuestionType();

}
