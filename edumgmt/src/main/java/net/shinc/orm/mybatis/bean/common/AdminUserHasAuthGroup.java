package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;

public class AdminUserHasAuthGroup implements Serializable {
	
	private static final long serialVersionUID = -6641534761043070866L;

    private AdminUser adminUser;
    
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