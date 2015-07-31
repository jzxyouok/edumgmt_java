package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoSelf;

public interface VideoSelfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoSelf record);

    int insertSelective(VideoSelf record);

    VideoSelf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoSelf record);

    int updateByPrimaryKey(VideoSelf record);
}