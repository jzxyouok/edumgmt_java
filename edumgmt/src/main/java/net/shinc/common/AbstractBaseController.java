package net.shinc.common;

import java.util.HashMap;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.AdminUser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

public abstract class AbstractBaseController implements ApplicationContextAware {
	
	protected ApplicationContext applicationContext;
	
	@Autowired
	protected MessageSource messageSource;
	
	protected IRestMessage restMessage;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public IRestMessage getRestMessage() {
		IRestMessage msg = (IRestMessage)applicationContext.getBean("restMessage");
		AdminUser currentUser = AdminUser.getCurrentUser();
		if(null != currentUser){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", currentUser.getUsername());
			map.put("menuMap", currentUser.getMenuMap());
			msg.setUserInfo(map);
		}
		return msg;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
