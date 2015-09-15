package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.Parter;

public interface ParterMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Parter parter);

    Integer insertSelective(Parter parter);

    Parter selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Parter parter);

    Integer updateByPrimaryKey(Parter parter);
}