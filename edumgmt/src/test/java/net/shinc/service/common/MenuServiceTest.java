package net.shinc.service.common;

import java.util.Collection;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;
	
	@Test
	public void testGetMenu(){
		AdminUser adminUser = new AdminUser(2);
		List<Menu> list = menuService.getMenu(adminUser);
		iterator(list);
	}
	
	public void iterator(Collection<?> c){
		for (Object object : c) {
			System.out.println(object);
		}
	}
}
