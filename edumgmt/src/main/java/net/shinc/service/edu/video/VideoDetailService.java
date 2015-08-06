package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoDetail;

/**
  * @ClassName: VideoDetailService
  * @Description: 视频信息服务
  * @author hushichong
  * @date 2015年8月4日 下午5:09:44
 */
public interface VideoDetailService {

	public void deleteVideoDetailById(Integer id);

	public Integer insertVideoDetail(VideoDetail videoDetail);

	public void updateVideoDetail(VideoDetail videoDetail);

	public VideoDetail getByVideoDetailById(Integer id);

	public List<VideoDetail> getVideoDetailList(VideoDetail videoDetail);

	public Integer getVideoDetailListCount(VideoDetail videoDetail);
	
	/**
	 * @Title: getVideoDetail
	 * @Description: 根据对象参数得到单个实例
	 * @param videoDetail
	 * @return VideoDetail
	 */
	public VideoDetail getVideoDetail(VideoDetail videoDetail);

}