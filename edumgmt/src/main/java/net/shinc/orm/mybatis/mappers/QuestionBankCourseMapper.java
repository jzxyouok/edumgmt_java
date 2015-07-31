package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionBankCourseKey;

/** 
 * @ClassName QuestionBankCourseMapper 
 * @Description 题库与科目对应关系
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:29  
 */
public interface QuestionBankCourseMapper {
    int deleteById(QuestionBankCourseKey key);

    int insert(QuestionBankCourseKey record);

    int insertSelective(QuestionBankCourseKey record);
}