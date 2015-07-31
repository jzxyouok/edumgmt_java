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

/**
 * @ClassName CompanyControllerTest 
 * @Description 企业控制层测试
 * @author guoshijie 
 * @date 2015年7月16日 下午5:52:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class CompanyControllerTest {

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
	public void testGetCompanyList() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/company/getCompanyList")
					.param("page", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
	public void testGetCompanyById() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/company/getCompanyById").param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    public void testAddCompany() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/company/addCompany")
				.param("companyName", "大宇宙信息创造（中国）有限公司")
				.param("address", "天津市西青区")
				.param("name", "胡汉三").param("tel", "12345678913")
				.param("enabled", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void testUpdateCompany() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/company/updateCompany")
    			.param("id", "3").param("companyName", "大宇宙信息创造（中国）有限公司")
    			.param("address", "天津市西青区")
    			.param("name", "张天才").param("tel", "12345678913")
    			.param("enabled", "1");
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
	public void testDeleteCompany() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/company/deleteCompany").param("id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
