package net.shinc.orm.mybatis.bean.edu;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName Keyword 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:18  
 */
public class Keyword {
    private Integer id;

    @NotEmpty(message="{keyword.name.not.empty}")
    private String name;

    public Keyword() {
	}
    
	public Keyword(String name) {
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
}