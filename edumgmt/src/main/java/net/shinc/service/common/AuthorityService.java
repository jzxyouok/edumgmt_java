package net.shinc.service.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Authority;

/**
 * @ClassName AuthorityService 
 * @Description 后台管理用户权限接口
 * @author guoshijie 
 * @date 2015年7月13日 下午10:08:32
 */
public interface AuthorityService {

	/**
	 * 获取后台管理用户全量权限列表
	 * @return
	 */
	public List<Authority> getAllAuthorityList();
	
	/**
	 * 查询某管理员权限
	 * @param adminUser
	 * @return
	 */
	public List<Authority> getAuthorityList(AdminUser adminUser);
	
	/**
	 * 根据id获取后管理用户权限
	 * @param id
	 * @return
	 */
	public Authority getAuthority(Integer id);
	
	/**
	 * 新增管理员权限
	 * @param Authority
	 * @return
	 */
	public Integer addAuthority(Authority Authority);
	
	/**
	 * 批量插入管理员权限
	 * @param authList
	 * @return
	 */
	public Integer addAuthorityBatch(List<Authority> authList);
	
	/**
	 * 删除管理员权限
	 * @param Authority
	 * @return
	 */
	public Integer deleteAuthority(Authority Authority);
	
	/**
	 * 更新管理员权限
	 * @param adminUser
	 * @return
	 */
	public Integer updateAuthority(Authority Authority);
	
}
