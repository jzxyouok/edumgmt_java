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
	
	public Lecture dealVideoNum(Lecture lecture){
		lecture.setVideoPointNum(getVideoPointNumByLecture(lecture));
		lecture.setVideoQuestionNum(getVideoQuestionNumByLecture(lecture));
		lecture.setVideoNum(getVideoNumByLecture(lecture));
		return lecture;
	}
	
	
	/**
	 * 删除讲解人
	 */
	@Override
	public Integer deleteLectureById(Integer id) {
		if (null != id) {
			return lectureMapper.deleteLectureById(id);
		}
		return 0;
	}
	
	/**
	 * 按照ID查询讲解人
	 */
	@Override
	public Lecture selectLectureById(Lecture lecture) {
		Lecture lecture2 = lectureMapper.selectLectureById(lecture);
		dealVideoNum(lecture2);
		return lecture2;
	}

	
	/**
	 * 查询全部讲解人
	 */
	@Override
	public PageList<Lecture> selectAllLecture(PageBounds pageBounds) {
		List<Lecture> list = lectureMapper.selectAllLecture(pageBounds);
		PageList<Lecture> pageList = (PageList<Lecture>)dealListVideoNum(list);
		return pageList;
	}
	
	public List<Lecture> dealListVideoNum(List<Lecture> list){
		if(null != list) {
			for (Lecture lecture : list) {
				dealVideoNum(lecture);
			}
			return list;
		}
		return null;
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
	
	@Override
	public Integer getVideoPastpaperNumByLecture(Lecture lecture) {
		if(null != lecture) {
			return lectureMapper.getVideoPastpaperNumByLecture(lecture);
		}
		return 0;
	}

	@Override
	public Integer getVideoSelfNumByLecture(Lecture lecture) {
		if(null != lecture) {
			return lectureMapper.getVideoSelfNumByLecture(lecture);
		}
		return 0;
	}

	@Override
	public Integer getVideoPointNumByLecture(Lecture lecture) {
		if(null != lecture) {
			return lectureMapper.getVideoPointNumByLecture(lecture);
		}
		return 0;
	}

	@Override
	public Integer getVideoQuestionNumByLecture(Lecture lecture) {
		if(null != lecture) {
			int a = getVideoPastpaperNumByLecture(lecture);
			int b = getVideoPointNumByLecture(lecture);
			return a + b;
		}
		return null;
	}

	@Override
	public Integer getVideoNumByLecture(Lecture lecture) {
		if(null != lecture) {
			int a = getVideoQuestionNumByLecture(lecture);
			int b = getVideoPointNumByLecture(lecture);
			return a + b;
		}
		return null;
	}
}
