package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.Lecture;

public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);
}