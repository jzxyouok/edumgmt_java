package net.shinc.service.common;

import java.util.Map;

/**
 * @ClassName QRService 
 * @Description 生成二维码服务接口
 * @author guoshijie 
 * @date 2015年9月6日 下午4:50:16
 */
public interface QRService {
	
	/**
	 * 二维码携带信息类型
	 */
	public static final String QRPARAM_TYPE_BASEID = "0";
	public static final String QRPARAM_TYPE_PROBLEMID = "1";
	
	
	public static final String QRPARAM_ID = "id";
	public static final String QRPARAM_TYPE = "type";
	public static final String QRPARAM_PROBLEMID = "problemId";
	
	
	/**
	 *  生成二维码信息并上传至七牛服务器
	 * @param param 二维码所带参数
	 * @return  二维码的七牛服务器地址
	 */
	public String generateQrCode(Map<String,Object> param);
	
	/**
	 * 生成二维码
	 * @param filePath 二维码临时存放目录
	 * @param phpPath php播放视频地址
	 * @param videoBaseId 
	 * @return 二维码的绝对路径
	 */
	public String generateQrCode(String filePath, String phpPath, String content);

}
