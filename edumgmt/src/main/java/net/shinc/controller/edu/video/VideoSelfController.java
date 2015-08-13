package net.shinc.controller.edu.video;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.VideoSelf;
import net.shinc.service.edu.video.VideoSelfService;

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
 * @ClassName: VideoSelfController
 * @Description: 自编题具体信息控制层
 * @author hushichong
 * @date 2015年8月4日 下午4:08:02
 */
@Controller
@RequestMapping(value = "/videoSelf")
public class VideoSelfController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private VideoSelfService videoSelfService;

	/**
	 * @Title: getVideoSelfAndRelevantInfoList
	 * @Description: 自编题视频列表 列表内容：{ "code": "SUCCESS", "message": "交易成功",
	 *               "detail": null, "result": [{ "id": 3 "videoBase": {
	 *               "questionId=id字符串": "12313354", "title": "title", "desc": "desc",
	 *               "difficulty=难度系数": "1", "questionNumber": "66" "course": { "id":
	 *               2, "name": "数学", "shortName": "数" }, "lecture=讲解人": { "id": 2,
	 *               "name": "张天才", "level": "100" }, "keywordList=关键字列表": [{ "id": 3,
	 *               "name": "化学" }, { "id": 4, "name": "英语" }],
	 *               "knowledgetPointList": [], "videoDetailList": [{ "url":
	 *               "urla" }, { "url": "urlb" }] }, "questionType=题型": { "id": 1,
	 *               "name": "单选题" }, "hasVideo": null }], "userInfo": null }
	 * @param videoSelf
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getVideoSelfAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoSelfAndRelevantInfoList(@RequestBody VideoSelf videoSelf) {
		IRestMessage msg = getRestMessage();
		try {
			List<VideoSelf> list = videoSelfService.getVideoSelfAndRelevantInfoList(videoSelf);
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
	 * @Title: addVideoSelfAndRelevantInfo
	 * @Description: 添加自编题视频详细信息 入参：{ "type": "0", "questionTypeId=题型id": 1,
	 *               "videoBase": { "adminUserId=管理员id": 2, "courseId=课程id": 2,
	 *               "lectureId=讲解人id": 2, "questionId": "12313354", "title":
	 *               "title", "desc": "desc", "profile": "profile",
	 *               "difficulty=难度系数": "1", "questionNumber": "66", "course": {
	 *               "id": 1 }, "keywordList": [{ "id": 3 }, { "id": 4 }]} }
	 * @param videoSelf
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addVideoSelfAndRelevantInfo")
	@ResponseBody
	public IRestMessage addVideoSelfAndRelevantInfo(@Valid VideoSelf videoSelf, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = videoSelfService.insertVideoSelf(videoSelf);
			if (num > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("添加自编题视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	/**
	 * @Title: getVideoSelfAndRelevantInfo
	 * @Description: 获得自编题视频详细信息
	 * @param videoSelf
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getVideoSelfAndRelevantInfo")
	@ResponseBody
	public IRestMessage getVideoSelfAndRelevantInfo(VideoSelf videoSelf) {
		IRestMessage iRestMessage = getRestMessage();
		try {

			List<VideoSelf> list = videoSelfService.getVideoSelfAndRelevantInfoList(videoSelf);
			if (list != null && list.size() > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(list.get(0));
			} else {
				iRestMessage.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("获得自编题视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	/**
	 * @Title: getVideoSelfAndRelevantInfo
	 * @Description: 更新自编题视频 入参： { "id": 3, "questionTypeId": 1, "videoBase": {
	 *               "id": 22, "adminUserId": 2, "courseId": 2, "lectureId": 2,
	 *               "questionId": "12313354", "title": "title", "desc": "desc",
	 *               "profile": "profile", "difficulty": "1", "questionNumber":
	 *               "66", "course": { "id": 1 }, "keywordList": [{ "id": 3 }, {
	 *               "id": 4 }] } }
	 * @param videoSelf
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateVideoSelfAndRelevantInfo")
	@ResponseBody
	public IRestMessage updateVideoSelfAndRelevantInfo(@RequestBody @Valid VideoSelf videoSelf, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoSelfService.updateVideoSelf(videoSelf);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
		} catch (Exception e) {
			logger.error("更新自编题视频失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
}
