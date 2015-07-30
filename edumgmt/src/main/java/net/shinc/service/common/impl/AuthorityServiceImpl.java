package net.shinc.service.common.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.mappers.common.AuthorityMapper;
import net.shinc.service.common.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AuthorityServiceImpl 
 * @Description 后台管理用户权限服务接口实现
 * @author guoshijie 
 * @date 2015年7月17日 上午10:23:38
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityMapper authorityMapper;
	
	@Override
	public List<Authority> getAllAuthorityList() {
		return authorityMapper.getAuthorityList();
	}

	@Override
	public Authority getAuthority(Integer id) {
		return authorityMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer addAuthority(Authority authority) {
		return authorityMapper.insert(authority);
	}

	@Override
	public Integer deleteAuthority(Authority authority) {
		return authorityMapper.deleteByPrimaryKey(authority.getId());
	}

	@Override
	@Transactional
	public Integer updateAuthority(Authority authority) {
		authorityMapper.deleteByPrimaryKey(authority.getId());
		authority.setId(null);
		return authorityMapper.insert(authority);
	}

	@Override
	public Integer addAuthorityBatch(List<Authority> authList) {
		if(null != authList && authList.size() > 0) {
			return authorityMapper.addAuthorityBatch(authList);
		}
		return 0;
	}

	@Override
	public List<Authority> getAuthorityList(AdminUser adminUser) {
		return null;
	}
	
//	@Override
//	public List<AdminUserHasAuth> dealAuthList(Collection<Authority> authList,AdminUser adminUser) {
//		List<AdminUserHasAuth> list = new ArrayList<AdminUserHasAuth>();
//		if(null != authList && authList.size() > 0) {
//			for (Authority obj : authList) {
//				Authority temp = new Authority(obj.getId());
//				Authority Authority = adminUserAuthMapper.getAuthority(temp);
//				AdminUserHasAuth adminUserHasAuth = new AdminUserHasAuth(adminUser, Authority);
//				list.add(adminUserHasAuth);
//			}
//		} else {
//			return null;
//		}
//		return list;
//	}
	
//	@Override
//	public List<Authority> getAuthorityList(AdminUser adminUser) {
//		return adminUserHasAuthMapper.getAuthority(adminUser);
//	}
	
}
