package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionBankCourseKey;

/** 
 * @ClassName QuestionBankCourseMapper 
 * @Description 题库与科目对应关系
 * @author guoshijie 
 * @date 2015年7月31日 下午5:00:29  
 */
public interface QuestionBankCourseMapper {
    int deleteById(QuestionBankCourseKey key);

    int insertSelective(QuestionBankCourseKey record);
    
    QuestionBankCourseKey selectQuestionBankCourse(QuestionBankCourseKey key);
    
    List<Course> getCourseListByQuestionBank(QuestionBank questionBank);
}