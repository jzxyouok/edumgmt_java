package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName AuthorityGroup 
 * @Description 权限组bean
 * @author guoshijie 
 * @date 2015年7月31日 上午9:58:37
 */
public class AuthorityGroup implements Serializable{
	
	private static final long serialVersionUID = 697893253677302016L;

	private Integer id;

    @NotNull(message="{company.not.empty}")
    private Company company;

    @NotEmpty(message="{authGroupName.not.empty}")
    private String name;

    private String remark;
    
    private List<Authority> authList;

    public AuthorityGroup() {
	}
    
	public AuthorityGroup(Integer id) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("id:{0}\tname:{1}\tremark:{2}", this.id,this.name,this.remark);
	}

	public List<Authority> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Authority> authList) {
		this.authList = authList;
	}
    
}