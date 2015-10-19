package net.shinc.controller.edu.questionbank;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName QuestionBankControllerTest 
 * @Description 题库单元测试
 * @author guoshijie 
 * @date 2015年8月3日 上午11:24:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class QuestionBankControllerTest {

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
	public void testAddQuestionBank() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/addQuestionBank")
					.param("name", "中考真题").param("type", "0");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBank2() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/addQuestionBank")
    				.param("name", "高考真题").param("type", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBank3() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/addQuestionBank")
    				.param("name", "中考模拟").param("type", "2");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBank4() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/addQuestionBank")
    				.param("name", "高考模拟").param("type", "3");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/updateQuestionBank")
    				.param("name", "高考1模拟").param("type", "3")
    				.param("id", "5");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testDeleteQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/deleteQuestionBankById")
    				.param("id", "5");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankById() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/getQuestionBankById").param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankList() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/getQuestionBankList");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBankCourseKey() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/addQuestionBankCourseKey")
    				.param("questionBank.id", "1").param("course.id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetCourseListByQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/getCourseListByQuestionBank")
    				.param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionTypeByQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBank/getQuestionTypeByQuestionBank")
    				.param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
