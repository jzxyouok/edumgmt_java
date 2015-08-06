package net.shinc.service.edu.questionbank;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionBankYear;

/** 
 * @ClassName QuestionBankYearService 
 * @Description 真题模拟题与年份关系
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface QuestionBankYearService {

	/**
	 * 添加题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	public Integer addQuestionBankYear(QuestionBankYear questionBankYear);
	
	/**
	 * 批量添加题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	public Integer addQuestionBankYearBatch(List<QuestionBankYear> list);
	
	/**
	 * 修改题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	public Integer updateQuestionBankYear(QuestionBankYear questionBankYear);
	
	/**
	 * 删除题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	public Integer deleteQuestionBankYearById(Integer questionBankYearId);
	
	/**
	 * 根据id查询题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	public QuestionBankYear getQuestionBankYearById(Integer questionBankYearId);
	
	/**
	 * 根据题库查年份
	 * @param questionBank
	 * @return
	 */
	public List<QuestionBankYear> getQuestionBankYearByQuestionBank(QuestionBank questionBank);
}
