package net.shinc.controller.edu.questionbank;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankYear;
import net.shinc.service.edu.questionbank.QuestionBankYearService;

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
 * @ClassName QuestionBankYearController 
 * @Description 题库与年份对应关系控制层
 * @author guoshijie 
 * @date 2015年8月3日 上午11:06:33
 */
@Controller
@RequestMapping(value = "/questionBankYear")
public class QuestionBankYearController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QuestionBankYearService questionBankYearService;
	
	/**
	 * 添加题库与年份对应关系
	 * @param questionBankYear
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addQuestionBankYear")
	@ResponseBody
	public IRestMessage addQuestionBankYear(@Valid QuestionBankYear questionBankYear, BindingResult bindingResult, Locale locale){
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = questionBankYearService.addQuestionBankYear(questionBankYear);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 批量添加题库与年份对应关系
	 * @param questionBankYear
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addQuestionBankYearBatch")
	@ResponseBody
	public IRestMessage addQuestionBankYearBatch(@RequestBody List<QuestionBankYear> list){
		IRestMessage iRestMessage = getRestMessage();
		try {
			Integer num = questionBankYearService.addQuestionBankYearBatch(list);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系批量添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 删除题库与年份对应关系
	 * @param questionBankYear
	 * @return
	 */
	@RequestMapping(value = "/deleteQuestionBankYearById")
	@ResponseBody
	public IRestMessage deleteQuestionBankYearById(QuestionBankYear questionBankYear){
		IRestMessage iRestMessage = getRestMessage();
		try {
			if(null != questionBankYear){
				Integer num = questionBankYearService.deleteQuestionBankYearById(questionBankYear.getId());
				if(num > 0){
					iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
					iRestMessage.setResult(num);
				} else {
					iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				}
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 更新题库与年份对应关系
	 * @param questionBankYear
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/updateQuestionBankYear")
	@ResponseBody
	public IRestMessage updateQuestionBankYear(@Valid QuestionBankYear questionBankYear, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = questionBankYearService.updateQuestionBankYear(questionBankYear);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getQuestionBankYearById")
	@ResponseBody
	public IRestMessage getQuestionBankYearById(QuestionBankYear questionBankYear) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != questionBankYear) {
				QuestionBankYear question = questionBankYearService.getQuestionBankYearById(questionBankYear.getId());
				if(null != question) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(question);
				} else {
					msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系查询查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 根据题库查年份
	 * @param questionBank
	 * @return
	 */
	@RequestMapping(value = "/getQuestionBankYearByQuestionBank")
	@ResponseBody
	public IRestMessage getQuestionBankYearByQuestionBank(QuestionBank questionBank) {
		IRestMessage msg = getRestMessage();
		try {
			List<QuestionBankYear> list = questionBankYearService.getQuestionBankYearByQuestionBank(questionBank);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库与年份对应关系查询查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
