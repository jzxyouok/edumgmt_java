package net.shinc.service.edu.video;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.edu.VideoBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName VideoBaseServiceTest 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年8月31日 上午11:01:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class VideoBaseServiceTest {
	
	@Autowired
	private VideoBaseService vbService;
	
	@Test
	@Transactional
	public void testUpdateQrCodeByVideoBaseById() {
		VideoBase videoBase = new VideoBase();
		videoBase.setId(271);
		videoBase.setQrcode("http://7xlbf0.com1.z0.glb.clouddn.com/qr_210fbd984d56a3be4c81f1adbf8825c3.png");
		Integer num = vbService.updateQrCodeByVideoBaseById(videoBase);
		System.out.println("update num ==>" + num);
	}

}
