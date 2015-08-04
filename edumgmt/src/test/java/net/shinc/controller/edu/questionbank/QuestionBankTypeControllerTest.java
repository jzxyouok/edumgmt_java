package net.shinc.controller.edu.questionbank;

import java.util.ArrayList;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankType;

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
 * @ClassName QuestionBankTypeControllerTest 
 * @Description 题库版本单元测试
 * @author guoshijie 
 * @date 2015年8月3日 上午11:24:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class QuestionBankTypeControllerTest {

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
	public void testAddQuestionBankType() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankType/addQuestionBankType")
					.param("questionBank.id", "1").param("name", "北京卷");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddQuestionBankTypeBatch() {
    	try {
    		QuestionBank questionBank = new QuestionBank(1);
    		List<QuestionBankType> list = new ArrayList<QuestionBankType>();
    		list.add(new QuestionBankType(questionBank, "新课标I"));
    		list.add(new QuestionBankType(questionBank, "新课标II"));
    		list.add(new QuestionBankType(questionBank, "北京卷"));
    		list.add(new QuestionBankType(questionBank, "天津卷"));
    		list.add(new QuestionBankType(questionBank, "上海卷"));
    		list.add(new QuestionBankType(questionBank, "广东卷"));
    		list.add(new QuestionBankType(questionBank, "山东卷"));
    		list.add(new QuestionBankType(questionBank, "江苏卷"));
    		list.add(new QuestionBankType(questionBank, "安徽卷"));
    		list.add(new QuestionBankType(questionBank, "浙江卷"));
    		list.add(new QuestionBankType(questionBank, "福建卷"));
    		list.add(new QuestionBankType(questionBank, "湖南卷"));
    		list.add(new QuestionBankType(questionBank, "湖北卷"));
    		list.add(new QuestionBankType(questionBank, "陕西卷"));
    		list.add(new QuestionBankType(questionBank, "重庆卷"));
    		list.add(new QuestionBankType(questionBank, "海南卷"));
    		
    		Gson g = new Gson();
    		String str  = g.toJson(list);
    		RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/questionBankType/addQuestionBankTypeBatch").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateQuestionBankType() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankType/updateQuestionBankType").param("id", "3")
    				.param("name", "山西卷");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testDeleteQuestionBankType() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankType/deleteQuestionBankTypeById")
    				.param("id", "3");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankTypeById() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankType/getQuestionBankTypeById").param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetQuestionBankTypeByQuestionBank() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/questionBankType/getQuestionBankTypeByQuestionBank").param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
