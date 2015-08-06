package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.mappers.edu.KnowledgePointMapper;
import net.shinc.service.edu.KnowledgePointService;
import net.shinc.service.edu.video.VideoBaseKnowledgePointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName KnowledgePointServiceImpl 
 * @Description 知识点服务接口实现
 * @author guoshijie 
 * @date 2015年8月4日 上午11:30:36
 */
@Service
public class KnowledgePointServiceImpl implements KnowledgePointService {

	@Autowired
	private KnowledgePointMapper knowledgePointMapper;
	
	@Autowired
	private VideoBaseKnowledgePointService videoBaseKnowledgePointService;

	@Override
	public Integer addKnowledgePoint(KnowledgePoint knowledgePoint) {
		if(null != knowledgePoint) {
			return knowledgePointMapper.addKnowledgePoint(knowledgePoint);
		}
		return 0;
	}

	@Override
	public Integer updateKnowledgePoint(KnowledgePoint knowledgePoint) {
		if(null != knowledgePoint) {
			return knowledgePointMapper.updateKnowledgePoint(knowledgePoint);
		}
		return 0;
	}

	@Override
	public Integer deleteKnowledgePointById(Integer id) {
		if(null != id) {
			return knowledgePointMapper.deleteKnowledgePointById(id);
		}
		return 0;
	}

	@Override
	public KnowledgePoint getKnowledgePointById(Integer id) {
		if(null != id) {
			KnowledgePoint point = knowledgePointMapper.selectKnowledgePointById(id);
			return point;
		}
		return null;
	}

	@Override
	public List<KnowledgePoint> getAllKnowledgePointList() {
		return knowledgePointMapper.getKnowledgePointList(null);
	}

	@Override
	public Boolean hasKnowledgePoint(KnowledgePoint knowledgePoint) {
		if(null != knowledgePoint) {
			KnowledgePoint point = knowledgePointMapper.hasKnowledgePoint(knowledgePoint);
			if(null != point) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public List<KnowledgePoint> getKnowledgePointListByCourse(Course course) {
		if(null != course) {
			return knowledgePointMapper.getKnowledgePointList(new KnowledgePoint(course, null));
		}
		return null;
	}

	@Override
	public List<KnowledgePoint> getKnowledgePointListByName(Course course, String name) {
		List<KnowledgePoint> list = knowledgePointMapper.getKnowledgePointList(new KnowledgePoint(course,"%" + name + "%"));
		return list;
	}

	@Override
	public Boolean isUsedKnowledgePoint(KnowledgePoint knowledgePoint) {
		if(null != knowledgePoint) {
			return videoBaseKnowledgePointService.isUsedKnowledgePoint(knowledgePoint);
		}
		return false;
	}
	
}
