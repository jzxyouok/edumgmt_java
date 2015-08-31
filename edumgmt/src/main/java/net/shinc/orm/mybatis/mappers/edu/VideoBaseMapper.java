package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoBase;
/**
  * @ClassName: VideoBaseMapper
  * @Description: 视频公共基础信息DAO接口
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
	
	public Integer updateQrCodeByVideoBaseById(VideoBase videoBase);

}