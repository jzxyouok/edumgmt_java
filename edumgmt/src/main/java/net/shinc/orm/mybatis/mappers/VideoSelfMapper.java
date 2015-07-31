package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoSelf;
/**
  * @ClassName: VideoSelfMapper
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
}