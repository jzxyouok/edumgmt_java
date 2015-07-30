package net.shinc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class AdminUserPositionControllerTest {

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
    public void testAddAdminUserPosition() {
		try {
			mockMvc.perform(get("/adminUserPosition/addAdminUserPosition").param("position", "普通管理员")
					.param("remark", "不可以选择管理员管理")).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void testGetAdminUserPosition() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUserPosition/getAdminUserPosition");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void testGetAdminUserPositionById() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUserPosition/getAdminUserPositionById").param("id", "2");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testDeleteAdminUserPosition() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/adminUserPosition/deleteAdminUserPostion").param("id", "12");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
