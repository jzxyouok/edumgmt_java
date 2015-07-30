package net.shinc.controller;

import net.shinc.InfoMgmtApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class TestControllerTest {
	
	 @Autowired  
    private WebApplicationContext wac;  
    private MockMvc mockMvc;
	@Test
	public void testTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/test"))
		.andDo(MockMvcResultHandlers.print());
	}
}
