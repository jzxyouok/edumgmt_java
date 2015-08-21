package net.shinc.controller.common;

import java.util.HashMap;
import java.util.Map;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.service.common.QNService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.StringMap;

/**
 * 七牛存储
 * @author zhangtaichao 2015年8月17日
 */
@Controller
@RequestMapping(value="/qiniu")
public class QiniuController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QNService qnservice;
	
	@Value("${qiniu.eduonline.domain}")
	private String domain;
	
	@Value("${qiniu.eduonline.bucketName}")
	private String bucketName;
	
	/**
	 * 获取文件上传token
	 * @return
	 */
	@RequestMapping(value = "/getUploadToken")
	@ResponseBody
	public IRestMessage getUploadToken(@RequestParam(value = "videoBaseId", required = true) String videoBaseId,
			@RequestParam(value = "originFileName", required = false) String originFileName) {
		IRestMessage msg = getRestMessage();
		long now = System.currentTimeMillis();
		StringMap policy = new StringMap();
		policy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"videoBaseId\":$(x:videoBaseId)}");
//		String key = videoBaseId + "_" + now + "_" + originFileName; 
//		String token = qnservice.getUploadToken(bucketName, key, 3600, null, true);
		String token = qnservice.getUploadToken(bucketName, null, 3600, policy, true);
		
		Map map = new HashMap();
		msg.setCode(ErrorMessage.SUCCESS.getCode());
		map.put("domain", domain);
		map.put("upToken", token);
		map.put("videoBaseId", videoBaseId);
		msg.setResult(map);
		
		return msg;
	}
	
	/**
	 * 获取文件下载url
	 * @return
	 */
	@RequestMapping(value = "/getDownloadUrl")
	@ResponseBody
	public IRestMessage getDownloadUrl(String baseUrl, String expires) {
		IRestMessage msg = getRestMessage();
		try {
			long time = Long.parseLong(expires);
			String url = qnservice.getDownloadUrl(baseUrl, time);
			logger.info(url);
			msg.setCode(ErrorMessage.SUCCESS.getCode());
			msg.setResult(url);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 获取空间名列表
	 * @return
	 */
	@RequestMapping(value = "/getBuckets")
	@ResponseBody
	public IRestMessage getBuckets() {
		IRestMessage msg = getRestMessage();
		String[] buckets = qnservice.getBuckets();
		msg.setCode(ErrorMessage.SUCCESS.getCode());
		msg.setResult(buckets);
		return msg;
	}
	
}
