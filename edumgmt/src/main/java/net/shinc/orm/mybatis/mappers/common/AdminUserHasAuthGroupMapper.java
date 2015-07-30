package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AdminUserHasAuthGroup;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;


public interface AdminUserHasAuthGroupMapper {
	
    public int addAdminUserHasAuthGroup(AdminUserHasAuthGroup record);
    
    public int deleteAdminUserHasAuthGroup(AdminUser adminUser);
    
    public List<AuthorityGroup> getAuthGroup(AdminUser adminUser);
}
