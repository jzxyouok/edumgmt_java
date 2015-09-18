package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.mappers.edu.CourseMapper;
import net.shinc.service.edu.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName CourseServiceImpl 
 * @Description 课程服务接口实现
 * @author guoshijie 
 * @date 2015年8月3日 下午4:33:32  
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public Integer addCourse(Course course) {
		if(null != course) {
			return courseMapper.addCourse(course);
		}
		return 0;
	}

	@Override
	public Integer updateCourse(Course course) {
		if(null != course) {
			return courseMapper.updateCourse(course);
		}
		return 0;
	}

	@Override
	public Integer deleteCourseById(Integer id) {
		if(null != id) {
			return courseMapper.deleteCourseById(id);
		}
		return 0;
	}

	@Override
	public Course getCourseById(Integer id) {
		if(null != id) {
			return courseMapper.selectCourseById(id);
		}
		return null;
	}

	@Override
	public Boolean hasCourse (Course course) {
		List<Course> list = courseMapper.selectCourse(course);
		if(null != list && list.size() > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<Course> selectCourse(Course course) {
		return courseMapper.selectCourse(course);
	}

	@Override
	public List<Course> getCourse_videoNum(Course course) {
		return courseMapper.getCourse_videoNum();
	}

}
