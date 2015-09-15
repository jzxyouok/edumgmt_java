package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.Parter;

public interface ParterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parter record);

    int insertSelective(Parter record);

    Parter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parter record);

    int updateByPrimaryKey(Parter record);
}