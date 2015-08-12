package net.shinc.service.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AuthGroupHasAuth;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @ClassName AuthorityGroupService 
 * @Description 权限组接口
 * @author guoshijie 
 * @date 2015年7月13日 下午10:08:32
 */
public interface AuthorityGroupService {

	/**
	 * 获取权限组列表
	 * @return
	 */
	public List<AuthorityGroup> getAuthorityGroupList(Company company);
	
	/**
	 * 获取权限组列表总条数
	 * @return
	 */
	public Integer getAuthorityGroupListCount();
	
	/**
	 * 根据id获取权限组
	 * @param authorityGroup
	 * @return
	 */
	public AuthorityGroup getAuthorityGroupById(AuthorityGroup authorityGroup);
	
	/**
	 * 新增权限组
	 * @param authorityGroup
	 * @return
	 */
	public Integer addAuthorityGroup(AuthorityGroup authorityGroup);
	
	/**
	 * 删除权限组
	 * @param authGroupId
	 * @return
	 */
	public Integer deleteAuthorityGroup(Integer authGroupId);
	
	/**
	 * 更新权限组
	 * @param adminUser
	 * @return
	 */
	public Integer updateAuthorityGroup(AuthorityGroup AuthorityGroup);
	
	/**
	 * 查询权限组下的员工
	 * @param authorityGroup
	 * @return
	 */
	public List<AdminUser> getAdminUserListByPosition(AuthorityGroup authorityGroup,PageBounds pageBounds);
	
	/**
	 * 给权限组添加权限
	 * @param list
	 * @return
	 */
	public Integer addAuthGroupHasAuth(List<AuthGroupHasAuth> list);
	
	/**
	 * 删除权限组的所有权限
	 * @param authorityGroup
	 * @return
	 */
	public Integer deleteAuthGroupHasAuth(Integer authGroupId);
	
	/**
	 * 删除该权限组与用户的对应关系
	 * @param authGroupId
	 * @return
	 */
	public Integer deleteAuthGroupHasUser(Integer authGroupId);
	
	/**
	 * 删除该用户与权限组的对应关系
	 * @param adminUserId
	 * @return
	 */
	public Integer deleteAdminUserHasAuthGroup(Integer adminUserId);
	
	/**
	 * 获取权限组的所有权限列表
	 * @param authorityGroup
	 * @return
	 */
	public List<Authority> getAuthorityList(AuthorityGroup authorityGroup);
	
	/**
	 * 给某权限组设置权限列表，去除一级权限
	 * @param list
	 */
	public void setAuthList(AuthorityGroup authGroup);
}
