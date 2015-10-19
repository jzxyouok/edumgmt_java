package net.shinc.controller.common;

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
 * @ClassName: ControllerTest
 * @Description: 公共测试类
 * @author hushichong
 * @date 2015年9月17日 下午12:33:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class ControllerTest {

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
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testGetRecommendList() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/recommend/getRecommendList").param("page", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void getRecommendInfo() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.get("/recommend/getRecommendInfo").param("id", "1");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testAddRecommend() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/recommend/addRecommend").param("recommendName", "大宇宙信息创造（中国）有限公司").param("address", "天津市西青区").param("name", "胡汉三")
				.param("tel", "12345678913").param("enabled", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testUpdateRecommend() {
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/recommend/updateRecommend").param("id", "3").param("recommendName", "大宇宙信息创造（中国）有限公司").param("address", "天津市西青区")
				.param("name", "张天才").param("tel", "12345678913").param("enabled", "1");
		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testDeleteRecommend() {
		try {
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/recommend/deleteRecommend").param("id", "2");
			mockMvc.perform(reqbuild).andDo(handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
