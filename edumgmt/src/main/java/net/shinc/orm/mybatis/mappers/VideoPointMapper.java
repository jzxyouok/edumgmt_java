package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPoint;
/**
  * @ClassName: VideoPointMapper
  * @author hushichong
  * @date 2015年7月31日 下午4:52:24
 */
public interface VideoPointMapper {
    
    public void deleteVideoPointById(Integer id);

	public Integer insertVideoPoint(VideoPoint videoPoint);

	public void updateVideoPoint(VideoPoint videoPoint);

	public VideoPoint getByVideoPointById(Integer id);

	public List<VideoPoint> getVideoPointList(VideoPoint videoPoint);

	public Integer getVideoPointListCount(VideoPoint videoPoint);
}