package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionBankCourseKey 
 * @Description 题库与科目对应关系
 * @author guoshijie 
 * @date 2015年7月31日 下午4:48:47  
 */
public class QuestionBankCourseKey {
	
	private Integer questionBankId;

	private Integer courseId;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}
	
}