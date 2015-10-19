package net.shinc.service.edu.video;

import java.util.ArrayList;
import java.util.List;

import net.shinc.EdumgmtApplication;
import net.shinc.orm.mybatis.bean.edu.VideoPic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @ClassName VideoPicControllerTest 
 * @Description 视频截图测试
 * @author wangzhiying 
 * @date 2015年8月4日 下午7:46:54  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class VideoPicServiceTest {
	@Autowired
	private VideoPicService videoPicService;
	
	@Test
	@Transactional
	public void testInsertPic(){
		VideoPic record = new VideoPic();
		record.setId(100);
		record.setVideoBaseId(1);
		record.setTitle("哈哈");
		videoPicService.insertPic(record);
	}
	
	@Test
	@Transactional
	public void testInsertPicBatch(){
		List<VideoPic> list = new ArrayList<VideoPic>();
		list.add(new VideoPic(null,3,"a","b","c","d"));
		list.add(new VideoPic(null,3,"a","b","c","d"));
		list.add(new VideoPic(null,3,"a","b","c","d"));
		videoPicService.insertPicBatch(list);
	}
	
	@Test
	@Transactional
	public void testDeletePicById(){
		videoPicService.deletePicById(2);
	}
	
	@Test
	@Transactional
	public void testDeletePicBatch(){
		List<VideoPic> list = new ArrayList<VideoPic>();
		list.add(new VideoPic(5));
		list.add(new VideoPic(6));
		list.add(new VideoPic(7));
		videoPicService.deletePicBatch(list);
	}
	
	@Test
	@Transactional
	public void testSelectPicById(){
		VideoPic pic = videoPicService.selectPicById(2);
		System.out.println(pic);
	}
	
	@Test
	@Transactional
	public void teatSelectPicByVideoBaseId(){
		List<VideoPic> list = videoPicService.selectPicByVideoBaseId(2,"",3600l);
		for (VideoPic videoPic : list) {
			System.out.println(videoPic);
		}
	}

}
