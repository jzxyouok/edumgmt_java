package net.shinc.controller;

import net.shinc.InfoMgmtApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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

/** 
 * @ClassName KeywordControllerTest 
 * @Description 关键字测试
 * @author wangzhiying 
 * @date 2015年8月4日 下午12:33:37  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class KeywordControllerTest {
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
	public void testDeleteKeyword() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/keywordManager/deleteKeyword")
					.param("id", "100");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testInsertKeyword() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/keywordManager/insertKeyword")
				.param("id", "11111")
				.param("name", "迈迈君");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testSelectAllKeyword() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/keywordManager/selectAllKeyword");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testSelectKeyword() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/keywordManager/selectKeyword")
					.param("name", "关");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
