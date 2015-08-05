package net.shinc.orm.mybatis.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName Lecture 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:51:49  
 */
public class Lecture implements Serializable{

	private static final long serialVersionUID = -1973504308864577176L;

	private Integer id;
	
	@NotEmpty(message="{lecture.name.not.empty}")
    private String name;

    private String level;
    
    private Integer videoPointNum;
    
	private Integer videoQuestionNum;
	
	private Integer videoNum;

    public Lecture() {
	}
    
	public Lecture(Integer id) {
		super();
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

	public Integer getVideoPointNum() {
		return videoPointNum;
	}

	public void setVideoPointNum(Integer videoPointNum) {
		this.videoPointNum = videoPointNum;
	}

	public Integer getVideoQuestionNum() {
		return videoQuestionNum;
	}

	public void setVideoQuestionNum(Integer videoQuestionNum) {
		this.videoQuestionNum = videoQuestionNum;
	}

	public Integer getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}
}
