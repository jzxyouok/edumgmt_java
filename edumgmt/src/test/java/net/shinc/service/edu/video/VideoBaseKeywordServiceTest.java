package net.shinc.service.edu.video;

import java.util.ArrayList;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @ClassName VideoBaseKeywordControllerTest 
 * @Description 视频关键字测试
 * @author wangzhiying 
 * @date 2015年8月4日 下午9:00:49  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class VideoBaseKeywordServiceTest {
	@Autowired
	private VideoBaseKeywordService videoBaseKeywordService;
	
	@Test
	@Transactional
	public void testDeleteVideoKeywordById(){
		VideoBaseKeywordKey key = new VideoBaseKeywordKey();
		key.setVideoBaseId(1);
		key.setKeywordId(2);
		videoBaseKeywordService.deleteVideoKeywordById(key);
	}
	
	@Test
	@Transactional
	public void testInsertVideoKeyword(){
		VideoBaseKeywordKey key = new VideoBaseKeywordKey();
		key.setVideoBaseId(3);
		key.setKeywordId(3);
		videoBaseKeywordService.insertVideoKeyword(key);
		System.out.println(key);
	}
	
	@Test
	@Transactional
	public void testInsertVideoKeywordBatch(){
		List<VideoBaseKeywordKey> list = new ArrayList<VideoBaseKeywordKey>();
		list.add(new VideoBaseKeywordKey(6,2));
		list.add(new VideoBaseKeywordKey(6,3));
		list.add(new VideoBaseKeywordKey(6,4));
		videoBaseKeywordService.insertVideoKeywordBatch(list);
		for (VideoBaseKeywordKey VideoBaseKeywordKey : list) {
			System.out.println(VideoBaseKeywordKey);
		}
	}

}
