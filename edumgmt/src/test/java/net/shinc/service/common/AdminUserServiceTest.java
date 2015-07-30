package net.shinc.service.common;

import java.util.Collection;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class AdminUserServiceTest {

	@Autowired
	private AdminUserService adminUserService;
	
	@Test
	public void testAddAuthGroupForUser(){
		AdminUser adminUser = new AdminUser(2);
		AuthorityGroup authGroup = new AuthorityGroup(2);
		Integer num = adminUserService.addAuthGroupForUser(adminUser, authGroup);
		System.out.println("insert==》"+num);
	}
	
	@Test
	public void testGetAuthGroup(){
		AdminUser adminUser = new AdminUser(2);
		List<AuthorityGroup> list = adminUserService.getAuthGroup(adminUser);
		iterator(list);
	}
	
	public void iterator(Collection<?> c){
		for (Object object : c) {
			System.out.println(object);
		}
	}
	
}
