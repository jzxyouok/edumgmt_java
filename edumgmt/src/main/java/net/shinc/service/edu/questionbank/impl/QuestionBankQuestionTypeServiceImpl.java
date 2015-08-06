package net.shinc.service.edu.questionbank.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionType;
import net.shinc.orm.mybatis.mappers.edu.QuestionBankQuestionTypeMapper;
import net.shinc.service.edu.questionbank.QuestionBankQuestionTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QuestionBankQuestionTypeServiceImpl 
 * @Description 题库与题型关系服务接口实现
 * @author guoshijie 
 * @date 2015年8月4日 上午11:10:17
 */
@Service
public class QuestionBankQuestionTypeServiceImpl implements QuestionBankQuestionTypeService {

	@Autowired
	private QuestionBankQuestionTypeMapper mapper;

	@Override
	public List<QuestionType> getQuestionTypeByQuestionBank(QuestionBank questionBank) {
		if(null != questionBank) {
			List<QuestionType> list = mapper.getQuestionTypeByQuestionBank(questionBank);
			return list;
		}
		return null;
	}

}
