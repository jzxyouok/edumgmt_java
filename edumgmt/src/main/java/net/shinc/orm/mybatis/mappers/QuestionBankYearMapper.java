package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionBankYear;

/** 
 * @ClassName QuestionBankYearMapper 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:51  
 */
public interface QuestionBankYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionBankYear record);

    int insertSelective(QuestionBankYear record);

    QuestionBankYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionBankYear record);

    int updateByPrimaryKey(QuestionBankYear record);
}