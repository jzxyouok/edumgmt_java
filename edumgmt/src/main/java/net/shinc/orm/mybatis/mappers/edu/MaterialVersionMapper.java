package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.MaterialVersion;

public interface MaterialVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialVersion record);

    int insertSelective(MaterialVersion record);

    MaterialVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialVersion record);

    int updateByPrimaryKey(MaterialVersion record);
}