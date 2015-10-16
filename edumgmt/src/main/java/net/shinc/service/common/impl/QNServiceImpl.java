package net.shinc.service.common.impl;

import java.net.URL;
import java.util.List;

import net.shinc.orm.mybatis.bean.edu.MyRet;
import net.shinc.service.common.QNService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @ClassName QNServiceImpl 
 * @Description 七牛存储服务接口实现
 * @author guoshijie 
 * @date 2015年8月21日 下午3:39:26
 */
@Service
public class QNServiceImpl implements InitializingBean,QNService{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${qiniu.accessKey}")
	private String accessKey = "h591Hrv-oh3BornRVEQqlDE7IJQYFgM-dkA44tKM";
	
	@Value("${qiniu.secretKey}")
	private String secretKey = "XFwQNCCycfAf6fv_Ox-teKB8Tf2Bk21Xr5cqYXEm";
	
	@Value("${qiniu.eduonline.domain}")
	private String domain;
	
	@Value("${qiniu.eduonline.deadline}")
	private String expires;
	
	//二维码所在空间名称
	@Value("${qiniu.eduonline.qrBucketName}")
	private String qrBucketName;
	
	//二维码所在空间域名
	@Value("${qiniu.eduonline.qrDomain}")
	private String qrDomain;
	
	public Auth auth;
	
	public QNServiceImpl() {
	}
	
	public String getUploadToken(String bucket, String key, long expires, StringMap policy, boolean strict) {
		return auth.uploadToken(bucket, key, expires, policy, strict);
	}
	
	@Override
	public String getUploadToken(String bucket, long expires) {
		return auth.uploadToken(bucket, null, expires, getPolicy(), true);
	}
	
	@Override
	public StringMap getPolicy() {
		StringMap policy = new StringMap();
//		policy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"videoBaseId\":$(x:videoBaseId)}");
		policy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"videoBaseId\":$(x:videoBaseId), \"avinfo\": $(avinfo)}");
		return policy;
	}
	
	public String getDownloadUrl(String baseUrl, long expires) {
		if(!StringUtils.isEmpty(baseUrl)) {
			String urlSigned = auth.privateDownloadUrl(baseUrl, expires);
			return urlSigned;
		}
		return null;
	}
	
	@Override
	public String appendQrUrl(String baseName) {
		if(!StringUtils.isEmpty(baseName)) {
			String addr = domain + baseName + "?download/" + baseName;
//			String addr2 = getDownloadUrl(addr, Long.parseLong(expires));
			return addr;
		}
		return null;
	}
	
	@Override
	public String generateQrDownUrl(String link){
		try {
			if(!StringUtils.isEmpty(link)) {
				URL url = new URL(link);
				String path = url.getPath();
				String key = path.substring(1);
				String downloadUrl = link + "?download/" + key;
				return downloadUrl;
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}
	
	@Override
	public String[] getBuckets() {
		try {
			String[] buckets = getBucketManager().buckets();
			return buckets;
		} catch (QiniuException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}
	
	@Override
	public FileInfo[] getFiles(String bucket,String prefix,Integer limit,String delimiter) {
		BucketManager.FileListIterator it = getBucketManager().createFileListIterator(bucket, prefix, limit, delimiter);
		while (it.hasNext()) {
		    FileInfo[] items = it.next();
		    logger.info(bucket + " has " + items.length + " files.");
		    if(null != items && items.length > 0){
		    	for(int i = 0; i<items.length; i++) {
		    		FileInfo fileInfo = items[i];
		    		logger.info(fileInfo.key);
		    	}
		    }
		    return items;
		}
		return null;
	}
	
	@Override
	public void deleteFile(String bucket, String key) {
		try {
			if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(bucket)) {
				getBucketManager().delete(bucket, key);
			}
		} catch (QiniuException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}
	
	@Override
	public void deleteFileBatch(String bucket, List<String> keyList){
		BucketManager.Batch ops = new BucketManager.Batch();
		
		if(null != keyList && keyList.size() > 0) {
			for (String key : keyList) {
				ops.delete(bucket, key);
			}
		}
		
		try {
		    Response r = getBucketManager().batch(ops);
		    BatchStatus[] bs = r.jsonToObject(BatchStatus[].class);
		    for (BatchStatus b : bs) {
//			        assertEquals(200, b.code);
		    }
		} catch (QiniuException e) {
		    Response r = e.response;
		    logger.error(r.toString()); // 请求失败时简单状态信息
		    try {
		    	logger.error(r.bodyString());// 响应的文本信息
		    } catch (QiniuException e1) {
		    	logger.error(ExceptionUtils.getStackTrace(e1));
		    }
		}
	}
	
	/**
	 * 上传二维码图片
	 * @param filePath 本地文件路径
	 * @param key 远程存储文件名
	 * @return
	 */
	public String uploadQrCode(String filePath,String key) {
		String token = getUploadToken(qrBucketName, Long.parseLong(expires));
		return upload(filePath, key, token, qrDomain);
	}
	
	/**
     * 上传文件
     * @param filePath 上传的文件路径
     * @param key      上传文件保存的文件名
     * @param token    上传凭证
     * @return sourceLink 上传后的资源链接
     */
	public String upload(String filePath, String key, String token, String qrDomain) {
		UploadManager uploadManager = new UploadManager();
	    try {
	        Response res = uploadManager.put(filePath, key, token);
	        MyRet ret = res.jsonToObject(MyRet.class);
	        logger.info(res.toString());
	        logger.info(res.bodyString());
	        if(res.isOK()) {
	        	return qrDomain + key;
	        }
	        return null;
	    } catch (QiniuException e) {
	        Response r = e.response;
	        // 请求失败时简单状态信息
	        logger.error(r.toString());
	        try {
	            // 响应的文本信息
	            logger.error(r.bodyString());
	        } catch (QiniuException e1) {
	            //ignore
	        }
	    }
	    return null;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		auth = Auth.create(getAccessKey(), getSecretKey());
	}
	
	public BucketManager getBucketManager() {
		BucketManager bucketManager = new BucketManager(auth);
		return bucketManager;
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
