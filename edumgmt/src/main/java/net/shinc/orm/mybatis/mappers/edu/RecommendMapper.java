package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.Recommend;

public interface RecommendMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Recommend recommend);

    Integer insertSelective(Recommend recommend);

    Recommend selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Recommend recommend);

    Integer updateByPrimaryKey(Recommend recommend);
}