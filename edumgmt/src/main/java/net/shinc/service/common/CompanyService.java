package net.shinc.service.common;

import net.shinc.orm.mybatis.bean.common.Company;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName CompanyService
 * @Description 企业基本信息服务接口
 * @author guoshijie
 * @date 2015年7月10日 下午4:05:59
 */
public interface CompanyService {

	/**
	 * @Title getCompanyList
	 * @Description 查询所有企业
	 * @return List<Company>
	 */
	public PageList<Company> getCompanyList(PageBounds pageBounds);
	
	/**
	 * 根据id查询企业
	 * @return
	 */
	public Company getCompanyById(Integer id);

	/**
	 * @Title getCompanyListCount
	 * @Description 查询企业总条数
	 * @return Integer
	 */
	public Integer getCompanyListCount();

	/**
	 * @Title addCompany
	 * @Description 新增企业
	 * @param company
	 * @return Integer
	 */
	public Integer addCompany(Company company);

	/**
	 * @Title: updateCompany
	 * @Description: 更新公司信息
	 * @param company
	 *            void
	 */
	public Integer updateCompany(Company company);

	/**
	 * @Title deleteCompanyById
	 * @Description 根据id删除企业
	 * @param id
	 * @return Integer
	 */
	public Integer deleteCompany(Company company);

}
