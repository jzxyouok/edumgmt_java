package net.shinc.controller.edu;

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
 * @ClassName LectureControllerTest 
 * @Description 讲解人功能测试
 * @author wangzhiying 
 * @date 2015年8月3日 下午5:38:33  
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class LectureControllerTest {
	
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
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testSelectAllLecture() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/lectureManager/selectAllLecture")
					.param("page", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testSelectLectureById() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/lectureManager/selectLectureById")
					.param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testInsertLecture() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/lectureManager/insertLecture")
				.param("id", "11111")
				.param("name", "迈迈君")
				.param("level", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateLectureById() {
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/lectureManager/updateLecture")
    			.param("id", "2")
    			.param("name", "张天才3")
    			.param("level", "100");
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
	public void testDeleteLectureById() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/lectureManager/deleteLecture")
					.param("id", "111");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

}
