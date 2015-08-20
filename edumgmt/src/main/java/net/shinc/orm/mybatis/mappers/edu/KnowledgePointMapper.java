package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.KnowledgePoint;
import net.shinc.orm.mybatis.bean.edu.TreeNode;

/** 
 * @ClassName KnowledgePointMapper 
 * @Description 知识点
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:51:19  
 */
public interface KnowledgePointMapper {
	
    int deleteKnowledgePointById(Integer id);

    int addKnowledgePoint(KnowledgePoint record);

    KnowledgePoint selectKnowledgePointById(Integer id);

    int updateKnowledgePoint(KnowledgePoint record);
    
    KnowledgePoint hasKnowledgePoint(KnowledgePoint record);
    
    List<KnowledgePoint> getKnowledgePointList(KnowledgePoint record);

	/**
	 * @Title: getKnowledgePointListTree
	 * @Description: 知识点树结构列表
	 * @return List<TreeNode<KnowledgePoint>>
	 */
    public List<TreeNode<KnowledgePoint>> getKnowledgePointListTree();
    

}