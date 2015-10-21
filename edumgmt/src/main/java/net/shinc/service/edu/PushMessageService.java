package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.PushMessage;


/**
 * 
 * 推送消息服务接口
 * @author zhangtaichao 2015年10月21日
 *
 */
public interface PushMessageService {

	public List<PushMessage> getAllPushMessage();
	
	public int insertPushMessage(String title,String content,String type);
	
	public int deletePushMessage(Integer id);
}
