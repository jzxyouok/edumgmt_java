package net.shinc.service.edu;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import net.shinc.orm.mybatis.bean.Lecture;

/** 
 * @ClassName LectureService 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年8月3日 上午11:58:08  
 */
public interface LectureService {
	
	/**
	 * 删除讲解人
	 */
	public Integer deleteLectureById(Lecture lecture);
	
	/**
	 * 按照ID查询讲解人
	 */
	 public Lecture selectLectureById(Integer id);
	 
	/**
	 * 查询全部讲解人
	 */
	 public PageList<Lecture> selectAllLecture(PageBounds pageBounds);
	 
	 /**
	  * 新增讲解人
	  */
	 public Integer insertLecture(Lecture lecture);
	 
	 /**
	  * 更新讲解人信息
	  */
	 public Integer updateLectureById(Lecture lecture);
}
