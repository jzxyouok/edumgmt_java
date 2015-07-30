package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import net.shinc.orm.mybatis.bean.common.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    
    public List<Company> getCompanyList(PageBounds pb);
    
    public int getCompanyListCount();
}