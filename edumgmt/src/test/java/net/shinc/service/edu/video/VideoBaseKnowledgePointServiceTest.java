package net.shinc.service.edu.video;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 
 * @ClassName VideoBaseKnowledgePointServiceTest 
 * @Description TODO
 * @author guoshijie 
 * @date 2015年8月4日 下午4:44:17  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class VideoBaseKnowledgePointServiceTest {

	@Autowired
	private VideoBaseKnowledgePointService videoBaseKnowledgePointService;
	
	@Test
	public void testAddKnowledgePointForVideoBase(){
		VideoBaseKnowledgePointKey record = new VideoBaseKnowledgePointKey();
		record.setVideoBaseId(1);
		record.setKnowledgePointId(6);
		videoBaseKnowledgePointService.addKnowledgePointForVideoBase(record);
	}
	
	@Test
	@Transactional
	public void testdeleteKnowledgePointForVideoBase(){
		VideoBaseKnowledgePointKey record = new VideoBaseKnowledgePointKey();
		record.setVideoBaseId(1);
		record.setKnowledgePointId(6);
		videoBaseKnowledgePointService.deleteKnowledgePointForVideoBase(record);
	}
}
