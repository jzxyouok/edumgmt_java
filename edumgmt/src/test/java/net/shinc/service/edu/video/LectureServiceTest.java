package net.shinc.service.edu.video;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.edu.Lecture;
import net.shinc.service.edu.LectureService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName LectureServiceTest 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年8月4日 下午9:38:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class LectureServiceTest {

	@Autowired
	private LectureService lectureService;
	
	@Test
	public void testGetVideoPastpaperNumByLecture(){
		Integer i = lectureService.getVideoPastpaperNumByLecture(new Lecture(1));
		System.out.println("===>" + i);
	}
	
	@Test
	public void testGetVideoSelfNumByLecture(){
		Integer i = lectureService.getVideoSelfNumByLecture(new Lecture(1));
		System.out.println("===>" + i);
	}
	
	@Test
	public void testGetVideoPointNumByLecture(){
		Integer i = lectureService.getVideoSelfNumByLecture(new Lecture(1));
		System.out.println("===>" + i);
	}
	
}
