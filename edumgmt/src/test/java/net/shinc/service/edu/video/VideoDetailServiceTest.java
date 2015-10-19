package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.EdumgmtApplication;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class VideoDetailServiceTest {

	@Autowired
	private VideoDetailService videoDetailService;
	
	@Test
	@Transactional
	public void TestGetVideoDetailListByVideoBaseId(){
		List<VideoDetail> list = videoDetailService.getVideoDetailListByVideoBaseId(75);
		System.out.println(list);
	}
}
