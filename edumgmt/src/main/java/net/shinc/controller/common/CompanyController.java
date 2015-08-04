package net.shinc.controller.common;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.service.common.AdminUserService;
import net.shinc.service.common.CompanyService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * @ClassName CompanyController 
 * @Description 企业信息控制层
 * @author guoshijie 
 * @date 2015年7月16日 下午5:37:30
 */
@RequestMapping(value = "/company")
@Controller
public class CompanyController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AdminUserService adminUserService;
	
	@Value("${page.count}")
	private String limit;
	
	/**
	 * 获取企业列表
	 * @param page 当前页码
	 * @return
	 */
	@RequestMapping(value = "/getCompanyList")
	@ResponseBody
	public IRestMessage getCompanyList(@RequestParam(value="page",required = true) int page) {
		IRestMessage msg = getRestMessage();
		try {
			PageBounds pageBounds = new PageBounds(page, Integer.parseInt(limit), Order.formString("id.asc"));
			PageList<Company> companyList = companyService.getCompanyList(pageBounds);
			if(null != companyList && companyList.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(companyList);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("企业信息列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getCompanyById")
	@ResponseBody
	public IRestMessage getCompanyById(Company company) {
		IRestMessage msg = getRestMessage();
		try {
			Company admin = companyService.getCompanyById(company.getId());
			if(null != admin) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(admin);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("企业信息查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/addCompany")
	@ResponseBody
	public IRestMessage addCompany(@Valid Company company, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			int i = companyService.addCompany(company);
			logger.debug("add Company ==>" + i);
			if(i > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("企业信息列表添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	@RequestMapping(value = "/deleteCompany")
	@ResponseBody
	public IRestMessage deleteCompany(Company company) {
		IRestMessage msg = getRestMessage();
		try {
			int i = companyService.deleteCompany(company);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("企业信息删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/updateCompany")
	@ResponseBody
	public IRestMessage updateCompany(@Valid Company company, BindingResult bindingResult) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = companyService.updateCompany(company);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("企业信息更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
