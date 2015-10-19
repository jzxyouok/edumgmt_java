package net.shinc.controller.common;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import net.shinc.EdumgmtApplication;

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
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class QiniuControllerTest {

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
	@WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testGetUploadToken(){
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/qiniu/getUploadToken").param("videoBaseId", "90");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetBuckets(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/qiniu/getBuckets");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
