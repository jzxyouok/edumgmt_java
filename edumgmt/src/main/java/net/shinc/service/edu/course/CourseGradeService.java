package net.shinc.service.edu.course;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.CourseGrade;
import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;

/**
 * @ClassName: CourseGradeService
 * @Description: 课程年级 服务接口
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
public interface CourseGradeService {

	public Integer addCourseGrade(CourseGrade courseGrade);

	public Integer updateCourseGrade(CourseGrade courseGrade);

	public Integer deleteCourseGradeById(Integer id);

	public CourseGrade getCourseGradeById(Integer id);

	public List<CourseGrade> getCourseGradeList(CourseGrade courseGrade);

	/**
	 * @Title: addCourseGradeVideoBase
	 * @Description: 课程年级--视频关系表添加数据
	 * @param courseGradeHasVideoBase
	 * @return Integer
	 */
	public Integer addCourseGradeVideoBase(CourseGrade courseGrade);

	public Integer deleteCourseGradeVideoBaseById(Integer id);

	public List<CourseGrade> getCourseGradeVideoBaseList(CourseGradeHasVideoBase courseGradeHasVideoBase);

}
