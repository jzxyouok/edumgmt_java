package net.shinc.service.questionbank;

import net.shinc.orm.mybatis.bean.QuestionBankYear;

/** 
 * @ClassName QuestionBankYearService 
 * @Description 真题模拟题与年份关系
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface QuestionBankYearService {

	/**
	 * 添加题库
	 * @param questionBankYear
	 * @return
	 */
	public Integer addQuestionBankYear(QuestionBankYear questionBankYear);
	
	/**
	 * 修改题库
	 * @param questionBankYear
	 * @return
	 */
	public Integer updateQuestionBankYear(QuestionBankYear questionBankYear);
	
	/**
	 * 删除题库
	 * @param questionBankYear
	 * @return
	 */
	public Integer deleteQuestionBankYearById(Integer questionBankYearId);
	
	/**
	 * 根据id查询题库
	 * @param questionBankYear
	 * @return
	 */
	public Integer getQuestionBankYearById(Integer questionBankYearId);
}
