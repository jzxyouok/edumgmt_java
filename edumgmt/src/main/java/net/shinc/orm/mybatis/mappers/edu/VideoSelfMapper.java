package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.VideoSelf;
/**
  * @ClassName: VideoSelfMapper
  * @Description: 自编题DAO接口
  * @author hushichong
  * @date 2015年7月31日 下午4:56:56
 */
public interface VideoSelfMapper {
	
	public void deleteVideoSelfById(Integer id);

	public Integer insertVideoSelf(VideoSelf videoSelf);

	public void updateVideoSelf(VideoSelf videoSelf);

	public VideoSelf getByVideoSelfById(Integer id);

	public List<VideoSelf> getVideoSelfList(VideoSelf videoSelf);

	public Integer getVideoSelfListCount(VideoSelf videoSelf);
	
	/**
	 * @Title: getVideoSelfAndRelevantInfoList
	 * @Description: 得到自编题以及其相关信息列表
	 * @param videoSelf
	 * @return List<VideoSelf>
	 */
	public List<Map> getVideoSelfAndRelevantInfoList(VideoSelf videoSelf);
	
	/**
	 * @Title: getVideoSelfAndRelevantInfoListCount
	 * @Description: 得到自编题以及其相关信息列表总条数
	 * @param videoSelf
	 * @return List<VideoSelf>
	 */
	public List<VideoSelf> getVideoSelfAndRelevantInfoListCount(VideoSelf videoSelf);
}