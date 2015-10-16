package net.shinc.service.common;

import java.util.List;

import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.StringMap;

/**
 * @ClassName QNService 
 * @Description 七牛存储服务
 * @author guoshijie
 * @date 2015年8月21日 下午3:23:10
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
	
	public String getUploadToken(String bucket, long expires);
	
	public StringMap getPolicy();
	
	/**
	 * 生成下载Url
	 * baseUrl 待签名文件url，如 http://img.domain.com/u/3.jpg 、 http://img.domain.com/u/3.jpg?imageView2/1/w/120
	 * expires 有效时长，单位秒。默认3600s
	 * @return
	 */
	public String getDownloadUrl(String baseUrl, long expires);
	
	/**
	 * 获取空间名列表
	 * @return
	 */
	public String[] getBuckets();
	
	/**
	 * 列举空间下的所有资源
	 * @param bucket    空间名
	 * @param prefix    文件名前缀
	 * @param limit     每次迭代的长度限制，最大1000，推荐值 100
	 * @param delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
	 * @return FileInfo[]
	 */
	public FileInfo[] getFiles(String bucket,String prefix,Integer limit,String delimiter);
	
	/**
	 * 删除文件
	 * @param bucket 空间名称
	 * @param key	 文件名称
	 */
	public void deleteFile(String bucket, String key);
	
	/**
	 * 批量删除文件
	 * @param bucket	空间名称
	 * @param keyList	远程文件名list
	 */
	public void deleteFileBatch(String bucket, List<String> keyList);
	
	/**
	 * 拼接二维码图片地址
	 * @param baseName
	 * @return
	 */
	public String appendQrUrl(String baseName);
	
	/**
	 * 生成二维码图片下载地址
	 * @param link
	 * @return
	 */
	public String generateQrDownUrl(String link);
	
	/**
	 * 上传二维码图片
	 * @param filePath 本地文件路径
	 * @param key 远程存储文件名
	 * @return
	 */
	public String uploadQrCode(String filePath,String key);
	
	/**
     * 上传文件
     * @param filePath 上传的文件路径
     * @param key      上传文件保存的文件名
     * @param token    上传凭证
     * @param qrDomain 二维码存储空间域名
     * @return sourceLink
     */
	public String upload(String filePath, String key, String token,  String qrDomain);
}
