package net.shinc.service.common;

import java.util.ArrayList;
import java.util.List;

import net.shinc.InfoMgmtApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class QNServiceTest {

	@Autowired
	private QNService qnService;
	
	@Test
	public void testGetFilesByBucket() {
		qnService.getFiles("steven", null, 100, null);
	}
	
	@Test
	public void testdeleteFile() {
		qnService.deleteFile("steven", "a_test.mp4");
	}
	
	@Test
	public void testDeleteFilesBatch() {
		List<String> keyList = new ArrayList<String>();
		keyList.add("o_19t7mpdbm421109goqo1vqb1hiqb.mp4");
		keyList.add("o_19t7mph3tjk1uq8lupavldu6d.jpg");
		qnService.deleteFileBatch("steven", keyList);
	}
	
	@Test
	public void testGetDownloadUrl() {
		long expires = 3600l;
		String baseUrl = "http://7xkw22.com1.z0.glb.clouddn.com/o_19tna2i94k6l1clvlhetbt1qvmb.mp4?avinfo";
		String baseUrl5 = "http://7xkw22.com1.z0.glb.clouddn.com/o_19tna2i94k6l1clvlhetbt1qvmb.mp4";
		String baseUrl2 = "http://7xkw28.com1.z0.glb.clouddn.com/o_19t7sirf67addv1c1ajeli3qb.jpg";
		String baseUrl3 = "http://7xkw28.com1.z0.glb.clouddn.com/qr_7499a8de7efd7ea805ba734af62d4851.png";
		String baseUrl4 = "http://7xkw22.com1.z0.glb.clouddn.com/5783ee8f19d77d2b3f2ec1b123251af9.png?download/5783ee8f19d77d2b3f2ec1b123251af9.png";
		String str = qnService.getDownloadUrl(baseUrl5, expires);
		System.out.println(str);
	}
}
