package net.shinc.orm.mybatis.bean.edu;

/** 
 * @ClassName QuestionBankCourseKey 
 * @Description 题库与科目对应关系
 * @author guoshijie 
 * @date 2015年7月31日 下午4:48:47  
 */
public class QuestionBankCourseKey {
	
	private QuestionBank questionBank;
	
	private Course course;

	public QuestionBankCourseKey() {
	}

	public QuestionBankCourseKey(QuestionBank questionBank, Course course) {
		this.questionBank = questionBank;
		this.course = course;
	}

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}