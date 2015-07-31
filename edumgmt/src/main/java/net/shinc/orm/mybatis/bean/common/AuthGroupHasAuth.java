package net.shinc.orm.mybatis.bean.common;

import java.io.Serializable;

/**
 * @ClassName AuthGroupHasAuth 
 * @Description 权限组与权限对应关系bean
 * @author guoshijie 
 * @date 2015年7月31日 上午9:59:21
 */
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