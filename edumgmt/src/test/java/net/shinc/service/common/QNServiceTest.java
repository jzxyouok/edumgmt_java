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
		String baseUrl = "http://7xkw28.com1.z0.glb.clouddn.com/o_19t7q67h5lk31q6556s4dr9hb.mp4";
		String baseUrl2 = "http://7xkw28.com1.z0.glb.clouddn.com/o_19t7sirf67addv1c1ajeli3qb.jpg";
		String str = qnService.getDownloadUrl(baseUrl2, expires);
		System.out.println(str);
	}
}
