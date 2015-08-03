package net.shinc.service.edu.questionbank.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankType;
import net.shinc.orm.mybatis.mappers.QuestionBankTypeMapper;
import net.shinc.service.edu.questionbank.QuestionBankTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName QuestionBankTypeService 
 * @Description 题库版本服务接口实现
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
@Service
public class QuestionBankTypeServiceImpl implements QuestionBankTypeService{

	@Autowired
	private QuestionBankTypeMapper questionBankTypeMapper;
	
	@Override
	public Integer addQuestionBankType(QuestionBankType questionBankType) {
		if(null != questionBankType){
			return questionBankTypeMapper.addQuestionBankType(questionBankType);
		}
		return 0;
	}
	
	@Override
	public Integer addQuestionBankTypeBatch(List<QuestionBankType> list) {
		if(null != list){
			return questionBankTypeMapper.addQuestionBankTypeBatch(list);
		}
		return 0;
	}

	@Override
	public Integer updateQuestionBankType(QuestionBankType questionBankType) {
		if(null != questionBankType){
			return questionBankTypeMapper.updateQuestionBankType(questionBankType);
		}
		return 0;
	}

	@Override
	public Integer deleteQuestionBankTypeById(Integer questionBankTypeId) {
		if(null != questionBankTypeId){
			return questionBankTypeMapper.deleteQuestionBankTypeById(questionBankTypeId);
		}
		return 0;
	}

	@Override
	public QuestionBankType getQuestionBankTypeById(Integer questionBankTypeId) {
		if(null != questionBankTypeId){
			return questionBankTypeMapper.selectQuestionBankTypeById(questionBankTypeId);
		}
		return null;
	}

	@Override
	public List<QuestionBankType> getQuestionBankTypeByQuestionBank(QuestionBank questionBank) {
		if(null != questionBank){
			return questionBankTypeMapper.getQuestionBankTypeByQuestionBank(questionBank);
		}
		return null;
	}

}
