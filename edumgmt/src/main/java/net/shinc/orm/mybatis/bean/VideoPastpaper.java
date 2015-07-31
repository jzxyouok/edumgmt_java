package net.shinc.orm.mybatis.bean;

/**
 * @ClassName: VideoPastpaper
 * @Description: 真题模拟题具体信息
 * @author hushichong
 * @date 2015年7月31日 下午3:41:54
 */
public class VideoPastpaper {
	
	private Integer id;

	private Integer videoBaseId;

	private Integer questionbankId;

	private Integer questionbankYearId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVideoBaseId() {
		return videoBaseId;
	}

	public void setVideoBaseId(Integer videoBaseId) {
		this.videoBaseId = videoBaseId;
	}

	public Integer getQuestionbankId() {
		return questionbankId;
	}

	public void setQuestionbankId(Integer questionbankId) {
		this.questionbankId = questionbankId;
	}

	public Integer getQuestionbankYearId() {
		return questionbankYearId;
	}

	public void setQuestionbankYearId(Integer questionbankYearId) {
		this.questionbankYearId = questionbankYearId;
	}

}