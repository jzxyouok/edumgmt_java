package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionBankQuestionTypeKey 
 * @Description 题库题型对应关系
 * @author guoshijie 
 * @date 2015年7月31日 下午4:49:14  
 */
public class QuestionBankQuestionTypeKey {
    private Integer questionBankId;

    private Integer questionTypeId;

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

}