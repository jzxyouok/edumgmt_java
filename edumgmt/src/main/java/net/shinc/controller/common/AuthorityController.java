package net.shinc.controller.common;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.common.Authority;
import net.shinc.service.common.AuthorityService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AuthorityController 
 * @Description 用户权限控制层
 * @author guoshijie 
 * @date 2015年7月29日 下午8:50:23
 */
@Controller
@RequestMapping(value = "/authority")
public class AuthorityController extends AbstractBaseController{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthorityService authorityService;
	
	/**
	 * 添加权限
	 * @param authority
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAuthority")
	public IRestMessage addAuthority(@Valid Authority authority) {
		IRestMessage msg = getRestMessage();
		try {
			int i = authorityService.addAuthority(authority);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("权限添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 更新权限
	 * @param authority
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateAuthority")
	public IRestMessage updateAuthority(@Valid Authority authority) {
		IRestMessage msg = getRestMessage();
		try {
			int i = authorityService.updateAuthority(authority);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("权限更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteAuthority")
	public IRestMessage deleteAuthority(Authority authority) {
		IRestMessage msg = getRestMessage();
		try {
			int i = authorityService.deleteAuthority(authority);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("权限删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 批量添加权限
	 * @param authList
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAuthorityBatch")
	public IRestMessage addAuthorityBatch(@RequestBody List<Authority> authList) {
		IRestMessage msg = getRestMessage();
		try {
			int i = authorityService.addAuthorityBatch(authList);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			}
		} catch (Exception e) {
			logger.error("权限批量添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 获取全量权限列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllAuthorityList")
	public IRestMessage getAllAuthorityList() {
		IRestMessage msg = getRestMessage();
		try {
			List<Authority> list = authorityService.getAllAuthorityList();
			if(null != list && list.size() > 0) {
				msg.setResult(list);
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("权限查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
