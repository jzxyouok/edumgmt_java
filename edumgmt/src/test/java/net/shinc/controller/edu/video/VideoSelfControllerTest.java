package net.shinc.controller.edu.video;

import java.util.ArrayList;
import java.util.List;

import net.shinc.EdumgmtApplication;
import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.Keyword;
import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.bean.edu.VideoSelf;

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
  * @ClassName: VideoSelfControllerTest
  * @Description: 自编题 controller 测试类
  * @author hushichong
  * @date 2015年8月5日 上午11:00:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class VideoSelfControllerTest {

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
	public void getVideoSelfAndRelevantInfoList() {
		List list = new ArrayList();
		VideoSelf videoSelf = new VideoSelf();
//		Keyword keyword = new Keyword();
//		VideoBase videoBase = new VideoBase();
//		keyword.setName("关键字1");
//		list.add(keyword);
//		keyword = new Keyword();
//		keyword.setName("222");
//		list.add(keyword);
//		videoBase.setKeywordList(list);
//		videoSelf.setVideoBase(videoBase);
//		videoSelf.setVideoBaseId(2);
		String str = new Gson().toJson(videoSelf);
		System.out.println(str);
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoSelf/getVideoSelfAndRelevantInfoList").header("Content-Type", MediaType.APPLICATION_JSON.toString())
				.content(str);// 设置请求体

		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
    @WithMockUser(username="admin",password="admin",authorities={"adminUserList"})
    public void getVideoSelfAndRelevantInfo(){
    	RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoSelf/getVideoSelfAndRelevantInfo")
    			.param("id", "1")
    			;
    	try {
    		mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void addVideoSelfAndRelevantInfo() {
		try {
			VideoSelf videoSelf = new VideoSelf();
			VideoBase videoBase = new VideoBase();
			
			// 视频详情
			List list = new ArrayList();
			VideoDetail VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urla");
			VideoDetail.setType("1");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urlb");
			VideoDetail.setType("2");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			
			// 知识点
			list = new ArrayList();
			KnowledgePoint knowledgePoint = new KnowledgePoint();
			knowledgePoint.setId(1);
			list.add(knowledgePoint);
			knowledgePoint.setId(3);
			list.add(knowledgePoint);
			videoBase.setKeywordList(list);
			
			// 关键字
			list = new ArrayList();
			Keyword keyword = new Keyword();
			keyword.setId(3);
			list.add(keyword);
			keyword = new Keyword();
			keyword.setId(4);
			list.add(keyword);
			videoBase.setKeywordList(list);

			Course course = new Course();
			course.setId(1);
			videoBase.setCourse(course);

			videoBase.setAdminUserId(2);
			videoBase.setDifficulty("1");
			videoBase.setCourseId(2);
			videoBase.setLectureId(2);
			videoBase.setTitle("title");
			videoBase.setDesc("desc");
			videoBase.setProfile("profile");
			videoBase.setQuestionId("12313354");
			videoBase.setQuestionNumber("66");

			videoSelf.setVideoBase(videoBase);
			videoSelf.setQuestionTypeId(1);
			videoSelf.setType("0");

			Gson g = new Gson();
			String str = g.toJson(videoSelf);
			System.out.println("入参----------------"+str);
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoSelf/addVideoSelfAndRelevantInfo").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);// 设置请求体
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void updateVideoSelfAndRelevantInfo() {
		try {
			VideoSelf videoSelf = new VideoSelf();
			VideoBase videoBase = new VideoBase();

			videoSelf.setId(3);
			videoBase.setId(22);
			
			// 视频详情
			List list = new ArrayList();
			VideoDetail VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urla");
			VideoDetail.setType("1");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urlb");
			VideoDetail.setType("2");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			
			// 知识点
			list = new ArrayList();
			KnowledgePoint knowledgePoint = new KnowledgePoint();
			knowledgePoint.setId(1);
			list.add(knowledgePoint);
			knowledgePoint.setId(3);
			list.add(knowledgePoint);
			videoBase.setKeywordList(list);
			
			// 关键字
			list = new ArrayList();
			Keyword keyword = new Keyword();
			keyword.setId(3);
			list.add(keyword);
			keyword = new Keyword();
			keyword.setId(4);
			list.add(keyword);
			videoBase.setKeywordList(list);

			Course course = new Course();
			course.setId(1);
			videoBase.setCourse(course);

			videoBase.setAdminUserId(2);
			videoBase.setDifficulty("1");
			videoBase.setCourseId(2);
			videoBase.setLectureId(2);
			videoBase.setTitle("title");
			videoBase.setDesc("desc");
			videoBase.setProfile("profile");
			videoBase.setQuestionId("12313354");
			videoBase.setQuestionNumber("66");

			videoSelf.setVideoBase(videoBase);
			videoSelf.setQuestionTypeId(1);

			Gson g = new Gson();
			String str = g.toJson(videoSelf);
			System.out.println("入参----------------"+str);
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoSelf/updateVideoSelfAndRelevantInfo").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);// 设置请求体
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
