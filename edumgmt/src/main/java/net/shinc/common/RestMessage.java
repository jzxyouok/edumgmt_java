package net.shinc.common;



import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;



public class RestMessage implements IRestMessage {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	public static final String PLACEHOLDER_PREFIX = "RestMessage.";
	private String code;
	private String message;
	private String detail;
	private Object result;
	private MessageSource messageSource;
	private Locale locale;
	private Map<String,Object> userInfo;
	
	public RestMessage(String code, MessageSource messageSource, Locale locale){
		
		this.messageSource = messageSource;
		this.locale = locale;
		
		logger.info("RestMessageCreated");
		
		this.code = code;
		if(messageSource == null) {
			this.message = code;
		} else {
			try {
				this.message = messageSource.getMessage(PLACEHOLDER_PREFIX + code, null, locale);
			} catch(Exception e) {
				throw e;
			}
		}
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
		try {
			this.message = messageSource.getMessage(PLACEHOLDER_PREFIX + code, null, locale);
		} catch(Exception e) {
			throw e;
		}
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public Map<String,Object> getUserInfo() {
		return this.userInfo;
	}

	@Override
	public void setUserInfo(Map<String,Object> map) {
		if(this.userInfo == null) {
			this.userInfo = new HashMap<String,Object>();
		}
		if(map != null) {
			this.userInfo.putAll(map);
		}
	}


}
