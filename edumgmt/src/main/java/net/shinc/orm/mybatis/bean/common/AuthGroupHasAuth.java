package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;

public class AuthGroupHasAuth implements Serializable{
    
	private static final long serialVersionUID = 8113503829521738514L;

    private Authority authority;
    
    private AuthorityGroup authorityGroup;
    
	public AuthGroupHasAuth() {
	}

	public AuthGroupHasAuth(AuthorityGroup authorityGroup, Authority authority) {
		this.authority = authority;
		this.authorityGroup = authorityGroup;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public AuthorityGroup getAuthorityGroup() {
		return authorityGroup;
	}

	public void setAuthorityGroup(AuthorityGroup authorityGroup) {
		this.authorityGroup = authorityGroup;
	}
    
}