package net.shinc.controller.edu.business;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Parter;
import net.shinc.service.edu.business.ParterService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ParterController
 * @Description: 推荐控制类
 * @author hushichong
 * @date 2015年9月16日 下午9:53:23
 */
@Controller
@RequestMapping(value = "/parter")
public class ParterController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ParterService parterService;

	@RequestMapping(value = "/getParterList")
	@ResponseBody
	public IRestMessage getParterList(Parter parter) {
		IRestMessage msg = getRestMessage();
		try {
			List<Parter> list = parterService.getParterList(parter);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("推荐列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}

	@RequestMapping(value = "/getParterVideoBaseList")
	@ResponseBody
	public IRestMessage getParterVideoBaseList(Parter parter) {
		IRestMessage msg = getRestMessage();
		try {
//			ParterGrHasVideoBase parterHasVideoBase = new ParterHasVideoBase();
//			parterHasVideoBase.setParterId(parter.getId());
//			List list = parterService.getParterVideoBaseList(parterHasVideoBase);
//			if (null != list && list.size() > 0) {
//				msg.setCode(ErrorMessage.SUCCESS.getCode());
//				msg.setResult(list);
//			} else {
//				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
//			}
		} catch (Exception e) {
			logger.error("推荐列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}

	@RequestMapping(value = "/addParter")
	@ResponseBody
	public IRestMessage addParter(@Valid Parter parter, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			parterService.addParter(parter);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/getParterInfo")
	@ResponseBody
	public IRestMessage getParterInfo(@RequestParam(value = "id", required = true) Integer id, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Parter parter = parterService.getParterById(id);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(parter);
		} catch (Exception e) {
			logger.error("获得推荐详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/updateParter")
	@ResponseBody
	public IRestMessage updateParterAndRelevantInfo(@Valid Parter parter, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			parterService.updateParter(parter);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("修改成功");
		} catch (Exception e) {
			logger.error("更新推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/deleteParter")
	@ResponseBody
	public IRestMessage deleteParter(Parter parter, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			parter = parterService.getParterById(parter.getId());
			// 推荐下有视频则不能删除
//			if (parter.getType().equals("1")) {// 单视频
//				ParterHasVideoBase parterHasVideoBase = new ParterHasVideoBase();
//				parterHasVideoBase.setParterId(parter.getId());
//				List list = parterService.getParterVideoBaseList(parterHasVideoBase);
//				if (list == null || list.size() == 0) {
//					iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
//					iRestMessage.setMessage("改推荐下已存在视频暂不支持删除");
//					return iRestMessage;
//				}
//			} else if (parter.getType().equals("2")) {// 视频组
//				// 查询关系表有无数据
//				return iRestMessage;
//			}
			parterService.deleteParterById(parter.getId());
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
}
