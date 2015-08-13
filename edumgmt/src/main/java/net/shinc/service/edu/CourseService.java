package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;

/** 
 * @ClassName CourseService 
 * @Description 课程服务接口
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface CourseService {

	public Integer addCourse(Course course);
	
	public Integer updateCourse(Course course);
	
	public Integer deleteCourseById(Integer id);
	
	public Course getCourseById(Integer id);
	/**
	 * 有无课程
	 * @param course
	 * @return
	 */
	public Boolean hasCourse(Course course);
	
	public List<Course> selectCourse(Course course);
}
