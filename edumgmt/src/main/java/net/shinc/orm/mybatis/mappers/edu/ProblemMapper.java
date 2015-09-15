package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.Problem;

public interface ProblemMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Problem problem);

    Integer insertSelective(Problem problem);

    Problem selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Problem problem);

    Integer updateByPrimaryKey(Problem problem);
}