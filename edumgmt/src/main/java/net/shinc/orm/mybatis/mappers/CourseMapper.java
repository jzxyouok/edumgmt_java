package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.Course;

/** 
 * @ClassName CourseMapper 
 * @Description 课程
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:02  
 */
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}