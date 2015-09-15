package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.CourseGrade;

public interface CourseGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseGrade record);

    int insertSelective(CourseGrade record);

    CourseGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseGrade record);

    int updateByPrimaryKey(CourseGrade record);
}