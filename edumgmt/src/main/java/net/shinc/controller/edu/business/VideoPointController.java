package net.shinc.controller.edu.business;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.formbean.edu.video.VideoPointQueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoPoint;
import net.shinc.service.edu.video.VideoBaseService;
import net.shinc.service.edu.video.VideoPointService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

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
	
	@Autowired
	private VideoBaseService videoBaseService;
	
	@Value("${page.count}")
	private String limit;

	/**
	* @Title: getVideoPointAndRelevantInfoList
	* @Description: 得到视频相关信息列表
	* @param videoPointQueryBean
	* @param page
	* @param pageSize
	* @return  IRestMessage
	 */
	@RequestMapping(value = "/getVideoPointAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoPointAndRelevantInfoList(VideoPointQueryBean videoPointQueryBean,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize) {
		IRestMessage msg = getRestMessage();
		if(page == null || page < 1) {
			page = 1;
		}
		if(pageSize == null || pageSize < 1) {
			pageSize = Integer.parseInt(limit);
		}
		PageBounds pageBounds = new PageBounds(page,pageSize);
		try {
			List<Map> list = videoPointService.getVideoPointAndRelevantInfoList(videoPointQueryBean,pageBounds);
			if (null != list && list.size() > 0 && list.get(0) != null) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
				msg.setPageInfo(((PageList)list).getPaginator());
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
	* @Description: 新增视频相关信息
	* @param videoPoint
	* @param bindingResult
	* @param locale
	* @return  IRestMessage
	 */
	@RequestMapping(value = "/addVideoPointAndRelevantInfo")
	@ResponseBody
	public IRestMessage addVideoPointAndRelevantInfo(@Valid VideoPoint videoPoint, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoPointService.insertVideoPoint(videoPoint);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			
			Integer vbid = videoPoint.getVideoBaseId();
			videoBaseService.generateQRCodeAndUpload(vbid);
			iRestMessage.setResult(vbid);
		} catch (Exception e) {
			logger.error("添加知识点视频视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
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
	public IRestMessage getVideoPointAndRelevantInfo(VideoPointQueryBean videoPointQueryBean) {
		IRestMessage iRestMessage = getRestMessage();
		try {

			List<Map> list = videoPointService.getVideoPointAndRelevantInfoList(videoPointQueryBean, new PageBounds());
			if (list != null && list.size() > 0 && list.get(0) != null) {
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
	 * @Description: 更新知识点视频视频 入参：{ "id": 4, "videoBaseId": 20, "videoBase": {
	 *               "id": 20, "adminUserId": 2, "courseId": 2, "lectureId": 2,
	 *               "questionId": "12313354", "title": "title", "desc": "desc",
	 *               "profile": "profile", "difficulty": "1", "questionNumber":
	 *               "66", "keywordList": [{ "id": 3 }, { "id": 4 }],
	 *               "videoDetailList": [{ "type": "1", "url": "urla" }, {
	 *               "type": "2", "url": "urlb" }] } }
	 * @param videoPoint
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateVideoPointAndRelevantInfo")
	@ResponseBody
	public IRestMessage updateVideoPointAndRelevantInfo(@Valid VideoPoint videoPoint, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoPointService.updateVideoPoint(videoPoint);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(videoPoint.getVideoBase().getId());
		} catch (Exception e) {
			logger.error("更新知识点视频视频失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
}
