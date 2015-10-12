package net.shinc.controller.edu.business;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;
import net.shinc.service.edu.business.ProblemService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ProblemController
 * @Description: 题目控制类
 * @author hushichong
 * @date 2015年9月16日 下午9:53:23
 */
@Controller
@RequestMapping(value = "/problem")
public class ProblemController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProblemService problemService;

	/**
	 * @Title: getProblemList
	 * @Description: 得题目列表
	 * @param problem
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public IRestMessage getProblemList(Problem problem) {
		IRestMessage msg = getRestMessage();
		try {
			List<Problem> list = problemService.getProblemList(problem);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题目列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}

	/**
	 * @Title: getProblemVideoBaseList
	 * @Description: 得到题目视频列表
	 * @param problem
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getProblemVideoBaseList")
	@ResponseBody
	public IRestMessage getProblemVideoBaseList(Problem problem) {
		IRestMessage msg = getRestMessage();
		try {
			ProblemHasVideoBase problemHasVideoBase = new ProblemHasVideoBase();
			problemHasVideoBase.setProblemId(problem.getId());
			List list = problemService.getProblemVideoBaseList(problemHasVideoBase);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题目列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}


	/**
	 * @Title: addProblemVideoBase
	 * @Description: 添加题目视频
	 * @param problem
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addProblemVideoBase")
	@ResponseBody
	public IRestMessage addProblemVideoBase(Problem problem) {
		IRestMessage iRestMessage = getRestMessage();

		try {
			problemService.addProblemVideoBase(problem);
			iRestMessage.setCode(ErrorMessage.ADD_SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加题目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: deleteProblemVideo
	 * @Description: 删除题目视频
	 * @param problem
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/deleteProblemVideo")
	@ResponseBody
	public IRestMessage deleteProblemVideo(Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			problemService.deleteProblemVideoBaseById(id);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除题目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: deleteProblem
	 * @Description: 删除题目信息，题目下有时暂不支持删除
	 * @param problem
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/deleteProblem")
	@ResponseBody
	public IRestMessage deleteProblem(Problem problem) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			if (problemService.isProblemHasVideo(problemService.getProblemById(problem.getId()))) {
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该题目下已存在视频暂不支持删除");
				return iRestMessage;
			}
			problemService.deleteProblemById(problem.getId());
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除题目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
	
	/**
	 * @Title: addProblem
	 * @Description: 添加题目
	 * @param problem
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addProblem")
	@ResponseBody
	public IRestMessage addProblem(@Valid Problem problem, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			problemService.addProblem(problem);
			iRestMessage.setCode(ErrorMessage.ADD_SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加书失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
	
	/**
	 * @Title: updateProblem
	 * @Description: 更新题目信息
	 * @param problem
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateProblem")
	@ResponseBody
	public IRestMessage updateProblem(@Valid Problem problem, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			problemService.updateProblem(problem);
			iRestMessage.setCode(ErrorMessage.UPDATE_SUCCESS.getCode());
			iRestMessage.setMessage("修改成功");
		} catch (Exception e) {
			logger.error("更新书失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}


}
