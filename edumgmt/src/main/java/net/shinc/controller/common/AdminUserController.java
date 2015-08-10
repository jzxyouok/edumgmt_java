package net.shinc.controller.common;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.common.AdminUser;
import net.shinc.orm.mybatis.bean.common.Company;
import net.shinc.service.common.AdminUserService;
import net.shinc.service.common.CompanyService;
import net.shinc.service.common.PasswordEncoderService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AdminUserController 
 * @Description 后台管理用户控制层
 * @author guoshijie 
 * @date 2015年7月29日 下午9:18:49
 */
@Controller
@RequestMapping(value = "/adminUser")
public class AdminUserController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AdminUserService adminUserService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PasswordEncoderService passService;
	
	@Value("${page.count}")
	private String limit;
	
	/**
	 * 新增后台管理用户
	 * @param adminUser
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addAdminUser")
	@ResponseBody
	@Transactional
	public IRestMessage addAdminUser(@Valid AdminUser adminUser, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			AdminUser hasAdmin = adminUserService.getAdminUserByNickName(adminUser.getNickname());
			if(null != hasAdmin) {
				iRestMessage.setCode(ErrorMessage.NICKNAME_EXIST.getCode());
				return iRestMessage;
			}
			
			String password = adminUser.getPassword();
//			adminUser.setPassword(passService.encode(password));
			System.out.println(passService.encode(password));
			
			int id = adminUserService.addAdminUser(adminUser);
			logger.info("add AdminUserId ==>" + adminUser.getId());
			if(id > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(id);
			}
		} catch (Exception e) {
			logger.error("后台管理用户添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 查询管理员用户列表
	 * @param company 公司
	 * @return
	 */
	@RequestMapping(value = "/getAdminUserList")
	@ResponseBody
	public IRestMessage getAdminUserList(Company company) {
		IRestMessage msg = getRestMessage();
		try {
			List<AdminUser> adminUserList = adminUserService.getAdminUserList(company);
			if(null != adminUserList && adminUserList.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(adminUserList);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("后台管理用户列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 根据id查询管理员
	 * @param adminUser
	 * @return
	 */
	@RequestMapping(value = "/getAdminUserById")
	@ResponseBody
	public IRestMessage getAdminUserById(AdminUser adminUser) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != adminUser) {
				AdminUser admin = adminUserService.getAdminUserById(adminUser.getId());
				if(null != admin) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(admin);
				} else {
					msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("后台管理用户查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 根据昵称获取后台用户
	 * @param adminUser
	 * @return
	 */
	@RequestMapping(value = "/getAdminUserByNickName")
	@ResponseBody
	public IRestMessage getAdminUserByNickName(AdminUser adminUser) {
		IRestMessage msg = getRestMessage();
		try {
			AdminUser admin = adminUserService.getAdminUserByNickName(adminUser.getNickname());
			if(null != admin) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(admin);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("后台管理用户查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 删除后台用户
	 * @param adminUser
	 */
	@RequestMapping(value = "/deleteAdminUser")
	@ResponseBody
	public IRestMessage deleteAdminUser(AdminUser adminUser) {
		IRestMessage msg = getRestMessage();
		try {
			int i = adminUserService.deleteAdminUser(adminUser);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("后台管理用户删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 更新后台管理员
	 * @param adminUser
	 * @param bindingResult
	 * @param locale
	 */
	@RequestMapping(value = "/updateAdminUser")
	@ResponseBody
	public IRestMessage updateAdminUser(@Valid AdminUser adminUser, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			logger.info("enabled--->"+ adminUser.isEnabled());
			
//			String password = adminUser.getPassword();
//			adminUser.setPassword(passService.encode(password));
			
			int i = adminUserService.updateAdminUser(adminUser);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("后台管理用户更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 修改密码 by王智颖
	 * @param adminUser
	 * @param newpassword1
	 * @param newpassword2
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public IRestMessage updatePassword(AdminUser adminUser,
			@RequestParam(value = "newpassword1", required = true) String newpassword1,
			@RequestParam(value = "newpassword2", required = true) String newpassword2) {
		IRestMessage msg = getRestMessage();
		try {
			AdminUser admin = adminUserService.getAdminUserById(adminUser.getId());
			
			if (null == adminUser.getPassword() || !admin.getPassword().equals(adminUser.getPassword())) {
				msg.setCode(ErrorMessage.PASSWORD_WRONG.getCode());
				msg.setResult(admin);
			} else {
				if (null != newpassword1 && newpassword1.equals(newpassword2)) {
					admin.setPassword(newpassword1);
					int m = adminUserService.updateAdminUser(admin);
					if (m > 0) {
						msg.setCode(ErrorMessage.SUCCESS.getCode());
						msg.setResult(m);
					} else {
						msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
					}
				}else{
					msg.setCode(ErrorMessage.NEWPASSWORD_WRONG.getCode());
					msg.setResult(newpassword1);
				}
			}
		} catch (Exception e) {
			logger.error("修改密码失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
