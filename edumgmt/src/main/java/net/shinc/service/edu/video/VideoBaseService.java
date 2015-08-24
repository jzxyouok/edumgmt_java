package net.shinc.service.edu.video;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.VideoBase;

/**
 * @ClassName: VideoBaseService
 * @Description: 视频公共基础信息服务接口
 * @author hushichong
 * @date 2015年7月31日 下午5:17:32
 */
public interface VideoBaseService {

	public void deleteVideoBaseById(Integer id);

	public Integer insertVideoBase(VideoBase videoBase);

	public void updateVideoBase(VideoBase videoBase);

	public VideoBase getByVideoBaseById(Integer id);

	public List<VideoBase> getVideoBaseList(VideoBase videoBase);

	public Integer getVideoBaseListCount(VideoBase videoBase);
	
	/**
	 * @Title: getVideoBase
	 * @Description: 根据对象参数得到单个实例
	 * @param videoBase
	 * @return VideoBase
	 */
	public VideoBase getVideoBase(VideoBase videoBase);
	
	/**
	 * 处理结果集，拼接二维码图片下载地址
	 * @param list
	 * @return
	 */
	public List<Map> appendQrUrl(List<Map> list);

}