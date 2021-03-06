package net.shinc.controller.edu.video;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.formbean.edu.video.VideoSelfQueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoSelf;
import net.shinc.service.edu.video.VideoBaseService;
import net.shinc.service.edu.video.VideoSelfService;

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
	
	@Autowired
	private VideoBaseService videoBaseService;

	@Value("${page.count}")
	private String limit;
	
	/**
	* @Title: getVideoSelfAndRelevantInfoList
	* @Description: 得到视频相关信息列表
	* @param videoSelfQueryBean
	* @param page
	* @param pageSize
	* @return  IRestMessage
	 */
	@RequestMapping(value = "/getVideoSelfAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoSelfAndRelevantInfoList(VideoSelfQueryBean videoSelfQueryBean,
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
			List<Map> list = videoSelfService.getVideoSelfAndRelevantInfoList(videoSelfQueryBean,pageBounds);
			if (null != list && list.size() > 0 && list.get(0) != null) {
				Map sfd = list.get(0);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
				msg.setPageInfo(((PageList)list).getPaginator());// 返回分页信息
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
	* @Description: 新增视频相关信息
	* @param videoSelf
	* @param bindingResult
	* @param locale
	* @return  IRestMessage
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
			videoSelfService.insertVideoSelf(videoSelf);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			Integer vbid = videoSelf.getVideoBaseId();
			
			videoBaseService.generateQRCodeAndUpload(vbid);
			iRestMessage.setResult(vbid);	
		} catch (Exception e) {
			iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
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
	public IRestMessage getVideoSelfAndRelevantInfo(VideoSelfQueryBean videoSelfQueryBean) {
		IRestMessage iRestMessage = getRestMessage();
		try {

			List<Map> list = videoSelfService.getVideoSelfAndRelevantInfoList(videoSelfQueryBean,new PageBounds());
			if (list != null && list.size() > 0 && list.get(0) != null) {
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

	@RequestMapping(value = "/updateVideoSelfAndRelevantInfo")
	@ResponseBody
	public IRestMessage updateVideoSelfAndRelevantInfo(@Valid VideoSelf videoSelf, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoSelfService.updateVideoSelf(videoSelf);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(videoSelf.getVideoBase().getId());
		} catch (Exception e) {
			logger.error("更新自编题视频失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
}
