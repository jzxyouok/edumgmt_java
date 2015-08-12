package net.shinc.service.common.impl;

import java.util.ArrayList;
import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AuthGroupHasAuth;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.orm.mybatis.bean.common.Menu;
import net.shinc.orm.mybatis.mappers.common.AdminUserHasAuthGroupMapper;
import net.shinc.orm.mybatis.mappers.common.AdminUserMapper;
import net.shinc.orm.mybatis.mappers.common.AuthGroupHasAuthMapper;
import net.shinc.orm.mybatis.mappers.common.AuthorityGroupMapper;
import net.shinc.service.common.AuthorityGroupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @ClassName AuthorityGroupServiceImpl
 * @Description 权限组功能实现
 * @author guoshijie
 * @date 2015年7月30日 下午12:25:39
 */
@Service
public class AuthorityGroupServiceImpl implements AuthorityGroupService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AuthorityGroupMapper authorityGroupMapper;

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Autowired
	private AuthGroupHasAuthMapper authGroupHasAuthMapper;

	@Autowired
	private AdminUserHasAuthGroupMapper adminUserHasAuthGroupMapper;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public List<AuthorityGroup> getAuthorityGroupList(Company company) {
		if (null != company) {
			List<AuthorityGroup> list = authorityGroupMapper.selectAllAuthorityGroup(company);
			setAuthList(list);
			return list;
		}
		return null;
	}

	/**
	 * 给权限组设置权限列表，去除一级权限
	 * 
	 * @param list
	 */
	public void setAuthList(List<AuthorityGroup> list) {
		if (null != list && list.size() > 0) {
			for (AuthorityGroup authGroup : list) {
				setAuthList(authGroup);
			}
		}
	}

	/**
	 * 给某权限组设置权限列表，去除一级权限
	 * 
	 * @param list
	 */
	@Override
	public void setAuthList(AuthorityGroup authGroup) {
		List<Authority> list = getAuthorityList(authGroup);
		List<Authority> list2 = dealAuthorityList(list);
		authGroup.setAuthList(list2);
	}

	/**
	 * 删除权限组权限列表中的一级权限
	 * 
	 * @param list
	 * @return
	 */
	public List<Authority> dealAuthorityList(List<Authority> list) {
		AdminUser currentUser = AdminUser.getCurrentUser();
		if (null != currentUser) {
			List<Menu> menuMap = currentUser.getMenuMap();
			List<Authority> tempList = new ArrayList<Authority>();
			for (Menu menu : menuMap) {
				String tag = menu.getTag();
				for (Authority auth : list) {
					if (tag.equals(auth.getAuthority())) {
						tempList.add(auth);
					}
				}
			}
			list.removeAll(tempList);
			return list;
		}
		return null;
	}

	@Override
	public Integer getAuthorityGroupListCount() {
		return authorityGroupMapper.getAuthorityGroupListCount();
	}

	@Override
	public AuthorityGroup getAuthorityGroupById(AuthorityGroup authorityGroup) {
		if (null != authorityGroup) {
			return authorityGroupMapper.selectByPrimaryKey(authorityGroup.getId());
		}
		return null;
	}

	@Override
	public Integer addAuthorityGroup(AuthorityGroup authorityGroup) {
		if (null != authorityGroup) {
			return authorityGroupMapper.insert(authorityGroup);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer deleteAuthorityGroup(Integer authGroupId) {
		if (null != authGroupId) {
			adminUserHasAuthGroupMapper.deleteAdminUserHasAuthGroup(authGroupId);// 解除该权限组与用户的对应关系
			authGroupHasAuthMapper.deleteAuthGroupHasAuth(authGroupId);// 删除权限组所有权限
			return authorityGroupMapper.deleteByPrimaryKey(authGroupId);// 删除权限组
		}
		return 0;
	}

	@Override
	public Integer updateAuthorityGroup(AuthorityGroup authorityGroup) {
		if (null != authorityGroup) {
			return authorityGroupMapper.updateByPrimaryKeySelective(authorityGroup);
		}
		return 0;
	}

	@Override
	public List<AdminUser> getAdminUserListByPosition(AuthorityGroup authorityGroup, PageBounds pageBounds) {
		List<AdminUser> list = adminUserMapper.getAdminUserListByPosition(authorityGroup.getId(), pageBounds);
		return list;
	}

	@Override
	public Integer addAuthGroupHasAuth(List<AuthGroupHasAuth> list) {
		if (null != list && list.size() > 0) {
			return authGroupHasAuthMapper.insertBatch(list);
		}
		return 0;
	}

	@Override
	public Integer deleteAuthGroupHasAuth(Integer authGroupId) {
		if (null != authGroupId) {
			return authGroupHasAuthMapper.deleteAuthGroupHasAuth(authGroupId);
		}
		return 0;
	}

	@Override
	public List<Authority> getAuthorityList(AuthorityGroup authorityGroup) {
		if (null != authorityGroup) {
			return authGroupHasAuthMapper.getAuthList(authorityGroup);
		}
		return null;
	}

	@Override
	public Integer deleteAuthGroupHasUser(Integer authGroupId) {
		if (null != authGroupId) {
			return adminUserHasAuthGroupMapper.deleteAdminUserHasAuthGroup(authGroupId);
		}
		return null;
	}

	@Override
	public Integer deleteAdminUserHasAuthGroup(Integer adminUserId) {
		if (null != adminUserId) {
			return adminUserHasAuthGroupMapper.deleteAdminHasAuthGroup(adminUserId);
		}
		return null;
	}

}
