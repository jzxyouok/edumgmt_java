package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoPic;

public interface VideoPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoPic record);

    int insertSelective(VideoPic record);

    VideoPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoPic record);

    int updateByPrimaryKey(VideoPic record);
}