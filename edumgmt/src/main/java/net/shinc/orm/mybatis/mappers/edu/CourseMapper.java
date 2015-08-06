package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;

/** 
 * @ClassName CourseMapper 
 * @Description 课程
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:02  
 */
public interface CourseMapper {
	
    int deleteCourseById(Integer id);

    int addCourse(Course record);

    Course selectCourseById(Integer id);

    int updateCourse(Course record);
    
    public List<Course> getCourseList();
    
    public List<Course> selectCourse(Course course);

}