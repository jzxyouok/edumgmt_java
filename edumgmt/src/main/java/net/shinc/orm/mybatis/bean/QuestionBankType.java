package net.shinc.orm.mybatis.bean;

import java.text.MessageFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName QuestionBankType 
 * @Description 题库版本
 * @author guoshijie 
 * @date 2015年7月31日 下午4:50:25  
 */
public class QuestionBankType {
    private Integer id;

    @NotNull(message="{questionBank.not.empty}")
    private QuestionBank questionBank;

    @NotEmpty(message="{questionBankTypeName.not.empty}")
    private String name;

    public QuestionBankType() {
	}
    
	public QuestionBankType(QuestionBank questionBank, String name) {
		this.questionBank = questionBank;
		this.name = name;
	}

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

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("questionBank:{0}\tname:{1}", this.questionBank,this.name);
	}

}