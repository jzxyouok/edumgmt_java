package net.shinc.service.common;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName AdminUserService 
 * @Description 后台管理用户接口
 * @author guoshijie 
 * @date 2015年7月13日 下午10:08:32
 */
public interface AdminUserService {

	/**
	 * 获取后台管理用户列表(分页)
	 * @return
	 */
	public PageList<AdminUser> getAdminUserList(PageBounds pageBounds,Company company);
	
	/**
	 * 获取后台管理用户列表(不分页)
	 * @return
	 */
	public List<AdminUser> getAdminUserList(Company company);
	
	/**
	 * 获取后台管理用户列表总条数
	 * @return
	 */
	public Integer getAdminUserListCount();
	
	/**
	 * 新增管理员
	 * @param adminUser
	 * @return
	 */
	public Integer addAdminUser(AdminUser adminUser);
	
	/**
	 * 删除管理员
	 * @param adminUser
	 * @return
	 */
	public Integer deleteAdminUser(AdminUser adminUser);
	
	/**
	 * 更新管理员
	 * @param adminUser
	 * @return
	 */
	public Integer updateAdminUser(AdminUser adminUser);
	
	/**
	 * 根据id查询AdminUser
	 * @param integer
	 * @return
	 */
	public AdminUser getAdminUserById(Integer adminId);
	
	public AdminUser getAdminUserByNickName(String nickname);
	
	/**
	 * 获取某公司下所有员工
	 * @param company
	 * @return
	 */
	public PageList<AdminUser> getAdminUserByCompany(Company company,PageBounds pageBounds);
	
	/**
	 * 将用户添加到某权限组
	 * @param adminUser
	 * @param authGroup
	 * @return
	 */
	public Integer addAuthGroupForUser(AdminUser adminUser, AuthorityGroup authGroup);
	
	/**
	 * 查询用户所属的权限组
	 * @param adminUser
	 * @return
	 */
	public List<AuthorityGroup> getAuthGroup(AdminUser adminUser);
	
	/**
	 * 查询用户所具有的权限列表
	 * @param adminUser
	 * @return
	 */
	public List<Authority> getAuthList(AdminUser adminUser);
	
	/**
	 * 获取用户所有的权限
	 * @param adminUser
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(AdminUser adminUser);
	
}
