package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;

/**
 * @ClassName Company 
 * @Description 公司bean
 * @author guoshijie 
 * @date 2015年7月31日 上午9:58:15
 */
public class Company implements Serializable {
	
	private static final long serialVersionUID = -7783304322148516331L;

	private Integer id;

    private String companyName;

    private String address;

    private String name;

    private String tel;

    private String enabled;

    private String createTime;

    private String updateTime;

    public Company() {
	}
    
	public Company(Integer id) {
		this.id = id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}