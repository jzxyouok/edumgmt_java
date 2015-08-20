package net.shinc.controller.edu.video;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.formbean.edu.video.VideoPastpaperQueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.bean.edu.VideoPastpaper;
import net.shinc.orm.mybatis.bean.edu.VideoPic;
import net.shinc.service.common.QNService;
import net.shinc.service.edu.video.VideoDetailService;
import net.shinc.service.edu.video.VideoPastpaperService;
import net.shinc.service.edu.video.VideoPicService;

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
import com.qiniu.util.StringMap;

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
	
	@Value("${page.count}")
	private String limit;

	@Autowired
	private VideoPastpaperService videoPastpaperService;
	
	@Autowired
	private VideoDetailService videoDetailService;
	
	@Autowired
	private VideoPicService videoPicService;
	
	@Autowired
	private QNService qnservice;
	
	@Value("${qiniu.eduonline.domain}")
	private String domain;
	
	@Value("${qiniu.eduonline.bucketName}")
	private String bucketName;

	/**
	 * @Title: getVideoPastpaperAndRelevantInfoList
	 * @Description: 真题/模拟题视频列表 
	 * 列表信息：{ "code": "SUCCESS", "message": "交易成功",
	 *               "detail": null, "result": [{ "id": 10, "videoBase": {
	 *               "questionId=题目id字符串": "12313354", "title": "title", "desc":
	 *               "desc", "difficulty": "1", "questionNumber=题号": "66",
	 *               "course": { "id": 2, "name": "数学", "shortName": "数" },
	 *               "lecture=讲解人": { "id": 2, "name": "张天才", "level": "100" },
	 *               "keywordList": [{ "id": 3, "name": "化学" }, { "id": 4,
	 *               "name": "英语" }], "knowledgetPointList": [] },
	 *               "questionBankType": { "id": 165, "name": "河北卷" },
	 *               "questionBankYear": { "year": "2011" }, "questionType": {
	 *               "id": 1, "name": "单选题" }, "questionBank": { "id": 1,
	 *               "name": "中考真题", "type": "0" }, "hasVideo=是否有视频": null }] }
	 * @param videoPastpaper
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getVideoPastpaperAndRelevantInfoList")
	@ResponseBody
	public IRestMessage getVideoPastpaperAndRelevantInfoList(VideoPastpaperQueryBean videoPastpaper,
			@RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize) {
		IRestMessage msg = getRestMessage();
		try {
			
			if(page == null || page < 1) {
				page = 1;
			}
			if(pageSize == null || pageSize < 1) {
				pageSize = Integer.parseInt(limit);
			}
			PageBounds pb = new PageBounds(page,pageSize);
			List<Map> list = videoPastpaperService.getVideoPastpaperAndRelevantInfoList(videoPastpaper,pb);
			
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
	 * @Title: addVideoPastpaperAndRelevantInfo
	 * @Description: 添加真题/模拟题视频详细信息 入参: { "questionbankId=题库id": 1,
	 *               "questionbankYearId=年份id": 139, "questionTypeId=题型id": 1,
	 *               "questionbankTypeId=题库版本id": 165, "videoBase=基础信息": {
	 *               "adminUserId=添加人id": 2, "courseId=课程id": 2,
	 *               "lectureId=讲解人id": 2, "questionId=题目id字符串": "12313354",
	 *               "title=标题": "title", "desc=描述": "desc", "profile=简介":
	 *               "profile", "difficulty=难度系数": "1", "questionNumber=题号":
	 *               "66", "keywordList=插入关键字关系表": [ { "id=关键字id": 3 }, {
	 *               "id=关键字id": 4 } ], "knowledgetPointList=插入知识点关系表": [ {
	 *               "id=知识点id": 3 }, { "id=知识点id": 3 }
	 *               ],"videoDetailList=插入视频详情表": [ { "type=视频格式": "1",
	 *               "url=视频地址": "urla" }, { "type=视频格式": "2", "url=视频地址":
	 *               "urlb" } ] } }
	 * @param videoPastpaper
	 * @param bindingResult
	 * @param locale
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addVideoPastpaperAndRelevantInfo")
	@ResponseBody

	public IRestMessage addVideoPastpaperAndRelevantInfo( @Valid VideoPastpaper videoPastpaper, BindingResult bindingResult, Locale locale) {

		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setCode(ErrorMessage.ERROR_PARAM_ERROR.getCode());
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			videoPastpaperService.insertVideoPastpaper(videoPastpaper);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(videoPastpaper.getVideoBaseId());
			logger.info("videoBaseId:"+videoPastpaper.getVideoBaseId());
		} catch (Exception e) {
			logger.error("添加真题/模拟题视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
		}
		return iRestMessage;
	}


	@RequestMapping(value = "/getVideoPastpaperAndRelevantInfo")
	@ResponseBody
	public IRestMessage getVideoPastpaperAndRelevantInfo(VideoPastpaperQueryBean videoPastpaperQuery) {
		IRestMessage iRestMessage = getRestMessage();
		try {

			List<Map> list = videoPastpaperService.getVideoPastpaperAndRelevantInfoList(videoPastpaperQuery,new PageBounds());
			if (list != null && list.size() > 0 && list.get(0) != null) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(list.get(0));
			} else {
				iRestMessage.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("获得真题/模拟题视频详细信息失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/updateVideoPastpaperAndRelevantInfo")
	@ResponseBody
	public IRestMessage updateVideoPastpaperAndRelevantInfo(@Valid VideoPastpaper videoPastpaper, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}	
		try {
			videoPastpaperService.updateVideoPastpaper(videoPastpaper);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			
			//result放入视频和截图信息
			Map<String,Object> resultMap = new HashMap<String,Object>();
			Integer videoBaseId = videoPastpaper.getVideoBase().getId();
			List<VideoDetail> list = videoDetailService.getVideoDetailListByVideoBaseId(videoBaseId);
			List<VideoPic> pic = videoPicService.selectPicByVideoBaseId(videoBaseId);
			resultMap.put("video", list);
			resultMap.put("pic", pic);
			resultMap.put("videoBaseId", videoBaseId);
			iRestMessage.setResult(resultMap);
			
		} catch (Exception e) {
			logger.error("更新真题/模拟题视频失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 获取文件上传token,和已经有的视频及截图信息
	 * @return
	 */
	@RequestMapping(value = "/getVideoAndPicAndUploadToken")
	@ResponseBody
	public IRestMessage getVideoAndPicAndUploadToken(@RequestParam(value = "videoBaseId", required = true) String videoBaseId,
			@RequestParam(value = "originFileName", required = false) String originFileName) {
		IRestMessage msg = getRestMessage();
		long now = System.currentTimeMillis();
		StringMap policy = new StringMap();
		policy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"videoBaseId\":$(x:videoBaseId)}");
		String token = qnservice.getUploadToken(bucketName, null, 3600, policy, true);
		
		Integer vbid = Integer.parseInt(videoBaseId);
		List<VideoDetail> list = videoDetailService.getVideoDetailListByVideoBaseId(vbid);
		List<VideoPic> pic = videoPicService.selectPicByVideoBaseId(vbid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		msg.setCode(ErrorMessage.SUCCESS.getCode());
		map.put("domain", domain);
		map.put("upToken", token);
		map.put("videoBaseId", videoBaseId);
		map.put("videoList", list);
		map.put("picList", pic);
		msg.setResult(map);
		
		return msg;
	}
}
