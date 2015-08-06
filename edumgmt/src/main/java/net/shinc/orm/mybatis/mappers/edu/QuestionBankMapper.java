package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionBank;

/** 
 * @ClassName QuestionBankMapper 
 * @Description 题库
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:36  
 */
public interface QuestionBankMapper {
	
    int deleteQuestionBankById(Integer id);

    int addQuestionBank(QuestionBank record);

    QuestionBank selectQuestionBankById(Integer id);

    int updateQuestionBank(QuestionBank record);
    
    public List<QuestionBank> getQuestionBankList();

}