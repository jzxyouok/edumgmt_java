package net.shinc.service.edu.questionbank.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankYear;
import net.shinc.orm.mybatis.mappers.QuestionBankYearMapper;
import net.shinc.service.edu.questionbank.QuestionBankYearService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName QuestionBankYearService 
 * @Description 真题模拟题与年份关系实现
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
@Service
public class QuestionBankYearServiceImpl implements QuestionBankYearService{

	@Autowired
	private QuestionBankYearMapper questionBankYearMapper;
	
	@Override
	public Integer addQuestionBankYear(QuestionBankYear questionBankYear) {
		if(null != questionBankYear){
			return questionBankYearMapper.addQuestionBankYear(questionBankYear);
		}
		return 0;
	}
	
	@Override
	public Integer addQuestionBankYearBatch(List<QuestionBankYear> list) {
		if(null != list){
			return questionBankYearMapper.addQuestionBankYearBatch(list);
		}
		return 0;
	}

	@Override
	public Integer updateQuestionBankYear(QuestionBankYear questionBankYear) {
		if(null != questionBankYear){
			return questionBankYearMapper.updateQuestionBankYear(questionBankYear);
		}
		return 0;
	}

	@Override
	public Integer deleteQuestionBankYearById(Integer questionBankYearId) {
		if(null != questionBankYearId){
			return questionBankYearMapper.deleteQuestionBankYearById(questionBankYearId);
		}
		return 0;
	}

	@Override
	public QuestionBankYear getQuestionBankYearById(Integer questionBankYearId) {
		if(null != questionBankYearId){
			return questionBankYearMapper.selectQuestionBankYearById(questionBankYearId);
		}
		return null;
	}

	@Override
	public List<QuestionBankYear> getQuestionBankYearByQuestionBank(QuestionBank questionBank) {
		if(null != questionBank){
			return questionBankYearMapper.getQuestionBankYearByQuestionBank(questionBank);
		}
		return null;
	}

}
