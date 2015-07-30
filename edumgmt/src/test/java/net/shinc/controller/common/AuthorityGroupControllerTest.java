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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
	public void testAddAuthorityGroup() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/addAuthGroup")
				.param("company.id", "1").param("name", "advanceAdmin").param("remark", "高级管理员");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
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
	public void testDeleteAuthorityGroup() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/deleteAuthPostion")
				.param("id", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
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
	public void testAddAuthGroupAuth() {
		try {
			List<AuthGroupHasAuth> list = new ArrayList<AuthGroupHasAuth>();
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(47)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(48)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(49)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(50)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(51)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(52)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(53)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(54)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(55)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(56)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(57)));
			list.add(new AuthGroupHasAuth(new AuthorityGroup(2), new Authority(58)));
			
			Gson g = new Gson();
			String str  = g.toJson(list);
			RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/authGroup/addAuthGroupAuth").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAuthList() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authGroup/getAuthList")
				.param("id", "2");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
