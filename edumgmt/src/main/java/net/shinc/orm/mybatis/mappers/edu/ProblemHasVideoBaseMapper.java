package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;

public interface ProblemHasVideoBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemHasVideoBase record);

    int insertSelective(ProblemHasVideoBase record);

    ProblemHasVideoBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemHasVideoBase record);

    int updateByPrimaryKey(ProblemHasVideoBase record);
}