package net.shinc.orm.mybatis.bean;

/** 
 * @ClassName QuestionBankYear 
 * @Description 真题模拟题与年份关系bean
 * @author guoshijie 
 * @date 2015年7月31日 下午4:50:32  
 */
public class QuestionBankYear {
    private Integer id;

    private Integer questionBankId;

    private String year;

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

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

}