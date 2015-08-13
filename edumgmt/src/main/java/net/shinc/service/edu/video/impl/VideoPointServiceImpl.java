package net.shinc.service.edu.video.impl;

import java.util.Date;
import java.util.List;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.edu.Keyword;
import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;
import net.shinc.orm.mybatis.bean.edu.VideoBaseKnowledgePointKey;
import net.shinc.orm.mybatis.bean.edu.VideoDetail;
import net.shinc.orm.mybatis.bean.edu.VideoPoint;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseKeywordMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseKnowledgePointMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoDetailMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoPointMapper;
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
	@Autowired
	private VideoBaseMapper videoBaseMapper;
	@Autowired
	private VideoDetailMapper videoDetailMapper;
	@Autowired
	private VideoBaseKnowledgePointMapper videoBaseKnowledgePointMapper;
	@Autowired
	private VideoBaseKeywordMapper videoBaseKeywordMapper;

	@Override
	public Integer insertVideoPoint(VideoPoint videoPoint) {
		VideoBase videoBase = videoPoint.getVideoBase();
		videoBase.setAdminUserId(AdminUser.getCurrentUser().getId());
		videoBase.setUpdatetime(new Date());
		videoBaseMapper.insertVideoBase(videoBase);
		videoPoint.setVideoBaseId(videoBase.getId());
		// 插入视频详情
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getVideoDetailList() != null && videoPoint.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoPoint.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.insertVideoDetail(vd);
			}
		}

		// 插入知识点关系
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getKnowledgetPointList() != null && videoPoint.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoPoint.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 插入关键字关系
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getKeywordList() != null && videoPoint.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoPoint.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}

		return videoPointMapper.insertVideoPoint(videoPoint);
	}

	@Override
	public void updateVideoPoint(VideoPoint videoPoint) {
		VideoBase videoBase = videoPoint.getVideoBase();
		videoBase.setUpdatetime(new Date());
		
		videoPointMapper.updateVideoPoint(videoPoint);
		videoBaseMapper.updateVideoBase(videoBase);
		
		// 更新视频详情
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getVideoDetailList() != null && videoPoint.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoPoint.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.updateVideoDetail(vd);
			}
		}

		// 更新知识点关系
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getKnowledgetPointList() != null
				&& videoPoint.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoPoint.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.deleteVideoBaseKnowledgePoint(videoBaseKnowledgePointKey);
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 更新关键字关系
		if (videoPoint.getVideoBase() != null && videoPoint.getVideoBase().getKeywordList() != null
				&& videoPoint.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoPoint.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.deleteVideoKeywordById(videoBaseKeywordKey);
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}

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
	
	@Override
	public void deleteVideoPointById(Integer id) {
		videoPointMapper.deleteVideoPointById(id);

	}

	@Override
	public List<VideoPoint> getVideoPointAndRelevantInfoList(VideoPoint videoPoint) {
		return videoPointMapper.getVideoPointAndRelevantInfoList(videoPoint);
	}

	@Override
	public List<VideoPoint> getVideoPointAndRelevantInfoListCount(VideoPoint videoPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}