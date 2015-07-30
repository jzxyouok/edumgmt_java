package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    public List<Authority> getAuthorityList();
    
    public int addAuthorityBatch(List<Authority> list);
    
}