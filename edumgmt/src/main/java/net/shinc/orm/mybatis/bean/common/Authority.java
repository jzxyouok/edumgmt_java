package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

/**
 * @ClassName Authority 
 * @Description 权限
 * @author guoshijie 
 * @date 2015年7月31日 上午9:58:57
 */
public class Authority implements GrantedAuthority,Serializable {
	
	private static final long serialVersionUID = -3830618257463315425L;

	private Integer id;

    @NotNull(message="{company.not.empty}")
    private Company company;

    @NotEmpty(message="{authority.not.empty}")
    private String authority;

    private String remark;

    public Authority() {
	}
    
	public Authority(Integer id) {
		this.id = id;
	}

	public Authority(Company company, String authority, String remark) {
		this.company = company;
		this.authority = authority;
		this.remark = remark;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
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
		return MessageFormat.format("authority:{0}\tremark:{1}", this.authority,this.remark);
	}
    
}