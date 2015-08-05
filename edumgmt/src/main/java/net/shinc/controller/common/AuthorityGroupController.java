package net.shinc.controller.common;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.common.AuthGroupHasAuth;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.orm.mybatis.bean.common.AuthorityGroup;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.service.common.AuthorityGroupService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AuthorityGroupController 
 * @Description 权限组控制层
 * @author guoshijie 
 * @date 2015年7月14日 下午3:32:25
 */
@Controller
@RequestMapping(value = "/authGroup")
public class AuthorityGroupController extends AbstractBaseController{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthorityGroupService authorityGroupService;
	
	/**
	 * 添加权限组
	 * @param authorityGroup
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAuthGroup")
	public IRestMessage addAuthorityGroup(@Valid AuthorityGroup authorityGroup, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			int i = authorityGroupService.addAuthorityGroup(authorityGroup);
			if(i > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(i);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("权限组添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 删除权限组
	 * @param authorityGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAuthPostion")
	public IRestMessage deleteAuthorityGroup(AuthorityGroup authorityGroup) {
		IRestMessage msg = getRestMessage();
		try {
			int i = authorityGroupService.deleteAuthorityGroup(authorityGroup.getId());
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("权限组删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 获取某公司下的所有权限组
	 * @param company
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAuthGroupList")
	public IRestMessage getAuthorityGroupList(Company company) {
		IRestMessage msg = getRestMessage();
		try {
			List<AuthorityGroup> list = authorityGroupService.getAuthorityGroupList(company);
			if(null != list && list.size() > 0) {
				msg.setResult(list);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("权限组列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 根据id获取权限组
	 * @param authorityGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAuthGroupById")
	public IRestMessage getAuthorityGroupById(AuthorityGroup authorityGroup) {
		IRestMessage msg = getRestMessage();
		try {
			AuthorityGroup position = authorityGroupService.getAuthorityGroupById(authorityGroup);
			if(null != position) {
				msg.setResult(position);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("权限组查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 给权限组批量添加权限
	 * @param list
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAuthGroupAuth")
	public IRestMessage addAuthGroupAuth(@RequestBody List<AuthGroupHasAuth> list) {
		IRestMessage msg = getRestMessage();
		try {
			Integer num = authorityGroupService.addAuthGroupHasAuth(list);
			if(num > 0) {
				msg.setResult(num);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} 
		} catch (Exception e) {
			logger.error("权限组查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 获取某权限组所有权限
	 * @param authGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAuthList")
	public IRestMessage getAuthList(AuthorityGroup authGroup) {
		IRestMessage msg = getRestMessage();
		try {
			List<Authority> list = authorityGroupService.getAuthorityList(authGroup);
			if(null != list && list.size() > 0) {
				msg.setResult(list);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("权限组查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
