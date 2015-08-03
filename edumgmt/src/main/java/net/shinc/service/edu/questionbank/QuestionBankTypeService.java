package net.shinc.service.edu.questionbank;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankType;

/**
 * @ClassName QuestionBankTypeService 
 * @Description 题库版本服务接口
 * @author guoshijie 
 * @date 2015年8月3日 下午3:24:26
 */
public interface QuestionBankTypeService {

	/**
	 * 添加题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer addQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 批量添加题库版本
	 * @param questionBankType
	 * @return
	 */
	public Integer addQuestionBankTypeBatch(List<QuestionBankType> list);
	
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
	public Integer deleteQuestionBankTypeById(Integer id);
	
	/**
	 * 根据id查询题库版本
	 * @param questionBankType
	 * @return
	 */
	public QuestionBankType getQuestionBankTypeById(Integer id);
	
	/**
	 * 根据题库查题库版本
	 * @param questionBank
	 * @return
	 */
	public List<QuestionBankType> getQuestionBankTypeByQuestionBank(QuestionBank questionBank);
}
