package net.shinc.service.edu.video.impl;

import java.util.Date;
import java.util.List;

import net.shinc.orm.mybatis.bean.Keyword;
import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.orm.mybatis.bean.VideoBaseKeywordKey;
import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;
import net.shinc.orm.mybatis.bean.VideoDetail;
import net.shinc.orm.mybatis.bean.VideoPastpaper;
import net.shinc.orm.mybatis.mappers.VideoBaseKeywordMapper;
import net.shinc.orm.mybatis.mappers.VideoBaseKnowledgePointMapper;
import net.shinc.orm.mybatis.mappers.VideoBaseMapper;
import net.shinc.orm.mybatis.mappers.VideoDetailMapper;
import net.shinc.orm.mybatis.mappers.VideoPastpaperMapper;
import net.shinc.service.edu.video.VideoPastpaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: VideoPastpaperServiceImpl
 * @Description: 真题、模拟题服务接口实现
 * @author hushichong
 * @date 2015年7月31日 下午5:43:01
 */
@Service
public class VideoPastpaperServiceImpl implements VideoPastpaperService {

	@Autowired
	private VideoPastpaperMapper videoPastpaperMapper;
	@Autowired
	private VideoBaseMapper videoBaseMapper;
	@Autowired
	private VideoDetailMapper videoDetailMapper;
	@Autowired
	private VideoBaseKnowledgePointMapper videoBaseKnowledgePointMapper;
	@Autowired
	private VideoBaseKeywordMapper videoBaseKeywordMapper;
	

	@Override
	public void deleteVideoPastpaperById(Integer id) {
		videoPastpaperMapper.deleteVideoPastpaperById(id);

	}

	@Override
	public Integer insertVideoPastpaper(VideoPastpaper videoPastpaper) {
		VideoBase videoBase = videoPastpaper.getVideoBase();
		videoBase.setUpdatetime(new Date());
		videoBaseMapper.insertVideoBase(videoBase);
		videoPastpaper.setVideoBaseId(videoBase.getId());
		// 插入视频详情
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getVideoDetailList() != null && videoPastpaper.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoPastpaper.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.insertVideoDetail(vd);
			}
		}

		// 插入知识点关系
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getKnowledgetPointList() != null
				&& videoPastpaper.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoPastpaper.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 插入关键字关系
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getKeywordList() != null
				&& videoPastpaper.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoPastpaper.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}

		return videoPastpaperMapper.insertVideoPastpaper(videoPastpaper);
	}

	@Override
	public void updateVideoPastpaper(VideoPastpaper videoPastpaper) {
		VideoBase videoBase = videoPastpaper.getVideoBase();
		videoBase.setUpdatetime(new Date());
		
		videoPastpaperMapper.updateVideoPastpaper(videoPastpaper);
		videoBaseMapper.updateVideoBase(videoBase);
		
		// 更新视频详情
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getVideoDetailList() != null && videoPastpaper.getVideoBase().getVideoDetailList().size() > 0) {
			for (VideoDetail vd : (List<VideoDetail>) videoPastpaper.getVideoBase().getVideoDetailList()) {
				vd.setVideoBaseId(videoBase.getId());
				vd.setUpdatetime(new Date());
				videoDetailMapper.updateVideoDetail(vd);
			}
		}

		// 更新知识点关系
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getKnowledgetPointList() != null
				&& videoPastpaper.getVideoBase().getKnowledgetPointList().size() > 0) {
			for (KnowledgePoint vd : (List<KnowledgePoint>) videoPastpaper.getVideoBase().getKnowledgetPointList()) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(vd.getId());
				videoBaseKnowledgePointMapper.deleteVideoBaseKnowledgePoint(videoBaseKnowledgePointKey);
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 更新关键字关系
		if (videoPastpaper.getVideoBase() != null && videoPastpaper.getVideoBase().getKeywordList() != null
				&& videoPastpaper.getVideoBase().getKeywordList().size() > 0) {
			for (Keyword vd : (List<Keyword>) videoPastpaper.getVideoBase().getKeywordList()) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(vd.getId());
				videoBaseKeywordMapper.deleteVideoKeywordById(videoBaseKeywordKey);
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}
		

	}

	@Override
	public VideoPastpaper getByVideoPastpaperById(Integer id) {
		return videoPastpaperMapper.getByVideoPastpaperById(id);
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperList(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.getVideoPastpaperList(videoPastpaper);
	}

	@Override
	public Integer getVideoPastpaperListCount(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.getVideoPastpaperListCount(videoPastpaper);
	}

	@Override
	public VideoPastpaper getVideoPastpaper(VideoPastpaper videoPastpaper) {
		List list = getVideoPastpaperList(videoPastpaper);
		if (list != null && list.size() == 1) {
			return (VideoPastpaper) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperAndRelevantInfoList(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.getVideoPastpaperAndRelevantInfoList(videoPastpaper);
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperAndRelevantInfoListCount(VideoPastpaper videoPastpaper) {
		// TODO Auto-generated method stub
		return null;
	}

}