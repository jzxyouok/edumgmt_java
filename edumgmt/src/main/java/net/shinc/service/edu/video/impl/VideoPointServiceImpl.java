package net.shinc.service.edu.video.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPoint;
import net.shinc.orm.mybatis.mappers.VideoPointMapper;
import net.shinc.service.edu.video.VideoPointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: VideoPointServiceImpl
 * @Description: 知识点服务接口实现
 * @author hushichong
 * @date 2015年7月31日 下午5:48:52
 */
@Service
public class VideoPointServiceImpl implements VideoPointService {

	@Autowired
	private VideoPointMapper videoPointMapper;

	@Override
	public void deleteVideoPointById(Integer id) {
		videoPointMapper.deleteVideoPointById(id);

	}

	@Override
	public Integer insertVideoPoint(VideoPoint videoPoint) {
		return videoPointMapper.insertVideoPoint(videoPoint);
	}

	@Override
	public void updateVideoPoint(VideoPoint videoPoint) {
		videoPointMapper.updateVideoPoint(videoPoint);

	}

	@Override
	public VideoPoint getByVideoPointById(Integer id) {
		return videoPointMapper.getByVideoPointById(id);
	}

	@Override
	public List<VideoPoint> getVideoPointList(VideoPoint videoPoint) {
		return videoPointMapper.getVideoPointList(videoPoint);
	}

	@Override
	public Integer getVideoPointListCount(VideoPoint videoPoint) {
		return videoPointMapper.getVideoPointListCount(videoPoint);
	}

	@Override
	public VideoPoint getVideoPoint(VideoPoint videoPoint) {
		List list = getVideoPointList(videoPoint);
		if (list != null && list.size() == 1) {
			return (VideoPoint) list.get(0);
		} else {
			return null;
		}
	}

}