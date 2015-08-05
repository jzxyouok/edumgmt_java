package net.shinc.service.edu.video.impl;

import java.util.Date;
import java.util.List;

import net.shinc.orm.mybatis.bean.Keyword;
import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.orm.mybatis.bean.VideoBaseKeywordKey;
import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;
import net.shinc.orm.mybatis.bean.VideoDetail;
import net.shinc.orm.mybatis.bean.VideoSelf;
import net.shinc.orm.mybatis.mappers.VideoBaseKeywordMapper;
import net.shinc.orm.mybatis.mappers.VideoBaseKnowledgePointMapper;
import net.shinc.orm.mybatis.mappers.VideoBaseMapper;
import net.shinc.orm.mybatis.mappers.VideoDetailMapper;
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
	@Autowired
	private VideoBaseMapper videoBaseMapper;
	@Autowired
	private VideoDetailMapper videoDetailMapper;
	@Autowired
	private VideoBaseKnowledgePointMapper videoBaseKnowledgePointMapper;
	@Autowired
	private VideoBaseKeywordMapper videoBaseKeywordMapper;

	@Override
	public Integer insertVideoSelf(VideoSelf videoSelf) {
		VideoBase videoBase = videoSelf.getVideoBase();
		videoBase.setUpdatetime(new Date());
		videoBaseMapper.insertVideoBase(videoBase);
		videoSelf.setVideoBaseId(videoBase.getId());
		// 插入视频详情
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getVideoDetailList() != null && videoSelf.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoSelf.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.insertVideoDetail(vd);
			}
		}

		// 插入知识点关系
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getKnowledgetPointList() != null && videoSelf.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoSelf.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 插入关键字关系
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getKeywordList() != null && videoSelf.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoSelf.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}

		return videoSelfMapper.insertVideoSelf(videoSelf);
	}

	@Override
	public void updateVideoSelf(VideoSelf videoSelf) {
		VideoBase videoBase = videoSelf.getVideoBase();
		videoBase.setUpdatetime(new Date());
		
		videoSelfMapper.updateVideoSelf(videoSelf);
		videoBaseMapper.updateVideoBase(videoBase);
		
		// 更新视频详情
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getVideoDetailList() != null && videoSelf.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoSelf.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.updateVideoDetail(vd);
			}
		}

		// 更新知识点关系
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getKnowledgetPointList() != null
				&& videoSelf.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoSelf.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.deleteVideoBaseKnowledgePoint(videoBaseKnowledgePointKey);
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 更新关键字关系
		if (videoSelf.getVideoBase() != null && videoSelf.getVideoBase().getKeywordList() != null
				&& videoSelf.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoSelf.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.deleteVideoKeywordById(videoBaseKeywordKey);
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}

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

	@Override
	public void deleteVideoSelfById(Integer id) {
		videoSelfMapper.deleteVideoSelfById(id);

	}

	@Override
	public List<VideoSelf> getVideoSelfAndRelevantInfoList(VideoSelf videoSelf) {
		return videoSelfMapper.getVideoSelfAndRelevantInfoList(videoSelf);
	}

	@Override
	public List<VideoSelf> getVideoSelfAndRelevantInfoListCount(VideoSelf videoSelf) {
		// TODO Auto-generated method stub
		return null;
	}

}