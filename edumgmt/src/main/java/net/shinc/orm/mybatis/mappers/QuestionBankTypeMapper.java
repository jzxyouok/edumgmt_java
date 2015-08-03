package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankType;

/** 
 * @ClassName QuestionBankTypeMapper 
 * @Description 题库版本
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:51  
 */
public interface QuestionBankTypeMapper {
	
    int deleteQuestionBankTypeById(Integer id);

    int addQuestionBankType(QuestionBankType record);

    QuestionBankType selectQuestionBankTypeById(Integer id);

    int updateQuestionBankType(QuestionBankType record);

    public int addQuestionBankTypeBatch(List<QuestionBankType> list);
    
    public List<QuestionBankType> getQuestionBankTypeByQuestionBank(QuestionBank questionBank);
}