package net.shinc.service.edu.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.TreeNode;
import net.shinc.orm.mybatis.mappers.edu.KnowledgePointMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseKnowledgePointMapper;
import net.shinc.service.edu.KnowledgePointService;
import net.shinc.service.edu.video.VideoBaseKnowledgePointService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private VideoBaseKnowledgePointMapper videoBaseKnowledgePointMapper;
	
	
	@Autowired
	private VideoBaseKnowledgePointService videoBaseKnowledgePointService;
	private Logger logger = LoggerFactory.getLogger(getClass());
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
	@Override
	public List<TreeNode<KnowledgePoint>> getKnowledgePointListTree() {
		try {
			
			List<TreeNode<KnowledgePoint>> list = knowledgePointMapper.getKnowledgePointListTree();
			
			List<TreeNode<KnowledgePoint>> root = new ArrayList<TreeNode<KnowledgePoint>>();
			Map<Integer,TreeNode<KnowledgePoint>> map = new HashMap();
			// 无论父还是子都转化为 id为key 节点实体为value的map结构
			for(Iterator<TreeNode<KnowledgePoint>> it = list.iterator(); it.hasNext();) {
				TreeNode<KnowledgePoint> node = it.next();
				map.put(node.getId(), node);
			}
			// 遍历添加子节点（判段如果是子节点，则根据父id从map中取出父对象，将子加入）
			for(Iterator<TreeNode<KnowledgePoint>> it = list.iterator(); it.hasNext();) {
				TreeNode<KnowledgePoint> node = it.next();
				Integer parentId = node.getParent();
				if(parentId == 0) {
					root.add(node);
					
				} else {
					TreeNode<KnowledgePoint> parent = map.get(parentId);
					if(parent == null) {
						logger.warn("can not find its parent for :" + node);
					} else {
						parent.addChild(node);
					}
					
				}
			}
			return root;
			
			
		} catch(Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			return null;
		}
	}


	@Override
	public List<KnowledgePoint> selectCatPointByPId(Integer pid) {
		List<KnowledgePoint> collections = knowledgePointMapper.selectCatPointByPId(pid);
		for (KnowledgePoint a : collections) {
			
			a.setName(null);
			a.setCourseId(8);
			knowledgePointMapper.updateKnowledgePoint(a);
			
			List listtemo = knowledgePointMapper.selectCatPointByPId(a.getId());
			if(listtemo.size()>0){// you
				a.setChildren(listtemo);
				for (KnowledgePoint ac : (List<KnowledgePoint>)listtemo) {
					
					ac.setName(null);
					ac.setCourseId(8);
					knowledgePointMapper.updateKnowledgePoint(ac);
					
					List listtemoooo = knowledgePointMapper.selectCatPointByPId(ac.getId());
					if (listtemoooo.size()>0) {// 还有子节点(递归调用)
						ac.setChildren(this.selectCatPointByPId(ac.getId()));
					} 
				}
			}
			
			
		}
		
		return collections;
	}
}
