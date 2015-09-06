package net.shinc.controller.edu.video;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class VideoPicControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private ResultHandler handler;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		handler = MockMvcResultHandlers.print();
	}
	
	@Test
	@Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void TestDeleteVideoPic() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoPic/deleteVideoPic")
    			.param("id", "103").param("storeInfo", "o_19tfvakei1vvaajpc5i1u3phheb.png");
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
