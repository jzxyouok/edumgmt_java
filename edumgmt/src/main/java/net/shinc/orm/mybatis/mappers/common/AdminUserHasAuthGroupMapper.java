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
    
    /**
     * 解除该用户与权限组的对应关系
     * @param adminUserId 用户id
     * @return
     */
    public int deleteAdminHasAuthGroup(Integer adminUserId);
    
    public List<AuthorityGroup> getAuthGroup(AdminUser adminUser);
    
}
