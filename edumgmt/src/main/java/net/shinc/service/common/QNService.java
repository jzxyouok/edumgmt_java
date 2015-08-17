package net.shinc.service.common;

import com.qiniu.util.StringMap;

/**
 * 七牛存储服务
 * @author zhangtaichao 2015年8月14日
 *
 */
public interface QNService {
	
	/**
	* 生成上传token
	*
	* @param bucket  空间名
	* @param key     key，可为 null
	* @param expires 有效时长，单位秒。默认3600s
	* @param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
	*        scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
	* @param strict  是否去除非限定的策略字段，默认true
	* @return 生成的上传token
	*/
	public String getUploadToken(String bucket, String key, long expires, StringMap policy, boolean strict);

}
