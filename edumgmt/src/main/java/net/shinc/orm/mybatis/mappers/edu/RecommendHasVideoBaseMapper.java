package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;

public interface RecommendHasVideoBaseMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(RecommendHasVideoBase recommendHasVideoBase);

    Integer insertSelective(RecommendHasVideoBase recommendHasVideoBase);

    RecommendHasVideoBase selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(RecommendHasVideoBase recommendHasVideoBase);

    Integer updateByPrimaryKey(RecommendHasVideoBase recommendHasVideoBase);
}