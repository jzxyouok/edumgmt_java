package net.shinc.service.edu.video.impl;

import java.util.Date;
import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.mappers.edu.VideoDetailMapper;
import net.shinc.service.edu.video.VideoDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * @ClassName: VideoDetailServiceImpl
  * @Description: 视频详情服务接口实现类
  * @author hushichong
  * @date 2015年8月4日 下午5:11:35
 */
@Service
public class VideoDetailServiceImpl implements VideoDetailService {

	@Autowired
	private VideoDetailMapper videoDetailMapper;
	
	@Override
	public void deleteVideoDetailById(VideoDetail vd) {
		videoDetailMapper.deleteVideoDetailById(vd);
		
	}

	@Override
	public Integer insertVideoDetail(VideoDetail videoDetail) {
		videoDetail.setUpdatetime(new Date());
		return videoDetailMapper.insertVideoDetail(videoDetail);
	}

	@Override
	public void updateVideoDetail(VideoDetail videoDetail) {
		videoDetailMapper.updateVideoDetail(videoDetail);
		
	}

	@Override
	public VideoDetail getByVideoDetailById(VideoDetail vd) {
		return videoDetailMapper.getByVideoDetailById(vd);
	}

	@Override
	public List<VideoDetail> getVideoDetailList(VideoDetail videoDetail) {
		return videoDetailMapper.getVideoDetailList(videoDetail);
	}

	@Override
	public Integer getVideoDetailListCount(VideoDetail videoDetail) {
		return videoDetailMapper.getVideoDetailListCount(videoDetail);
	}

	@Override
	public VideoDetail getVideoDetail(VideoDetail videoDetail) {
		List list = getVideoDetailList(videoDetail);
		if(list != null && list.size() == 1){
			return (VideoDetail)list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<VideoDetail> getVideoDetailListByVideoBaseId(Integer videoBaseId) {
		if(null != videoBaseId) {
			List<VideoDetail> list = videoDetailMapper.getVideoDetailListByVideoBaseId(videoBaseId);
			return list;
		}
		return null;
	}

}