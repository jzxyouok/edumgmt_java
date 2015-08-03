package net.shinc.service.edu.questionbank.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankCourseKey;
import net.shinc.orm.mybatis.mappers.QuestionBankMapper;
import net.shinc.service.edu.questionbank.QuestionBankCourseService;
import net.shinc.service.edu.questionbank.QuestionBankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName QuestionBankServiceImpl 
 * @Description 题库接口实现
 * @author guoshijie 
 * @date 2015年7月31日 下午5:42:27  
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	private QuestionBankMapper questionBankMapper;
	
	@Autowired
	private QuestionBankCourseService questionBankCourseService;
	
	@Override
	public Integer addQuestionBank(QuestionBank questionBank) {
		if(null != questionBank) {
			return questionBankMapper.addQuestionBank(questionBank);
		}
		return 0;
	}

	@Override
	public Integer updateQuestionBank(QuestionBank questionBank) {
		if(null != questionBank) {
			return questionBankMapper.updateQuestionBank(questionBank);
		}
		return 0;
	}

	@Override
	public Integer deleteQuestionBankById(Integer questionBankId) {
		if(null != questionBankId) {
			return questionBankMapper.deleteQuestionBankById(questionBankId);
		}
		return 0;
	}

	@Override
	public QuestionBank getQuestionBankById(Integer questionBankId) {
		if(null != questionBankId) {
			return questionBankMapper.selectQuestionBankById(questionBankId);
		}
		return null;
	}

	@Override
	public List<QuestionBank> getQuestionBankList() {
		return questionBankMapper.getQuestionBankList();
	}

	@Override
	public Integer addQuestionBankCourseKey(QuestionBankCourseKey questionBankCourseKey) {
		if(null != questionBankCourseKey) {
			return questionBankCourseService.addQuestionBankCourse(questionBankCourseKey);
		}
		return 0;
	}

}
