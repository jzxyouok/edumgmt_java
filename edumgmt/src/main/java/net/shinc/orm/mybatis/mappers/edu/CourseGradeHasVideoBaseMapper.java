package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;

public interface CourseGradeHasVideoBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseGradeHasVideoBase record);

    int insertSelective(CourseGradeHasVideoBase record);

    CourseGradeHasVideoBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseGradeHasVideoBase record);

    int updateByPrimaryKey(CourseGradeHasVideoBase record);
}