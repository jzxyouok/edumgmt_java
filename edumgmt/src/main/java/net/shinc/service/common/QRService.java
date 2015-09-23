package net.shinc.service.common;

/**
 * @ClassName QRService 
 * @Description 生成二维码服务接口
 * @author guoshijie 
 * @date 2015年9月6日 下午4:50:16
 */
public interface QRService {
	
	/**
	 * 生成二维码
	 * @param filePath 二维码临时存放目录
	 * @param phpPath php播放视频地址
	 * @param videoBaseId 
	 * @return 二维码的绝对路径
	 */
	public String generateQrCode(String filePath, String phpPath, String content);

}
