package net.shinc.service.questionbank;

import net.shinc.orm.mybatis.bean.QuestionBankType;

/** 
 * @ClassName QuestionBankService 
 * @Description 题库版本接口
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface QuestionBankTypeService {

	/**
	 * 添加题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer addQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 修改题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer updateQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 删除题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer deleteQuestionBankTypeById(Integer questionBankTypeId);
	
	/**
	 * 根据id查询题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer getQuestionBankTypeById(Integer questionBankTypeId);
	
}
