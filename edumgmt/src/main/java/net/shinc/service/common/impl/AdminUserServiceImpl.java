package net.shinc.service.common.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AdminUserHasAuthGroup;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.orm.mybatis.mappers.common.AdminUserHasAuthGroupMapper;
import net.shinc.orm.mybatis.mappers.common.AdminUserMapper;
import net.shinc.orm.mybatis.mappers.common.CompanyMapper;
import net.shinc.service.common.AdminUserService;
import net.shinc.service.common.AuthorityGroupService;
import net.shinc.service.common.MenuService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName AdminUserServiceImpl
 * @Description 后台管理用户接口实现类
 * @author guoshijie
 * @date 2015年7月14日 上午11:53:24
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AdminUserHasAuthGroupMapper adminUserHasAuthGroupMapper;

	@Autowired
	private AuthorityGroupService authGroupService;

	@Autowired
	private MenuService menuService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public static String pattern = "yyyy-MM-dd HH:mm:ss";

	@Override
	public PageList<AdminUser> getAdminUserList(PageBounds pageBounds, Company company) {
		if (null != company) {
			List<AdminUser> list = adminUserMapper.getAdminUserList(company, pageBounds);
			PageList<AdminUser> pageList = (PageList<AdminUser>) list;
			return pageList;
		}
		return null;
	}
	
	@Override
	public List<AdminUser> getAdminUserList(Company company) {
		if (null != company) {
			List<AdminUser> list = adminUserMapper.getAdminUserList(company);
			return list;
		}
		return null;
	}

	@Override
	public Integer getAdminUserListCount() {
		return adminUserMapper.getAdminUserListCount();
	}

	@Override
	@Transactional
	public Integer addAdminUser(AdminUser adminUser) {
		if (null != adminUser) {
			try {
				adminUser.setCreateTime(ShincUtil.formatDate(new Date(), pattern));
				adminUser.setUpdateTime(ShincUtil.formatDate(new Date(), pattern));
				int i = adminUserMapper.insert(adminUser);
				addAuthGroupForUser(adminUser, adminUser.getAuthGroup());
				return i;
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer deleteAdminUser(AdminUser adminUser) {
		if (null != adminUser) {
			authGroupService.deleteAdminUserHasAuthGroup(adminUser.getId());// 解除用户与权限组的关系
			return adminUserMapper.deleteByPrimaryKey(adminUser.getId());
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer updateAdminUser(AdminUser adminUser) {
		if (null != adminUser) {
			adminUser.setUpdateTime(ShincUtil.formatDate(new Date(), pattern));
			Integer i = adminUserMapper.updateByPrimaryKeySelective(adminUser);
			if(null != adminUser.getAuthGroup()) {
				authGroupService.deleteAdminUserHasAuthGroup(adminUser.getId());
				addAuthGroupForUser(adminUser, adminUser.getAuthGroup());
			}
			return i;
		}
		return 0;
	}

	@Override
	public AdminUser getAdminUserById(Integer adminId) {
		if (null != adminId) {
			AdminUser admin = adminUserMapper.getAdminUserById(adminId);
			List<AuthorityGroup> list = getAuthGroup(admin);
			if(null != list && list.size() == 1) {
				AuthorityGroup group = list.get(0);
				authGroupService.setAuthList(group);
				admin.setAuthGroup(group);
			}
			return admin;
		}
		return null;
	}

	@Override
	public PageList<AdminUser> getAdminUserByCompany(Company company, PageBounds pageBounds) {
		List<AdminUser> list = adminUserMapper.getAdminUserByCompany(company.getId(), pageBounds);
		PageList<AdminUser> pageList = (PageList<AdminUser>) list;
		return pageList;
	}

	@Override
	public AdminUser getAdminUserByNickName(String nickname) {
		if (null != nickname) {
			AdminUser admin = adminUserMapper.getAdminUserByNickName(nickname);
			if (null != admin) {
				admin.setMenuMap(menuService.getMenu(admin));
				admin.setAuthorities(getAuthorities(admin));
			}
			return admin;
		}
		return null;
	}

	@Override
	public Integer addAuthGroupForUser(AdminUser adminUser, AuthorityGroup authGroup) {
		if (null != adminUser && null != authGroup) {
			return adminUserHasAuthGroupMapper.addAdminUserHasAuthGroup(new AdminUserHasAuthGroup(adminUser, authGroup));
		}
		return 0;
	}

	@Override
	public List<AuthorityGroup> getAuthGroup(AdminUser adminUser) {
		if (null != adminUser) {
			List<AuthorityGroup> list = adminUserHasAuthGroupMapper.getAuthGroup(adminUser);
			return list;
		}
		return null;
	}

	@Override
	public List<Authority> getAuthList(AdminUser adminUser) {
		List<Authority> authList = new ArrayList<Authority>();
		if (null != adminUser) {
			List<AuthorityGroup> authGroup = getAuthGroup(adminUser);
			if (null != authGroup && authGroup.size() > 0) {
				for (AuthorityGroup authorityGroup : authGroup) {
					List<Authority> list = authGroupService.getAuthorityList(authorityGroup);
					authList.addAll(list);
				}
			}
		}
		return authList;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(AdminUser adminUser) {
		Collection<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		if (null != adminUser) {
			List<Authority> authList = getAuthList(adminUser);
			for (Authority authority : authList) {
				list.add(authority);
			}
			return list;
		}
		return null;
	}

}
