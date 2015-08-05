package net.shinc.controller.edu.video;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.VideoPastpaper;
import net.shinc.service.edu.video.VideoPastpaperService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: VideoPastpaperController
 * @Description: 真题、模拟题具体信息控制层
 * @author hushichong
 * @date 2015年8月4日 下午4:08:02
 */
@Controller
@RequestMapping(value = "/videoPastpaper")
public class VideoPastpaperController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private VideoPastpaperService videoPastpaperService;

	@RequestMapping(value = "/getVideoPastpaperAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoPastpaperAndRelevantInfoList(@RequestBody VideoPastpaper videoPastpaper) {
		IRestMessage msg = getRestMessage();
		try {
			List<VideoPastpaper> list = videoPastpaperService.getVideoPastpaperAndRelevantInfoList(videoPastpaper);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("真题模拟题及相关信息列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/addVideoPastpaper")
	@ResponseBody
	public IRestMessage addVideoPastpaper(@RequestBody @Valid VideoPastpaper videoPastpaper, BindingResult bindingResult, Locale locale){
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = videoPastpaperService.insertVideoPastpaper(videoPastpaper);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("真题模拟题添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
}
