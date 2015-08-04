package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.Course;
import net.shinc.orm.mybatis.bean.KnowledgePoint;

/**
 * @ClassName KnowledgePointService 
 * @Description 知识点服务接口
 * @author guoshijie 
 * @date 2015年8月4日 上午11:24:40
 */
public interface KnowledgePointService {

	/**
	 * 添加知识点
	 * @param KnowledgePoint
	 * @return
	 */
	public Integer addKnowledgePoint(KnowledgePoint knowledgePoint);
	
	/**
	 * 修改知识点
	 * @param KnowledgePoint
	 * @return
	 */
	public Integer updateKnowledgePoint(KnowledgePoint knowledgePoint);
	
	/**
	 * 删除知识点
	 * @param KnowledgePoint
	 * @return
	 */
	public Integer deleteKnowledgePointById(Integer id);
	
	/**
	 * 根据id查询知识点
	 * @param KnowledgePoint
	 * @return
	 */
	public KnowledgePoint getKnowledgePointById(Integer id);
	
	/**
	 * 查询所有知识点列表
	 * @return
	 */
	public List<KnowledgePoint> getAllKnowledgePointList();
	
	/**
	 * 查询某课程下的知识点列表
	 * @return
	 */
	public List<KnowledgePoint> getKnowledgePointListByCourse(Course course);
	
	/**
	 * 根据名称模糊查询某课程下的知识点列表
	 * @return
	 */
	public List<KnowledgePoint> getKnowledgePointListByName(Course course,String name);
	
	/**
	 * 有无知识点
	 * @param knowledgePoint
	 * @return
	 */
	public Boolean hasKnowledgePoint(KnowledgePoint knowledgePoint);
	
	/**
	 * 该知识点是否被使用
	 * @param knowledgePoint
	 * @return
	 */
	public Boolean isUsedKnowledgePoint(KnowledgePoint knowledgePoint);
}
