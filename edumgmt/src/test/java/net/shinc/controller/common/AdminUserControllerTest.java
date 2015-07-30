package net.shinc.controller.common;

import net.shinc.InfoMgmtApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
    	mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
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
	public void testAddAdminUser3() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/addAdminUser")
				.param("company.id", "3").param("realname", "张盼")
				.param("nickname", "steven").param("password", "123456")
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
	public void testGetAdminUserList() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getAdminUserList")
					.param("page", "1").param("id", "3");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAdminUserById() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getAdminUserById").param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteAdminUser() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/deleteAdminUser").param("id", "3");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
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
	public void testGetMenu(){
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/getMenu").param("id", "90");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdminLogin() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUser/adminLogin").param("nickname", "root").param("pwd", "root");
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
