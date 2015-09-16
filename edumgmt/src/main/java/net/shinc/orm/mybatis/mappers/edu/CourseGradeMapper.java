package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;
import net.shinc.orm.mybatis.mappers.common.CommonMapper;

/**
 * @ClassName: CourseGradeMapper
 * @author hushichong
 * @date 2015年9月16日 下午6:01:55
 */
public interface CourseGradeMapper extends CommonMapper {
	/**
	 * @Title: getCourseGradeBaseList
	 * @Description: 得到课程年级视频列表
	 * @param courseGradeHasVideoBase
	 * @return List<Map>
	 */
	public List<Map> getCourseGradeVideoBaseList(CourseGradeHasVideoBase courseGradeHasVideoBase);

}