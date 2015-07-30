package net.shinc.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.gson.Gson;

/**
 * 工具类
 * @author zhangtaichao 2015年7月16日
 *
 */
public class ShincUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ShincUtil.class);
	
	
	/**
	 * 返回数据格式如：
	 * <p>
	 * {"phone":"格式不正确","name":"不能为空"}
	 * </p>
	 * @param bindingResult 由spring表单验证产生的bindingResult对象
	 * @return
	 */
	public static String getErrorFields(BindingResult bindingResult) {
		Gson gson = new Gson();
		if(bindingResult == null || !bindingResult.hasErrors()) {
			gson.toJson(null);
		}
		try {
			Map<String,Object> tmpMap = new HashMap<String,Object>();
			List<FieldError> listerror = bindingResult.getFieldErrors();
			for(FieldError fe : listerror) {
				tmpMap.put(fe.getField(), fe.getDefaultMessage());
			}
			return gson.toJson(tmpMap);
		} catch(Exception e) {
			logger.equals(ExceptionUtils.getStackTrace(e));
			return gson.toJson(null);
		}
	}
	
	/**
	 * 将data按照指定pattern格式化成String
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date,String pattern) {
		try {
			DateFormat format = new SimpleDateFormat(pattern);
			String datetime = format.format(date);
			return datetime;
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}

}
