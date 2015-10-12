package net.shinc.service.edu.course;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.CourseGrade;
import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;
import net.shinc.orm.mybatis.bean.edu.CourseGrade;

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

	/**
	 * @Title: getCourseGradeBaseList
	 * @Description: 得到课程年级视频列表
	 * @param courseGradeHasVideoBase
	 * @return List<Map>
	 */
	public List<Map> getCourseGradeVideoBaseList(CourseGradeHasVideoBase courseGradeHasVideoBase);

	/**
	 * @Title: isCourseGradeHasVideo
	 * @Description: 该推荐下是否有视频
	 * @param recommend
	 * @return boolean
	 */
	public boolean isHasVideo(CourseGrade courseGrade);

	/**
	 * @Title: updateCourseGradeHasVideoBase
	 * @Description: 更新年级视频关系
	 * @param courseGradeHasVideoBase
	 */
	public void updateCourseGradeHasVideoBase(CourseGradeHasVideoBase courseGradeHasVideoBase);

}
