package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;

public interface ProblemHasVideoBaseMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(ProblemHasVideoBase problemHasVideoBase);

    Integer insertSelective(ProblemHasVideoBase problemHasVideoBase);

    ProblemHasVideoBase selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(ProblemHasVideoBase problemHasVideoBase);

    Integer updateByPrimaryKey(ProblemHasVideoBase problemHasVideoBase);
}