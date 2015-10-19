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
import org.springframework.transaction.annotation.Transactional;
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
public class KnowledgePointControllerTest {

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
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testAddKnowledgePoint() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/addKnowledgePoint").param("name", "三角形特性").param("course.id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testDeleteKnowledgePoint() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/deleteKnowledgePoint").param("id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testGetKnowledgePointListByCourse() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/getKnowledgePointListByCourse").param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testGetKnowledgePointListByName() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/getKnowledgePointListByName").param("id", "1").param("name", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testGetKnowledgePointListByVideoBase() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/getKnowledgePointListByVideoBase").param("id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void getKnowledgePointListByParentId(){
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/knowledgePoint/getKnowledgePointTreeList")
    			;
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
