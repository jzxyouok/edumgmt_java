package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.CourseGrade;

public interface CourseGradeMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(CourseGrade courseGrade);

    Integer insertSelective(CourseGrade courseGrade);

    CourseGrade selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(CourseGrade courseGrade);

    Integer updateByPrimaryKey(CourseGrade courseGrade);
}