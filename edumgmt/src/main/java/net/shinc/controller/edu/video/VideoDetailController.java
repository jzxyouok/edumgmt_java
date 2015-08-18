package net.shinc.controller.edu.video;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.bean.edu.VideoPic;
import net.shinc.service.edu.video.VideoDetailService;
import net.shinc.service.edu.video.VideoPicService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
				
				vps.insertPic(vp);
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			} catch(Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		return iRestMessage;
	}
}
