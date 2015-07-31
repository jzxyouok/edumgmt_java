package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @ClassName AdminUserHasAuthGroup 
 * @Description 用户与权限组的关系
 * @author guoshijie 
 * @date 2015年7月31日 上午9:59:58
 */
public class AdminUserHasAuthGroup implements Serializable {
	
	private static final long serialVersionUID = -6641534761043070866L;

	@NotNull(message="{adminUser.not.empty}")
    private AdminUser adminUser;
    
	@NotNull(message="{authorityGroup.not.empty}")
    private AuthorityGroup authorityGroup;

	public AdminUserHasAuthGroup() {
	}
	
	public AdminUserHasAuthGroup(AdminUser adminUser, AuthorityGroup authorityGroup) {
		this.adminUser = adminUser;
		this.authorityGroup = authorityGroup;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	public AuthorityGroup getAuthorityGroup() {
		return authorityGroup;
	}

	public void setAuthorityGroup(AuthorityGroup authorityGroup) {
		this.authorityGroup = authorityGroup;
	}

}