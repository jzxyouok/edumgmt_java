package net.shinc.service.common.impl;

import net.shinc.service.common.QNService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

@Service
public class QNServiceImpl implements InitializingBean,QNService{
	
	@Value("${qiniu.accessKey}")
	private String accessKey = "AeXxr_RO2G7G273HkoE8hJ4w2cgGfDHGBmqtcRY7";
	
	@Value("${qiniu.secretKey}")
	private String secretKey = "5idJ2SRiXonQ2ZUnVG12eKEDn7aeTxg5dWSRpuAG";
	
	public Auth auth;
	
	public QNServiceImpl() {
		
	}
	
	public String getUploadToken(String bucket, String key, long expires, StringMap policy, boolean strict) {
		return auth.uploadToken(bucket, key, expires, policy, strict);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		auth = Auth.create(getAccessKey(), getSecretKey());
	}
	
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
