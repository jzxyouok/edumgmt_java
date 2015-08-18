package net.shinc.controller.common;

import java.util.HashMap;
import java.util.Map;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.common.AdminUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogoutController extends AbstractBaseController {
	@Autowired
	private MessageSource messageSource;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping(value = "/login")
	public IRestMessage login() {
		IRestMessage msg = getRestMessage();
		msg.setCode(ErrorMessage.NEED_LOGIN.getCode());
		logger.info("need login");
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/loginSuccess")
	public IRestMessage loginSuccess() {
		IRestMessage msg = getRestMessage();
		AdminUser currentUser = AdminUser.getCurrentUser();
		if(null != currentUser){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", currentUser.getUsername());
			map.put("menuMap", currentUser.getMenuMap());
			msg.setUserInfo(map);
			msg.setCode(ErrorMessage.SUCCESS.getCode());
			logger.info("loginSuccess:" + AdminUser.getCurrentUser());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/loginFail")
	public IRestMessage failSuccess() {
		IRestMessage msg = getRestMessage();
		msg.setCode(ErrorMessage.LOGIN_FAILED.getCode());
		logger.warn("loginFail");
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/logoutSuccess")
	public IRestMessage logoutSuccess() {
		IRestMessage msg = getRestMessage();
		msg.setCode(ErrorMessage.SUCCESS.getCode());
		logger.warn("logoutSuccess");
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/isLogin")
	public IRestMessage isLogin() {
		IRestMessage msg = getRestMessage();
		msg.setCode(ErrorMessage.SUCCESS.getCode());
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/testLogin")
	public Map testLogin() {
		Map map = new HashMap();
		map.put("code", "SUCCESS");
		return map;
	}
	

}
