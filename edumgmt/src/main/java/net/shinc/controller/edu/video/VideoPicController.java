package net.shinc.controller.edu.video;

import java.util.List;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.edu.VideoPic;
import net.shinc.service.common.QNService;
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

/**
 * @ClassName VideoPicController 
 * @Description 视频截图控制层
 * @author guoshijie 
 * @date 2015年8月24日 下午9:30:36
 */
@Controller
@RequestMapping(value = "/videoPic")
public class VideoPicController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VideoPicService vps;
	
	@Autowired
	private QNService qnservice;
	
	@Value("${qiniu.eduonline.bucketName}")
	private String bucketName;
	
	@Value("${qiniu.eduonline.domain}")
	private String domain;
	
	@Value("${qiniu.eduonline.deadline}")
	private String expires;
	
	/**
	 * 删除截图
	 * @param videoPic
	 * @return
	 */
	@RequestMapping(value = "/deleteVideoPic")
	@ResponseBody
	public IRestMessage deleteVideoPic(VideoPic videoPic) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != videoPic) {
				Integer num = vps.deletePicById(videoPic.getId());
				if(null != num && num > 0) {
					qnservice.deleteFile(bucketName, videoPic.getStoreInfo());
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(num);
				}
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return msg;
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
}
