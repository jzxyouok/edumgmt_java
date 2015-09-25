package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.User;
import net.shinc.service.edu.UserService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description 用户控制层
 * @author guoshijie
 * @date 2015年8月3日 下午5:00:43
 */
@RequestMapping(value = "/user")
@Controller
public class UserController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public IRestMessage getUserList() {
		IRestMessage msg = getRestMessage();
		try {
			List<User> list = userService.findAll(new User());
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("用户列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

	@RequestMapping(value = "/getUserById")
	@ResponseBody
	public IRestMessage getUserById(User user) {
		IRestMessage msg = getRestMessage();
		try {
			if (null != user) {
				User cos = userService.getById(user.getId());
				if (null != cos) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(cos);
				} else {
					msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("用户查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

	@RequestMapping(value = "/addUser")
	@ResponseBody
	public IRestMessage addUser(@Valid User user, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			int i = userService.insert(user);
			if (i > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("用户添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/deleteUser")
	@ResponseBody
	public IRestMessage deleteUser(User user) {
		IRestMessage msg = getRestMessage();
		try {
			if (null != user) {
				int i = userService.deleteById(user.getId());
				if (i > 0) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(i);
				} else {
					msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("用户删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

	@RequestMapping(value = "/updateUser")
	@ResponseBody
	public IRestMessage updateUser(@Valid User user, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if (bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = userService.update(user);
			if (i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("用户更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

}
