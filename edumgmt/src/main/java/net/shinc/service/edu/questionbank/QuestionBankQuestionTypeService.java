package net.shinc.service.edu.questionbank;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionType;

/**
 * @ClassName QuestionBankQuestionTypeService 
 * @Description 题库与题型关系服务接口
 * @author guoshijie 
 * @date 2015年8月4日 上午10:56:31
 */
public interface QuestionBankQuestionTypeService {
	
	/**
	 * 查询题库下的题型列表
	 * @return
	 */
	public List<QuestionType> getQuestionTypeByQuestionBank(QuestionBank questionBank);

}
