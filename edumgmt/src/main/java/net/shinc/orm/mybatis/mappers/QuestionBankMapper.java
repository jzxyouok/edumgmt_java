package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionBank;

/** 
 * @ClassName QuestionBankMapper 
 * @Description 题库
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:36  
 */
public interface QuestionBankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    QuestionBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
}