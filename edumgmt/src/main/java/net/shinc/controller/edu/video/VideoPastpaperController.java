package net.shinc.controller.edu.video;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
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


@Controller
@RequestMapping(value = "/videoPastpaper")
public class VideoPastpaperController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VideoPastpaperService videoPastpaperService;
	
	
	@RequestMapping(value = "/getVideoPastpaperAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoPastpaperAndRelevantInfoList(@RequestBody @Valid VideoPastpaper videoPastpaper,BindingResult bindingResult,Locale locale) {
		IRestMessage msg = getRestMessage();
		try {
			List<VideoPastpaper> list = videoPastpaperService.getVideoPastpaperAndRelevantInfoList(videoPastpaper);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			}else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("真题模拟题及相关信息列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
}
