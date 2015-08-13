package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionType;
import net.shinc.orm.mybatis.mappers.edu.QuestionTypeMapper;
import net.shinc.service.edu.QuestionTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QuestionTypeServiceImpl 
 * @Description 题型接口实现
 * @author guoshijie 
 * @date 2015年8月4日 上午10:15:27
 */
@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	@Autowired
	private QuestionTypeMapper questionTypeMapper;
	
	@Override
	public Integer addQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionType getQuestionTypeById(Integer id) {
		return questionTypeMapper.getQuestionTypeById(id);
	}

	@Override
	public List<QuestionType> getQuestionTypeList(QuestionType questionType) {
		return questionTypeMapper.getQuestionTypeList(questionType);
	}

}
