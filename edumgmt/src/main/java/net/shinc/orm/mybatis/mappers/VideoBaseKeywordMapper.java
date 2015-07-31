package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoBaseKeywordKey;

public interface VideoBaseKeywordMapper {
    int deleteByPrimaryKey(VideoBaseKeywordKey key);

    int insert(VideoBaseKeywordKey record);

    int insertSelective(VideoBaseKeywordKey record);
}