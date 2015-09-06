package net.shinc.service.edu.video.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.QueryBean;
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
import net.shinc.service.edu.video.VideoBaseService;
import net.shinc.service.edu.video.VideoPointService;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
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
	@Autowired
	private VideoBaseService videoBaseService;

	@Override
	public Map insertVideoPoint(VideoPoint videoPoint) {
		Map map = new HashMap();
		VideoBase videoBase = videoPoint.getVideoBase();
		videoBase.setProfile(StringUtils.trim(videoBase.getProfile()));
		videoBase.setAdminUserId(AdminUser.getCurrentUser().getId());
		videoBase.setUpdatetime(new Date());
		videoBase.setQuestionId(String.valueOf(System.currentTimeMillis()));
		videoBaseMapper.insertVideoBase(videoBase);
		map.put("videoBaseId", videoBase.getId());
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
		if (StringUtils.isNotEmpty(videoPoint.getKnowledgePointIds())) {
			for (String id : StringUtils.split(videoPoint.getKnowledgePointIds(), ",")) {
				VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(Integer.valueOf(id));
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}

		// 插入关键字关系
		if (StringUtils.isNotEmpty(videoPoint.getKewordIds())) {
			for (String keywordId : StringUtils.split(videoPoint.getKewordIds(), ",")) {
				VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());
				videoBaseKeywordKey.setKeywordId(Integer.valueOf(keywordId));
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}
		videoPointMapper.insertVideoPoint(videoPoint);
		return map;
	}

	@Override
	public Map updateVideoPoint(VideoPoint videoPoint) {
		Map map = new HashMap();
		VideoBase videoBase = videoPoint.getVideoBase();
		videoBase.setUpdatetime(new Date());
		//考虑到目前仅2个字段无需更新，后续如果字段增多，考虑加上此更新方法
		//videoPointMapper.updateVideoPoint(videoPoint);
		map.put("videoBaseId", videoBase.getId());
		videoBase.setProfile(StringUtils.trim(videoBase.getProfile()));
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
		if (StringUtils.isNotEmpty(videoPoint.getKnowledgePointIds())) {
			
			VideoBaseKnowledgePointKey videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
			videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());	
			videoBaseKnowledgePointMapper.deleteVideoBaseKnowledgePoint(videoBaseKnowledgePointKey);
			
			for (String id : StringUtils.split(videoPoint.getKnowledgePointIds(), ",")) {
				videoBaseKnowledgePointKey = new VideoBaseKnowledgePointKey();
				videoBaseKnowledgePointKey.setVideoBaseId(videoBase.getId());
				videoBaseKnowledgePointKey.setKnowledgePointId(Integer.valueOf(id));
				
				videoBaseKnowledgePointMapper.insert(videoBaseKnowledgePointKey);
			}
		}
		// 更新关键字关系
		if(StringUtils.isNotEmpty(videoPoint.getKewordIds())){
			VideoBaseKeywordKey videoBaseKeywordKey = new VideoBaseKeywordKey();
			videoBaseKeywordKey.setVideoBaseId(videoBase.getId());	
			videoBaseKeywordMapper.deleteVideoKeywordById(videoBaseKeywordKey);
			
			for (String keywordId : StringUtils.split(videoPoint.getKewordIds(), ",")) {
				videoBaseKeywordKey = new VideoBaseKeywordKey();
				videoBaseKeywordKey.setVideoBaseId(videoBase.getId());	
				videoBaseKeywordKey.setKeywordId(Integer.valueOf(keywordId));
				videoBaseKeywordMapper.insertVideoKeyword(videoBaseKeywordKey);
			}
		}
		return map;
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
	public List<Map> getVideoPointAndRelevantInfoList(QueryBean queryBean,RowBounds rowBounds) {
		List<Map> list = videoPointMapper.getVideoPointAndRelevantInfoList(queryBean,rowBounds);
		List<Map> list2 = videoBaseService.appendQrUrl(list);
		return list2;
	}

	@Override
	public List<VideoPoint> getVideoPointAndRelevantInfoListCount(VideoPoint videoPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}