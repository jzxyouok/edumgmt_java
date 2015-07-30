package net.shinc.service.common.impl;

import java.util.Date;
import java.util.List;

import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.orm.mybatis.mappers.common.CompanyMapper;
import net.shinc.service.common.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName CompanyServiceImpl 
 * @Description 企业信息服务接口实现
 * @author guoshijie 
 * @date 2015年7月15日 下午9:00:23
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	public static String pattern = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public PageList<Company> getCompanyList(PageBounds pageBounds) {
		List<Company> list = companyMapper.getCompanyList(pageBounds);
		PageList<Company> pageList = (PageList<Company>)list;
		return pageList;
	}

	@Override
	public Company getCompanyById(Integer id) {
		return companyMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer getCompanyListCount() {
		return companyMapper.getCompanyListCount();
	}

	@Override
	public Integer addCompany(Company company) {
		company.setCreateTime(ShincUtil.formatDate(new Date(), pattern));
		company.setUpdateTime(ShincUtil.formatDate(new Date(), pattern));
		return companyMapper.insert(company);
	}

	@Override
	public Integer updateCompany(Company company) {
		company.setUpdateTime(ShincUtil.formatDate(new Date(), pattern));
		return companyMapper.updateByPrimaryKeySelective(company);
	}

	@Override
	public Integer deleteCompany(Company company) {
		return companyMapper.deleteByPrimaryKey(company.getId());
	}

}
