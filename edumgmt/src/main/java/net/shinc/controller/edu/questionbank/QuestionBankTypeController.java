package net.shinc.controller.edu.questionbank;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankType;
import net.shinc.service.edu.questionbank.QuestionBankTypeService;

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
 * @ClassName QuestionBankTypeController 
 * @Description 题库版本控制层
 * @author guoshijie 
 * @date 2015年8月3日 上午11:06:33
 */
@Controller
@RequestMapping(value = "/questionBankType")
public class QuestionBankTypeController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QuestionBankTypeService questionBankTypeService;
	
	/**
	 * 添加题库版本
	 * @param questionBankType
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addQuestionBankType")
	@ResponseBody
	public IRestMessage addQuestionBankType(@Valid QuestionBankType questionBankType, BindingResult bindingResult, Locale locale){
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = questionBankTypeService.addQuestionBankType(questionBankType);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题库版本添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 批量添加题库版本
	 * @param questionBankType
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/addQuestionBankTypeBatch")
	@ResponseBody
	public IRestMessage addQuestionBankTypeBatch(@RequestBody List<QuestionBankType> list){
		IRestMessage iRestMessage = getRestMessage();
		try {
			Integer num = questionBankTypeService.addQuestionBankTypeBatch(list);
			if(num > 0){
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题库版本批量添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 删除题库版本
	 * @param questionBankType
	 * @return
	 */
	@RequestMapping(value = "/deleteQuestionBankTypeById")
	@ResponseBody
	public IRestMessage deleteQuestionBankTypeById(QuestionBankType questionBankType){
		IRestMessage iRestMessage = getRestMessage();
		try {
			if(null != questionBankType){
				Integer num = questionBankTypeService.deleteQuestionBankTypeById(questionBankType.getId());
				if(num > 0){
					iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
					iRestMessage.setResult(num);
				}
			}
		} catch (Exception e) {
			logger.error("题库版本删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	/**
	 * 更新题库版本
	 * @param questionBankType
	 * @param bindingResult
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/updateQuestionBankType")
	@ResponseBody
	public IRestMessage updateQuestionBankType(@Valid QuestionBankType questionBankType, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = questionBankTypeService.updateQuestionBankType(questionBankType);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
			}
		} catch (Exception e) {
			logger.error("题库版本更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getQuestionBankTypeById")
	@ResponseBody
	public IRestMessage getQuestionBankTypeById(QuestionBankType questionBankType) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != questionBankType) {
				QuestionBankType questionType = questionBankTypeService.getQuestionBankTypeById(questionBankType.getId());
				if(null != questionType) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(questionType);
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库版本查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 根据题库查题库版本
	 * @param questionBank
	 * @return
	 */
	@RequestMapping(value = "/getQuestionBankTypeByQuestionBank")
	@ResponseBody
	public IRestMessage getQuestionBankTypeByQuestionBank(QuestionBank questionBank) {
		IRestMessage msg = getRestMessage();
		try {
			List<QuestionBankType> list = questionBankTypeService.getQuestionBankTypeByQuestionBank(questionBank);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题库版本查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
