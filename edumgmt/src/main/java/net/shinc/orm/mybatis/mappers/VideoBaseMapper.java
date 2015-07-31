package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoBase;
/**
  * @ClassName: VideoBaseMapper
  * @author hushichong
  * @date 2015年7月31日 下午4:42:55
 */
public interface VideoBaseMapper {

	public void deleteVideoBaseById(Integer id);

	public Integer insertVideoBase(VideoBase videoBase);

	public void updateVideoBase(VideoBase videoBase);

	public VideoBase getByVideoBaseById(Integer id);

	public List<VideoBase> getVideoBaseList(VideoBase videoBase);

	public Integer getVideoBaseListCount(VideoBase videoBase);

}