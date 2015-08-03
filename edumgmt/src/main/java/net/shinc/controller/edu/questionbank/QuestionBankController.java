package net.shinc.controller.edu.questionbank;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.service.edu.questionbank.QuestionBankService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName QuestionBankController 
 * @Description 题库控制层
 * @author guoshijie 
 * @date 2015年8月3日 上午11:06:33
 */
@Controller
@RequestMapping(value = "/questionBank")
public class QuestionBankController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QuestionBankService questionBankService;
	
	/**
	 * 添加题库
	 * @param questionBank
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addQuestionBank")
	@ResponseBody
	public IRestMessage addQuestionBank(@Valid QuestionBank questionBank, BindingResult bindingResult, Locale locale){
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = questionBankService.addQuestionBank(questionBank);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			}
		} catch (Exception e) {
			logger.error("题库添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 删除题库
	 * @param questionBank
	 * @return
	 */
	@RequestMapping(value = "/deleteQuestionBankById")
	@ResponseBody
	public IRestMessage deleteQuestionBankById(QuestionBank questionBank){
		IRestMessage iRestMessage = getRestMessage();
		try {
			if(null != questionBank){
				Integer num = questionBankService.deleteQuestionBankById(questionBank.getId());
				if(num > 0){
					iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
					iRestMessage.setResult(num);
				}
			}
		} catch (Exception e) {
			logger.error("题库删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	@RequestMapping(value = "/updateQuestionBank")
	@ResponseBody
	public IRestMessage updateQuestionBank(@Valid QuestionBank questionBank, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = questionBankService.updateQuestionBank(questionBank);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			}
		} catch (Exception e) {
			logger.error("题库更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getQuestionBankById")
	@ResponseBody
	public IRestMessage getQuestionBankById(QuestionBank questionBank) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != questionBank) {
				QuestionBank question = questionBankService.getQuestionBankById(questionBank.getId());
				if(null != question) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(question);
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库查询查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getQuestionBankList")
	@ResponseBody
	public IRestMessage getQuestionBankList() {
		IRestMessage msg = getRestMessage();
		try {
			List<QuestionBank> list = questionBankService.getQuestionBankList();
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			}else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库列表查询查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
}
