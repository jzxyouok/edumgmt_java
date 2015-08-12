package net.shinc.orm.mybatis.bean.edu;

import java.text.MessageFormat;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName QuestionBank 
 * @Description 题库
 * @author guoshijie 
 * @date 2015年7月31日 下午4:49:01  
 */
public class QuestionBank {
    private Integer id;

    @NotEmpty(message="{name.not.empty}")
    private String name;

    @NotEmpty(message="{type.not.empty}")
    private String type;

    private List<Course> courseList;
    
    private List<QuestionBankType> questionBankTypeList;
    
    private List<QuestionBankYear> questionBankYearList;
    
    private List<QuestionType> questionTypeList;
	public QuestionBank() {
	}

	public QuestionBank(Integer id) {
		this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<QuestionBankType> getQuestionBankTypeList() {
		return questionBankTypeList;
	}

	public void setQuestionBankTypeList(List<QuestionBankType> questionBankTypeList) {
		this.questionBankTypeList = questionBankTypeList;
	}

	public List<QuestionBankYear> getQuestionBankYearList() {
		return questionBankYearList;
	}

	public void setQuestionBankYearList(List<QuestionBankYear> questionBankYearList) {
		this.questionBankYearList = questionBankYearList;
	}

	public List<QuestionType> getQuestionTypeList() {
		return questionTypeList;
	}

	public void setQuestionTypeList(List<QuestionType> questionTypeList) {
		this.questionTypeList = questionTypeList;
	}

	@Override
    public String toString() {
    	return MessageFormat.format("name:{0}\ttype:{1}", this.name,this.type);
    }
}