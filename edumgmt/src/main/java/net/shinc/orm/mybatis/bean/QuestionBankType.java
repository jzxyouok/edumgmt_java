package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionBankType 
 * @Description 题库版本
 * @author guoshijie 
 * @date 2015年7月31日 下午4:50:25  
 */
public class QuestionBankType {
    private Integer id;

    private Integer questionBankId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

}