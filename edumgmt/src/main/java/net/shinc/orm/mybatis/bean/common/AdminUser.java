package net.shinc.orm.mybatis.bean.common;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassName AdminUser 
 * @Description 后台管理员
 * @author guoshijie 
 * @date 2015年7月31日 上午10:02:50
 */
public class AdminUser implements UserDetails {
    
	private static final long serialVersionUID = -9166844210456463990L;

	private Integer id;

    private String realname;

    @NotEmpty(message="{nickname.not.empty}")
    private String nickname;

    @NotEmpty(message="{password.not.empty}")
    private String password;

    private String sex;

    private String address;

    @Email
    private String email;

    private String tel;

    private String createTime;

    private String updateTime;

    @NotEmpty(message="{enabled.not.empty}")
    private String enabled;

    private String remark;

    private String position;
    
    private String headPic;
    
    @NotNull(message="{company.not.empty}")
    private Company company;
    
    private Collection<GrantedAuthority> authorities;
    
    private List<Authority> authList;
    
    private AuthorityGroup authGroup;
    
    private List<Menu> menuMap;
    
    public static AdminUser getCurrentUser() {
		Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(o instanceof AdminUser) {
			return (AdminUser)o;
		}
		return null;
	}
	
	public static String getCurrentUsername() {
		AdminUser currentUser = getCurrentUser();
		if(currentUser != null) {
			return currentUser.getNickname();
		}
		return null;
	}
    
    public AdminUser() {
	}

	public AdminUser(Integer id) {
		this.id = id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }
    
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.nickname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if("1".equals(this.enabled)) {
			return true; 
		} else {
			return false;
		}
	}

	public List<Menu> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(List<Menu> menuMap) {
		this.menuMap = menuMap;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public AuthorityGroup getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(AuthorityGroup authGroup) {
		this.authGroup = authGroup;
	}

	public List<Authority> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Authority> authList) {
		this.authList = authList;
	}

}