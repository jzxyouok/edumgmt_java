package net.shinc.service.edu.video;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoSelf;

import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName: VideoSelfService
 * @Description: 自编题服务接口
 * @author hushichong
 * @date 2015年7月31日 下午5:22:01
 */
public interface VideoSelfService {

	public void deleteVideoSelfById(Integer id);

	/**
	 * @Title: insertVideoSelf
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoSelf
	 * @return Map
	 */
	public Map insertVideoSelf(VideoSelf videoSelf);

	/**
	 * @Title: updateVideoSelf
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoSelf
	 * @return Map
	 */
	public Map updateVideoSelf(VideoSelf videoSelf);

	public VideoSelf getByVideoSelfById(Integer id);

	public List<VideoSelf> getVideoSelfList(VideoSelf videoSelf);


	/**
	 * @Title: getVideoSelf
	 * @Description: 根据对象参数得到单个实例
	 * @param videoSelf
	 * @return videoSelf
	 */
	public VideoSelf getVideoSelf(VideoSelf videoSelf);

	/**
	 * @Title: getVideoSelfAndRelevantInfoList
	 * @Description: 得到自编题以及其相关信息列表
	 * @param videoPastpaper
	 * @return List<VideoPastpaper>
	 */
	public List<Map> getVideoSelfAndRelevantInfoList(QueryBean queryBean, RowBounds rowBounds);

}