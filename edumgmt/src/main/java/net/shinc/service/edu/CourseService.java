package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.Course;

/** 
 * @ClassName CourseService 
 * @Description 课程服务接口
 * @author guoshijie 
 * @date 2015年7月31日 下午5:40:26  
 */
public interface CourseService {

	/**
	 * 添加课程
	 * @param Course
	 * @return
	 */
	public Integer addCourse(Course course);
	
	/**
	 * 修改课程
	 * @param Course
	 * @return
	 */
	public Integer updateCourse(Course course);
	
	/**
	 * 删除课程
	 * @param Course
	 * @return
	 */
	public Integer deleteCourseById(Integer id);
	
	/**
	 * 根据id查询课程
	 * @param Course
	 * @return
	 */
	public Course getCourseById(Integer id);
	
	/**
	 * 查询所有课程列表
	 * @return
	 */
	public List<Course> getCourseList();
}
