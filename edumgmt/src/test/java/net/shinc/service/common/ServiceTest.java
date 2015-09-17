package net.shinc.service.common;

import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.edu.Parter;
import net.shinc.orm.mybatis.bean.edu.Recommend;
import net.shinc.service.edu.business.ParterService;
import net.shinc.service.edu.course.CourseGradeService;
import net.shinc.service.edu.recommend.RecommendService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class ServiceTest {

	@Autowired
	private ParterService parterService;
	@Autowired
	private CourseGradeService courseGradeService;
	@Autowired
	private RecommendService recommendService;
	
	@Test
	public void add(){
		Recommend recommend = new Recommend();
		recommend.setTitle("111");
		recommend.setLocation("1");
		recommend.setDescription("q2343");
		recommend.setLogo("sadfsda");
		try {
			Integer adfas = recommendService.addRecommend(recommend);
			System.out.println("111111111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} 
	
	@Test
	public void findAll(){
		List list = recommendService.getRecommendList(null);
		Gson g = new Gson();
		System.out.println(g.toJson(list));
		
	}
	
	@Test
	public void findById(){
		Gson g = new Gson();
		System.out.println(g.toJson(recommendService.getRecommendById(1)));
		
	}
	
	@Test
	public void update(){
		Recommend recommend = new Recommend();
		recommend.setId(3);
		recommend.setTitle("22222");
		recommend.setLocation("1");
		recommend.setDescription("q2343");
		recommend.setLogo("sadfsda");
		Gson g = new Gson();
		System.out.println(g.toJson(recommendService.updateRecommend(recommend)));
		
	}
	
	@Test
	public void delete(){
		Gson g = new Gson();
		System.out.println(g.toJson(recommendService.deleteRecommendById(3)));
		
	}
	
}
