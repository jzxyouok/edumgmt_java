package net.shinc.service.edu;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import net.shinc.orm.mybatis.bean.edu.Lecture;

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
	public Integer deleteLectureById(Integer id);
	
	/**
	 * 按照ID查询讲解人
	 */
	 public Lecture selectLectureById(Lecture lecture);
	 
	/**
	 * 分页查询全部讲解人
	 */
	 public PageList<Lecture> selectAllLecture(PageBounds pageBounds);
	 
	 /**
		 * 不分页查询全部讲解人
		 */
	 public List<Lecture> selectAllLecture();
	 
	 /**
	  * 新增讲解人
	  */
	 public Integer insertLecture(Lecture lecture);
	 
	 /**
	  * 更新讲解人信息
	  */
	 public Integer updateLectureById(Lecture lecture);
	 
	/**
	 * 根据讲解人，获取真题模拟题视频总数
	 * @param lecture
	 * @return
	 */
	public Integer getVideoPastpaperNumByLecture(Lecture lecture);
	
	/**
	 * 根据讲解人，获取自编题视频总数
	 * @param lecture
	 * @return
	 */
	public Integer getVideoSelfNumByLecture(Lecture lecture);
	
	/**
	 * 根据讲解人，获取知识点视频总数
	 * @param lecture
	 * @return
	 */
	public Integer getVideoPointNumByLecture(Lecture lecture);
	
	/**
	 * 根据讲解人，获取题目视频总数
	 * <p>真题模拟题视频总数 + 自编题视频总数</p>
	 * @param lecture
	 * @return
	 */
	public Integer getVideoQuestionNumByLecture(Lecture lecture);
	
	/**
	 * 根据讲解人，获取视频总数
	 * <p>真题模拟题视频总数 + 自编题视频总数 + 知识点视频总数</p>
	 * @param lecture
	 * @return
	 */
	public Integer getVideoNumByLecture(Lecture lecture);
}
