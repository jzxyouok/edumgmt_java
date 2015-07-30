package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;

public interface AuthorityGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthorityGroup record);

    int insertSelective(AuthorityGroup record);

    AuthorityGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthorityGroup record);

    int updateByPrimaryKey(AuthorityGroup record);
    
    public List<AuthorityGroup> selectAllAuthorityGroup(Company company);
    
    public int getAuthorityGroupListCount();
    
}