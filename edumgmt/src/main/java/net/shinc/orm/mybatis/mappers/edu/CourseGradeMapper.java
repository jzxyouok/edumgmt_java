package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Course;
import net.shinc.orm.mybatis.mappers.common.CommonMapper;
/**
  * @ClassName: CourseGradeMapper
  * @Description: 得到课程列表含课程视频数量
  * @author hushichong
  * @date 2015年9月15日 下午9:36:50
 */
public interface CourseGradeMapper extends CommonMapper{
    public List<Course> getCourseList();
}