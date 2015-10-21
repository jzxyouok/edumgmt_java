package net.shinc.service.edu.impl;

import java.util.Date;
import java.util.List;

import net.shinc.common.AbstractBaseService;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.edu.PushMessage;
import net.shinc.orm.mybatis.mappers.edu.PushMessageMapper;
import net.shinc.service.edu.PushMessageService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PushMessageServiceImpl extends AbstractBaseService implements PushMessageService {

	@Autowired
	private PushMessageMapper pushMessageMapper;
	
	@Override
	public List<PushMessage> getAllPushMessage() {
		try {
			return pushMessageMapper.findAll(null);
		} catch(Exception e) {
			logger.error(getExceptionStackTrace(e));
			return null;
		}
		
	}

	@Override
	public int insertPushMessage(String title, String content, String type) {
		
		try {
			if(StringUtils.isEmpty(type)) {
				type="0";
			}
			PushMessage m = new PushMessage();
			m.setTitle(title);
			m.setContent(content);
			m.setType(type);
			m.setCreateTime(new Date());
			m.setUserId(AdminUser.getCurrentUser().getId());
			return pushMessageMapper.insert(m);
		} catch(Exception e) {
			logger.error(getExceptionStackTrace(e));
			return 0;
		}
	}

	@Override
	public int deletePushMessage(Integer id) {
		
		try {
			return pushMessageMapper.deleteById(id);
		} catch(Exception e) {
			logger.error(getExceptionStackTrace(e));
			return 0;
		}
	}

}
