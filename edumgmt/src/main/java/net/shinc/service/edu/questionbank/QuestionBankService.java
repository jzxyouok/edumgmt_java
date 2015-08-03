package net.shinc.service.edu.questionbank;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;

/** 
 * @ClassName QuestionBankService 
 * @Description 题库接口
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface QuestionBankService {

	/**
	 * 添加题库
	 * @param questionBank
	 * @return
	 */
	public Integer addQuestionBank(QuestionBank questionBank);
	
	/**
	 * 修改题库
	 * @param questionBank
	 * @return
	 */
	public Integer updateQuestionBank(QuestionBank questionBank);
	
	/**
	 * 删除题库
	 * @param questionBank
	 * @return
	 */
	public Integer deleteQuestionBankById(Integer questionBankId);
	
	/**
	 * 根据id查询题库
	 * @param questionBank
	 * @return
	 */
	public QuestionBank getQuestionBankById(Integer questionBankId);
	
	/**
	 * 查询所有题库列表
	 * @return
	 */
	public List<QuestionBank> getQuestionBankList();
}
