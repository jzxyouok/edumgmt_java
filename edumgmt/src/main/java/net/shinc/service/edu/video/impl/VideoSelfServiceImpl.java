package net.shinc.service.edu.video.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoSelf;
import net.shinc.orm.mybatis.mappers.VideoSelfMapper;
import net.shinc.service.edu.video.VideoSelfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: VideoSelfServiceImpl
 * @Description: 自编题服务接口实现
 * @author hushichong
 * @date 2015年7月31日 下午5:48:34
 */
@Service
public class VideoSelfServiceImpl implements VideoSelfService {

	@Autowired
	private VideoSelfMapper videoSelfMapper;

	@Override
	public void deleteVideoSelfById(Integer id) {
		videoSelfMapper.deleteVideoSelfById(id);

	}

	@Override
	public Integer insertVideoSelf(VideoSelf videoSelf) {
		return videoSelfMapper.insertVideoSelf(videoSelf);
	}

	@Override
	public void updateVideoSelf(VideoSelf videoSelf) {
		videoSelfMapper.updateVideoSelf(videoSelf);

	}

	@Override
	public VideoSelf getByVideoSelfById(Integer id) {
		return videoSelfMapper.getByVideoSelfById(id);
	}

	@Override
	public List<VideoSelf> getVideoSelfList(VideoSelf videoSelf) {
		return videoSelfMapper.getVideoSelfList(videoSelf);
	}

	@Override
	public Integer getVideoSelfListCount(VideoSelf videoSelf) {
		return videoSelfMapper.getVideoSelfListCount(videoSelf);
	}

	@Override
	public VideoSelf getVideoSelf(VideoSelf videoSelf) {
		List list = getVideoSelfList(videoSelf);
		if (list != null && list.size() == 1) {
			return (VideoSelf) list.get(0);
		} else {
			return null;
		}
	}

}