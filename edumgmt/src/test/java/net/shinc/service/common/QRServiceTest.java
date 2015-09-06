package net.shinc.service.common;

import net.shinc.InfoMgmtApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName QRServiceTest 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年9月6日 下午5:10:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class QRServiceTest {

	@Autowired
	private QRService qrService;
	
	@Test
	public void testGenerateQrCode() {
		String filePath = "/Users/guoshijie/work/files/qr_imgs";
		String phpPath = "http://192.168.1.226:8009/index?id=";
		Integer videoBaseId = 258;
		qrService.generateQrCode(filePath, phpPath, videoBaseId);
	}
	
}
