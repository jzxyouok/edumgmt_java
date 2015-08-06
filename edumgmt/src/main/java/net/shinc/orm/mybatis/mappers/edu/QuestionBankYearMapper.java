package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionBankYear;

/** 
 * @ClassName QuestionBankYearMapper 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:51  
 */
public interface QuestionBankYearMapper {
	
    int deleteQuestionBankYearById(Integer id);

    int addQuestionBankYear(QuestionBankYear record);

    QuestionBankYear selectQuestionBankYearById(Integer id);

    int updateQuestionBankYear(QuestionBankYear record);

    public int addQuestionBankYearBatch(List<QuestionBankYear> list);
    
    public List<QuestionBankYear> getQuestionBankYearByQuestionBank(QuestionBank questionBank);
}