package net.shinc.controller.edu.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.bean.edu.VideoPic;
import net.shinc.service.common.QNService;
import net.shinc.service.edu.video.VideoDetailService;
import net.shinc.service.edu.video.VideoPicService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.StringMap;


/**
 * 
 * 所有视频，图片、视频基本信息维护
 * @author zhangtaichao 2015年8月17日
 *
 */
@Controller
@RequestMapping(value = "/videoDetail")
public class VideoDetailController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VideoDetailService vs;
	
	@Autowired
	private VideoPicService vps;
	
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
	
	@Value("${qiniu.eduonline.deadline}")
	private String expires;

	/**
	 * 七牛上传成功后，更新视频信息
	 * @param videoBaseId
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/addVideoDetail")
	@ResponseBody
	public IRestMessage addVideoDetail(@RequestParam("videoBaseId") String videoBaseId, @RequestParam("name") String name, @RequestParam("sourceLink") String url) {
		IRestMessage iRestMessage = getRestMessage();
		if(StringUtils.isEmpty(videoBaseId) || StringUtils.isEmpty(name)) {
			iRestMessage.setCode(ErrorMessage.ERROR_PARAM_ERROR.getCode());
		} else {
			try {
				VideoDetail vd = new VideoDetail();
				vd.setVideoBaseId(Integer.parseInt(videoBaseId));
				vd.setStoreInfo(name);
				vd.setUrl(url);
				vd.setStoreType("1");
				
				String type;
				int index = name.lastIndexOf(".");
				if(index != -1) {
					type = name.substring(index + 1);
				} else {
					type = "unknown";
				}
				vd.setType(type);
				
				VideoDetail current = vs.getByVideoDetailById(vd);
				if(current != null) {
					vs.deleteVideoDetailById(vd);
					qnservice.deleteFile(bucketName, current.getStoreInfo());
				}
				vs.insertVideoDetail(vd);
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			} catch(Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		return iRestMessage;
	}
	
	/**
	 * 七牛上传成功后，更新截图信息
	 * @param videoBaseId
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/addVideoPic")
	@ResponseBody
	public IRestMessage addVideoPic(@RequestParam("videoBaseId") String videoBaseId, @RequestParam("name") String name) {
		IRestMessage iRestMessage = getRestMessage();
		if(StringUtils.isEmpty(videoBaseId) || StringUtils.isEmpty(name)) {
			iRestMessage.setCode(ErrorMessage.ERROR_PARAM_ERROR.getCode());
		} else {
			try {
				VideoPic vp = new VideoPic();
				
				vp.setStoreInfo(name);
				vp.setVideoBaseId(Integer.parseInt(videoBaseId));
				vp.setStoreType("1");
				
				int index = name.lastIndexOf(".");
				String title;
				if(index != -1) {
					title = name.substring(0, index);
				} else {
					title = "unknown";
				}
				vp.setTitle(title);
				
				List<VideoPic> selectPicByVideoBaseId = vps.selectPicByVideoBaseId(Integer.parseInt(videoBaseId), domain, Long.parseLong(expires));
				if(null != selectPicByVideoBaseId && selectPicByVideoBaseId.size() > 0) {
					vps.deletePicBatch(selectPicByVideoBaseId);
					qnservice.deleteFileBatch(bucketName, vps.dealVideoPicStoreInfo(selectPicByVideoBaseId));
				}
				
				vps.insertPic(vp);
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			} catch(Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
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
		List<VideoPic> pic = videoPicService.selectPicByVideoBaseId(vbid, domain, Long.parseLong(expires));
		
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
