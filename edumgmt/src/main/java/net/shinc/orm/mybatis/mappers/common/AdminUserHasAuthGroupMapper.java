package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AdminUserHasAuthGroup;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;


public interface AdminUserHasAuthGroupMapper {
	
    public int addAdminUserHasAuthGroup(AdminUserHasAuthGroup record);
    
    /**
     * 解除该权限组与用户的对应关系
     * @param authGroupId 权限组id
     * @return
     */
    public int deleteAdminUserHasAuthGroup(Integer authGroupId);
    
    public List<AuthorityGroup> getAuthGroup(AdminUser adminUser);
    
}
