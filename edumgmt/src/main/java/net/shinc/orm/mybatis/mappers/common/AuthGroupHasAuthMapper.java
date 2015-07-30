package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import net.shinc.orm.mybatis.bean.common.AuthGroupHasAuth;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;

public interface AuthGroupHasAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthGroupHasAuth record);

    int insertSelective(AuthGroupHasAuth record);

    AuthGroupHasAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthGroupHasAuth record);

    int updateByPrimaryKey(AuthGroupHasAuth record);
    
    public int insertBatch(List<AuthGroupHasAuth> list);
    
    public List<Authority> getAuthList(AuthorityGroup record);
}