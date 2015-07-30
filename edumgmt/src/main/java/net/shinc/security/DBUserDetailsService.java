package net.shinc.security;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.mappers.common.AdminUserMapper;
import net.shinc.service.common.AdminUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class DBUserDetailsService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(DBUserDetailsService.class);

	@Autowired
	private AdminUserMapper adminUserMapper;
	
	@Autowired
	private AdminUserService adminUserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AdminUser user = adminUserService.getAdminUserByNickName(username);
		if(null != user){	
			logger.info("user found:" + user);
			return user;
		} else {
			throw new UsernameNotFoundException(username);
		}
		
	}

}
