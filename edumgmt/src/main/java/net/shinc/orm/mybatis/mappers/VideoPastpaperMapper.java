package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoPastpaper;

public interface VideoPastpaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoPastpaper record);

    int insertSelective(VideoPastpaper record);

    VideoPastpaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoPastpaper record);

    int updateByPrimaryKey(VideoPastpaper record);
}