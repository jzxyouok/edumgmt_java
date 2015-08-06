package net.shinc.service.edu.questionbank;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionBankCourseKey;

/**
 * @ClassName QuestionBankCourseService 
 * @Description 题库与科目对应关系服务接口
 * @author guoshijie 
 * @date 2015年8月3日 下午9:02:21
 */
public interface QuestionBankCourseService {

	/**
	 * 添加题库与科目对应关系
	 * @param questionBank
	 * @return
	 */
	public Integer addQuestionBankCourse(QuestionBankCourseKey questionBankCourseKey);
	
	/**
	 * 删除题库与科目对应关系
	 * @param questionBank
	 * @return
	 */
	public Integer deleteQuestionBankCourseById(QuestionBankCourseKey questionBankCourseKey);
	
	/**
	 * 查询是否存在题库与科目对应关系
	 * @return
	 */
	public Boolean hasQuestionBankCourseKey(QuestionBankCourseKey questionBankCourseKey);
	
	/**
	 * 根据题库查询课程列表
	 * @param questionBank
	 * @return
	 */
	public List<Course> getCourseListByQuestionBank(QuestionBank questionBank);
}
