package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.TreeNode;

/**
 * @ClassName KnowledgePointService 
 * @Description 知识点服务接口
 * @author guoshijie 
 * @date 2015年8月4日 上午11:24:40
 */
public interface KnowledgePointService {

	public Integer addKnowledgePoint(KnowledgePoint knowledgePoint);
	/**
	* @Title: addKnowledgePointBaseVideo
	* @Description: 插入知识点和视频关系
	* @param ids
	* @param videoBaseId  void
	 */
	
	public Integer updateKnowledgePoint(KnowledgePoint knowledgePoint);
	
	public Integer deleteKnowledgePointById(Integer id);
	
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
	
	/**
	 * 递归知识点树结构列表
	 * @Title: getKnowledgePointListTree
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param parentId
	 * @return List<KnowledgePoint>
	 */
	List<TreeNode<KnowledgePoint>> getKnowledgePointListTree(Integer courseId);
	
	
	List<KnowledgePoint> selectCatPointByPId(Integer pid);
	
	
}
