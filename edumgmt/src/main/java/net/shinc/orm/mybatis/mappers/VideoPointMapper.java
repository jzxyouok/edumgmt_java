package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoPoint;

public interface VideoPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoPoint record);

    int insertSelective(VideoPoint record);

    VideoPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoPoint record);

    int updateByPrimaryKey(VideoPoint record);
}