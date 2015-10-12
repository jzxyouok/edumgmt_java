package net.shinc.service.edu.course.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.CourseGrade;
import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;
import net.shinc.orm.mybatis.mappers.edu.CourseGradeHasVideoBaseMapper;
import net.shinc.orm.mybatis.mappers.edu.CourseGradeMapper;
import net.shinc.service.edu.course.CourseGradeService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CourseGradeService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class CourseGradeServiceImpl implements CourseGradeService {

	@Autowired
	private CourseGradeMapper courseGradeMapper;
	@Autowired
	private CourseGradeHasVideoBaseMapper courseGradeHasVideoBaseMapper;

	@Override
	public Integer addCourseGrade(CourseGrade courseGrade) {
		return courseGradeMapper.insert(courseGrade);
	}

	@Override
	public Integer updateCourseGrade(CourseGrade courseGrade) {
		return courseGradeMapper.update(courseGrade);
	}

	@Override
	public Integer deleteCourseGradeById(Integer id) {
		return courseGradeMapper.deleteById(id);
	}

	@Override
	public CourseGrade getCourseGradeById(Integer id) {
		return (CourseGrade)courseGradeMapper.findById(id);
	}

	@Override
	public List<CourseGrade> getCourseGradeList(CourseGrade courseGrade) {
		return courseGradeMapper.findAll(courseGrade);
	}

	@Override
	public Integer addCourseGradeVideoBase(CourseGrade courseGrade) {
		int i = 0;
		if (StringUtils.isNotEmpty(courseGrade.getVideoBaseIds())) {
			for (String videoBaseId : StringUtils.split(courseGrade.getVideoBaseIds(), ",")) {
				CourseGradeHasVideoBase c = new CourseGradeHasVideoBase();
				c.setAddTime(new Date());
				c.setCourseGradeId(courseGrade.getId());
				c.setVideoBaseId(Integer.valueOf(videoBaseId));
				c.setVideoType("1");
				c.setSort(0);
				courseGradeHasVideoBaseMapper.insert(c);
				i++;
			}
		}
		return i;
	}

	@Override
	public Integer deleteCourseGradeVideoBaseById(Integer id) {
		return courseGradeHasVideoBaseMapper.deleteById(id);
	}

	@Override
	public List<Map> getCourseGradeVideoBaseList(CourseGradeHasVideoBase courseGradeHasVideoBase) {
		return courseGradeMapper.getCourseGradeVideoBaseList(courseGradeHasVideoBase);
	}

	@Override
	public boolean isHasVideo(CourseGrade courseGrade) {
		CourseGradeHasVideoBase courseGradeHasVideoBase = new CourseGradeHasVideoBase();
		courseGradeHasVideoBase.setCourseGradeId(courseGrade.getId());
		List list = courseGradeHasVideoBaseMapper.findAll(courseGradeHasVideoBase);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void updateCourseGradeHasVideoBase(CourseGradeHasVideoBase courseGradeHasVideoBase) {
		courseGradeHasVideoBaseMapper.update(courseGradeHasVideoBase);
	}


}
