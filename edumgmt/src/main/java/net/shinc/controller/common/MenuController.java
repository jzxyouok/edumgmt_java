package net.shinc.controller.common;

import java.util.List;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Menu;
import net.shinc.service.common.MenuService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MenuController 
 * @Description 目录菜单控制层
 * @author guoshijie 
 * @date 2015年7月28日 下午8:57:31
 */
@Controller
public class MenuController extends AbstractBaseController {

	@Autowired
	private MenuService menuService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 获取当前登录用户的菜单
	 * @return
	 */
	@RequestMapping(value = "/getMenu")
	@ResponseBody
	public IRestMessage getMenu() {
		IRestMessage msg = getRestMessage();
		AdminUser currentUser = AdminUser.getCurrentUser();
		if(null != currentUser){
			try {
				List<Menu> menu = menuService.getMenu(currentUser);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(menu);
			} catch (Exception e) {
				logger.error("获取失败==>" + ExceptionUtils.getStackTrace(e));
			}
		} else {
			msg.setCode(ErrorMessage.NEED_LOGIN.getCode());
		}
		return msg;
	}
}
