package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.PushMessage;
import net.shinc.service.edu.CourseService;
import net.shinc.service.edu.PushMessageService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/pushmessage")
@Controller
public class PushMessageController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PushMessageService pushMessageService;
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public IRestMessage getAll() {
		IRestMessage msg = getRestMessage();
		try {
			List<PushMessage> list = pushMessageService.getAllPushMessage();
			msg.setCode(ErrorMessage.SUCCESS.getCode());
			msg.setResult(list);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 添加一条需要推送的信息
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public IRestMessage add(@Valid PushMessage pm) {
		IRestMessage msg = getRestMessage();
		try {
			int result = pushMessageService.insertPushMessage(pm.getTitle(),pm.getContent(),pm.getType());
			msg.setCode(ErrorMessage.SUCCESS.getCode());
			msg.setResult(result);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	/**
	 * 删除推送的信息
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public IRestMessage delete(@RequestParam("id") Integer id) {
		IRestMessage msg = getRestMessage();
		try {
			int result = pushMessageService.deletePushMessage(id);
			msg.setCode(ErrorMessage.SUCCESS.getCode());
			msg.setResult(result);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
}
