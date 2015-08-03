package net.shinc.orm.mybatis.bean;

import java.text.MessageFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName QuestionBankYear 
 * @Description 真题模拟题与年份关系
 * @author guoshijie 
 * @date 2015年7月31日 下午4:50:32  
 */
public class QuestionBankYear {
    private Integer id;

    @NotNull(message="{questionBank.not.empty}")
    private QuestionBank questionBank;

    @NotEmpty(message="{year.not.empty}")
    private String year;

    public QuestionBankYear() {
	}
    
	public QuestionBankYear(QuestionBank questionBank, String year) {
		this.questionBank = questionBank;
		this.year = year;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

	public QuestionBank getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("questionBank:{0}\tyear:{1}", this.questionBank,this.year);
	}

}