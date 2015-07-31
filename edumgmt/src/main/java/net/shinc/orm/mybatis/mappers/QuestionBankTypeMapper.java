package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionBankType;

/** 
 * @ClassName QuestionBankTypeMapper 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:47  
 */
public interface QuestionBankTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionBankType record);

    int insertSelective(QuestionBankType record);

    QuestionBankType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionBankType record);

    int updateByPrimaryKey(QuestionBankType record);
}