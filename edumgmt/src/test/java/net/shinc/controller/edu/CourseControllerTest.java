package net.shinc.controller.edu;

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

/**
 * @ClassName CourseControllerTest 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年8月3日 下午8:55:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class CourseControllerTest {

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
    public void testAddCourse(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/course/addCourse")
    				.param("name", "语文").param("shortName", "语");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateCourse(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/course/updateCourse").param("id", "1")
    				.param("name", "语文").param("shortName", "语");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetCourseById(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/course/getCourseById")
    				.param("id", "12");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetCourseList(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/course/getCourseList")
    				.param("id", "12");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testDeleteCourse(){
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/course/deleteCourse")
    				.param("id", "12");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
}
