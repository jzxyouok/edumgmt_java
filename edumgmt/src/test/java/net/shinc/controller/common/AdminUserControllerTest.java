package net.shinc.controller.common;

import net.shinc.InfoMgmtApplication;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class AdminUserControllerTest {
	
	@Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;
    private ResultHandler handler;
    
    @Before  
    public void init(){  
    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build(); 
    	handler = MockMvcResultHandlers.print();
    } 
    
    @Test
    public void Login() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/login")
    			.param("username", "root")
    			.param("password", "root");
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAdminUser() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/addAdminUser")
				.param("company.id", "1").param("realname", "管理员")
				.param("nickname", "admin").param("password", "admin")
				.param("sex", "0").param("address", "北京朝阳区望京中心")
				.param("email", "admin_hi@163.com").param("tel", "13611113333")
				.param("enabled", "1").param("remark", "数学讲师").param("position", "老师")
				.param("headPic", "http://p2.gexing.com/touxiang/20120802/0922/5019d66eef7ed_200x200_3.jpg");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAdminUser2() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/addAdminUser")
				.param("company.id", "3").param("realname", "张盼")
				.param("nickname", "root").param("password", "root")
				.param("sex", "0").param("address", "北京朝阳区望京中心")
				.param("email", "admin_hi@163.com").param("tel", "13611113333")
				.param("enabled", "1").param("remark", "数学讲师").param("position", "老师")
				.param("headPic", "http://p2.gexing.com/touxiang/20120802/0922/5019d66eef7ed_200x200_3.jpg");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAdminUser3() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/addAdminUser")
				.param("company.id", "1").param("realname", "测试1")
				.param("nickname", "test1").param("password", "123456")
				.param("sex", "0").param("address", "北京朝阳区望京中心")
				.param("email", "zhangpan@163.com").param("tel", "13611113333")
				.param("enabled", "1").param("remark", "语文老师").param("position", "老师")
				.param("headPic", "http://p2.gexing.com/touxiang/20120802/0922/5019d66eef7ed_200x200_3.jpg");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAdminUserList() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders
					.post("/adminUser/getAdminUserList")
					.with(user("admin").password("admin").authorities(AuthorityUtils.createAuthorityList("adminUserList")))
					.param("page", "1").param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAdminUserListNoPage() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders
					.post("/adminUser/getAdminUserList")
					.param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAdminUserById() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getAdminUserById").param("id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAdminUserByNickName() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getAdminUserByNickName").param("nickname", "admin");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testDeleteAdminUser() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/deleteAdminUser").param("id", "4");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testUpdateAdminUser() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/updateAdminUser").param("id", "4")
					.param("company.id", "3").param("realname", "张二")
					.param("nickname", "root").param("password", "root")
					.param("sex", "0").param("address", "北京朝阳区望京中心")
					.param("email", "admin_hi@163.com").param("tel", "13611113333")
					.param("enabled", "1").param("remark", "数学讲师").param("position", "老师")
					.param("headPic", "http://p2.gexing.com/touxiang/20120802/0922/5019d66eef7ed_200x200_3.jpg");
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetMenu(){
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getMenu").param("id", "90");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testLogin() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/login").param("nickname", "admin").param("pwd", "admin");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 * 修改密码 by王智颖
	 */
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testUpdatePassword() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/updatePassword")
				.param("id", "90")
				.param("password", "1")
				.param("newpassword1", "11")
				.param("newpassword2", "11");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
