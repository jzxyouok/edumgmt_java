package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;

public interface CourseGradeHasVideoBaseMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(CourseGradeHasVideoBase courseGradeHasVideoBase);

    Integer insertSelective(CourseGradeHasVideoBase courseGradeHasVideoBase);

    CourseGradeHasVideoBase selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CourseGradeHasVideoBase courseGradeHasVideoBase);

    Integer updateByPrimaryKey(CourseGradeHasVideoBase courseGradeHasVideoBase);
}