package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.bean.edu.MaterialVersion;

public interface MaterialVersionMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(MaterialVersion materialVersion);

    Integer insertSelective(MaterialVersion materialVersion);

    MaterialVersion selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(MaterialVersion materialVersion);

    Integer updateByPrimaryKey(MaterialVersion materialVersion);
}