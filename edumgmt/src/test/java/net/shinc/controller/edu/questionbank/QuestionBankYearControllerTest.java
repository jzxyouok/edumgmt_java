package net.shinc.controller.edu.questionbank;

import java.util.ArrayList;
import java.util.List;

import net.shinc.EdumgmtApplication;
import net.shinc.orm.mybatis.bean.edu.QuestionBank;
import net.shinc.orm.mybatis.bean.edu.QuestionBankYear;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
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

import com.google.gson.Gson;

/**
 * @ClassName QuestionBankYearControllerTest 
 * @Description 题库与年份对应关系单元测试
 * @author guoshijie 
 * @date 2015年8月3日 上午11:24:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class QuestionBankYearControllerTest {

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
	public void testAddQuestionBankYear() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankYear/addQuestionBankYear")
					.param("questionBank.id", "1").param("year", "2011");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBankYearBatch() {
    	try {
    		List<QuestionBankYear> list = new ArrayList<QuestionBankYear>();
    		list.add(new QuestionBankYear(new QuestionBank(1), "2012"));
    		list.add(new QuestionBankYear(new QuestionBank(1), "2013"));
    		list.add(new QuestionBankYear(new QuestionBank(1), "2014"));
    		list.add(new QuestionBankYear(new QuestionBank(1), "2015"));
    		
    		Gson g = new Gson();
    		String str  = g.toJson(list);
    		RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/questionBankYear/addQuestionBankYearBatch").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateQuestionBankYear() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankYear/updateQuestionBankYear").param("id", "6")
    				.param("year", "2015");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testDeleteQuestionBankYear() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankYear/deleteQuestionBankYearById")
    				.param("id", "7");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankYearById() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankYear/getQuestionBankYearById").param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankYearByQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankYear/getQuestionBankYearByQuestionBank").param("id", "2");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
