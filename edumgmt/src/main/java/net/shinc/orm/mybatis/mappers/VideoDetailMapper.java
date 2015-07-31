package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoDetail;

public interface VideoDetailMapper {

    int insert(VideoDetail record);

    int insertSelective(VideoDetail record);

    int updateByPrimaryKeySelective(VideoDetail record);

    int updateByPrimaryKey(VideoDetail record);
}