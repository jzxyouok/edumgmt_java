package net.shinc.controller.common;

import java.util.ArrayList;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.common.AuthGroupHasAuth;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
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

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class AuthorityGroupControllerTest {
	
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
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAuthorityGroup() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/addAuthGroup")
				.param("company.id", "1").param("name", "advancedAdmin").param("remark", "高级管理员");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAuthorityGroup2() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/addAuthGroup")
				.param("company.id", "1").param("name", "normalAdmin").param("remark", "管理员");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAuthorityGroup3() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/addAuthGroup")
				.param("company.id", "1").param("name", "temp").param("remark", "普通人");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testDeleteAuthorityGroup() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/deleteAuthPostion")
				.param("id", "3");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAuthorityGroupList() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/getAuthGroupList")
				.param("id", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAuthorityGroupById() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/getAuthGroupById")
				.param("id", "2");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAuthGroupAuth() {
		try {
			List<AuthGroupHasAuth> list = new ArrayList<AuthGroupHasAuth>();
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(1)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(2)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(3)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(4)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(5)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(6)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(7)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(8)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(9)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(10)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(11)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(1), new Authority(12)));
			
			Gson g = new Gson();
			String str  = g.toJson(list);
			RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/authGroup/addAuthGroupAuth").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testAddAuthGroupAuth3() {
		try {
			List<AuthGroupHasAuth> list = new ArrayList<AuthGroupHasAuth>();
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(1)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(2)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(3)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(4)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(5)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(6)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(7)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(8)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(9)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(10)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(11)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(3), new Authority(12)));
			
			Gson g = new Gson();
			String str  = g.toJson(list);
			RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/authGroup/addAuthGroupAuth").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetAuthList() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/getAuthList")
				.param("id", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
