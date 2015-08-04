package net.shinc.service.edu.video.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.orm.mybatis.bean.VideoBaseKnowledgePointKey;
import net.shinc.orm.mybatis.mappers.VideoBaseKnowledgePointMapper;
import net.shinc.service.edu.video.VideoBaseKnowledgePointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName VideoBaseKnowledgePointServiceImpl 
 * @Description 视频与知识点关系服务接口实现
 * @author guoshijie 
 * @date 2015年8月4日 下午3:04:28
 */
@Service
public class VideoBaseKnowledgePointServiceImpl implements VideoBaseKnowledgePointService {

	@Autowired
	private VideoBaseKnowledgePointMapper videoBaseKnowledgePointMapper;
	
	/**
	 * 判断该知识点是否被使用
	 */
	@Override
	public Boolean isUsedKnowledgePoint(KnowledgePoint knowledgePoint) {
		if(null != knowledgePoint) {
			Integer integer = videoBaseKnowledgePointMapper.isUsedKnowledgePoint(knowledgePoint);
			if(null != integer){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<KnowledgePoint> getKnowledgePointListByVideo(VideoBase videoBase) {
		if(null != videoBase) {
			return videoBaseKnowledgePointMapper.getKnowledgePointListByVideo(videoBase);
		}
		return null;
	}

	/**
	 * 给视频添加知识点
	 */
	@Override
	public Integer addKnowledgePointForVideoBase(VideoBaseKnowledgePointKey record) {
		if(null != record) {
			return videoBaseKnowledgePointMapper.insert(record);
		}
		return 0;
	}

	/**
	 * 给视频批量添加知识点
	 */
	@Override
	public Integer addKnowledgePointForVideoBaseBatch(List<VideoBaseKnowledgePointKey> list) {
		if(null != list && list.size() > 0) {
			return videoBaseKnowledgePointMapper.insertBatch(list);
		}
		return 0;
	}
	
	@Override
	public Integer deleteKnowledgePointForVideoBase(VideoBaseKnowledgePointKey record) {
		if(null != record) {
			return videoBaseKnowledgePointMapper.deleteVideoBaseKnowledgePoint(record);
		}
		return 0;
	}


}
