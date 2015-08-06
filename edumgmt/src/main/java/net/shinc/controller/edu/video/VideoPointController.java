package net.shinc.controller.edu.video;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.VideoPoint;
import net.shinc.service.edu.video.VideoPointService;

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
 * @ClassName: VideoPointController
 * @Description: 知识点视频具体信息控制层
 * @author hushichong
 * @date 2015年8月4日 下午4:08:02
 */
@Controller
@RequestMapping(value = "/videoPoint")
public class VideoPointController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private VideoPointService videoPointService;

	/**
	 * @Title: getVideoPointAndRelevantInfoList
	 * @Description: 知识点视频视频列表
	 * @param videoPoint
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getVideoPointAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoPointAndRelevantInfoList(@RequestBody VideoPoint videoPoint) {
		IRestMessage msg = getRestMessage();
		try {
			List<VideoPoint> list = videoPointService.getVideoPointAndRelevantInfoList(videoPoint);
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

	/**
	 * @Title: addVideoPointAndRelevantInfo
	 * @Description: 添加知识点视频视频详细信息
	 * @param videoPoint
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addVideoPointAndRelevantInfo")
	@ResponseBody
	public IRestMessage addVideoPointAndRelevantInfo(@RequestBody @Valid VideoPoint videoPoint, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = videoPointService.insertVideoPoint(videoPoint);
			if (num > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("添加知识点视频视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	/**
	 * @Title: getVideoPointAndRelevantInfo
	 * @Description: 获得知识点视频视频详细信息
	 * @param videoPoint
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getVideoPointAndRelevantInfo")
	@ResponseBody
	public IRestMessage getVideoPointAndRelevantInfo(VideoPoint videoPoint) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			
			List<VideoPoint> list = videoPointService.getVideoPointAndRelevantInfoList(videoPoint);
			if (list != null && list.size() > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(list.get(0));
			} else {
				iRestMessage.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("获得知识点视频视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * @Title: getVideoPointAndRelevantInfo
	 * @Description: 更新知识点视频视频
	 * @param videoPoint
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateVideoPointAndRelevantInfo")
	@ResponseBody
	public IRestMessage updateVideoPointAndRelevantInfo(@RequestBody @Valid VideoPoint videoPoint, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoPointService.updateVideoPoint(videoPoint);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
		} catch (Exception e) {
			logger.error("更新知识点视频视频失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
}
