package net.shinc.controller.common;

import java.util.ArrayList;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.Company;

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
 * @ClassName CompanyControllerTest 
 * @Description 企业控制层测试
 * @author guoshijie 
 * @date 2015年7月16日 下午5:52:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class AuthorityControllerTest {

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
	public void testAddAuthority() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authority/addAuthority")
					.param("authority", "videoManage").param("remark", "题目视频管理")
					.param("company.id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testUpdateAuthority() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authority/updateAuthority")
    				.param("authority", "videoManage").param("remark", "题目视频管理")
    				.param("company.id", "3").param("id", "31");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testDeleteAuthority() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authority/deleteAuthority")
    				.param("id", "1");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @Transactional
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testAddAuthorityBatch() {
    	try {
    		List<Authority> authList = new ArrayList<Authority>();
    		authList.add(new Authority(new Company(1), "videoManage", "题目视频管理"));
    		authList.add(new Authority(new Company(1), "simulateIssuesManage", "真题/模拟题库管理"));
    		authList.add(new Authority(new Company(1), "selfIssuesManage", "自编/改编题库管理"));
    		authList.add(new Authority(new Company(1), "simulateStructureManage", "真题/模拟题库结构"));
    		
    		authList.add(new Authority(new Company(1), "knowledgeManage", "知识点管理"));
    		authList.add(new Authority(new Company(1), "knowledgeVideoManage", "知识点视频管理"));
    		authList.add(new Authority(new Company(1), "knowledgeStructureManage", "知识点结构管理"));
    		
    		authList.add(new Authority(new Company(1), "infoManage", "信息管理"));
    		authList.add(new Authority(new Company(1), "knowledgeTagManage", "知识点标签管理"));
    		authList.add(new Authority(new Company(1), "lectureManage", "讲解人管理"));
    		
    		authList.add(new Authority(new Company(1), "adminUserManage", "教师管理"));
    		authList.add(new Authority(new Company(1), "adminUserList", "教师管理"));
    		
    		Gson g = new Gson();
    		String str  = g.toJson(authList);
    		RequestBuilder reqbuild =  MockMvcRequestBuilders.post("/authority/addAuthorityBatch").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void testGetAllAuthorityList() {
    	try {
    		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/authority/getAllAuthorityList");
    		mockMvc.perform(reqbuild).andDo(handler);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
