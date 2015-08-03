package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.Lecture;
import net.shinc.orm.mybatis.mappers.LectureMapper;
import net.shinc.service.edu.LectureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/** 
 * @ClassName LectureServiceImpl 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年8月3日 上午11:58:41  
 */
@Service
public class LectureServiceImpl implements LectureService {
	@Autowired
	private LectureMapper lectureMapper;
	
	/**
	 * 删除讲解人
	 */
	@Override
	public Integer deleteLectureById(Lecture lecture) {
		if (null != lecture) {
			return lectureMapper.deleteLectureById(lecture.getId());
		}
		return 0;
	}
	
	/**
	 * 按照ID查询讲解人
	 */
	@Override
	public Lecture selectLectureById(Integer id) {
		return lectureMapper.selectLectureById(id);
	}

	
	/**
	 * 查询全部讲解人
	 */
	@Override
	public PageList<Lecture> selectAllLecture(PageBounds pageBounds) {
		List<Lecture> list = lectureMapper.selectAllLecture(pageBounds);
		PageList<Lecture> pageList = (PageList<Lecture>)list;
		return pageList;
	}
	
	/**
	  * 新增讲解人
	  */
	@Override
	public Integer insertLecture(Lecture lecture) {
		return lectureMapper.insertLecture(lecture);
	}
	
	/**
	  * 更新讲解人信息
	  */
	@Override
	public Integer updateLectureById(Lecture lecture) {
		return lectureMapper.updateLectureById(lecture);
	}
}
