package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.QuestionHasShTagKey;

public interface QuestionHasShTagMapper {
    int deleteByPrimaryKey(QuestionHasShTagKey key);

    int insert(QuestionHasShTagKey record);

    int insertSelective(QuestionHasShTagKey record);
}