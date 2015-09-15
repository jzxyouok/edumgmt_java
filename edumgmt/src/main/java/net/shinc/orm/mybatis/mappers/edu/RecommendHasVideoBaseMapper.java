package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;

public interface RecommendHasVideoBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendHasVideoBase record);

    int insertSelective(RecommendHasVideoBase record);

    RecommendHasVideoBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendHasVideoBase record);

    int updateByPrimaryKey(RecommendHasVideoBase record);
}