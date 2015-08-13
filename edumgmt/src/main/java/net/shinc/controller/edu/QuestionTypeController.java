package net.shinc.controller.edu;

import java.util.List;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.orm.mybatis.bean.edu.QuestionType;
import net.shinc.service.edu.QuestionTypeService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
  * @ClassName: QuestionTypeController
  * @Description: 题型Controller
  * @author hushichong
  * @date 2015年8月13日 下午3:10:33
 */
@Controller
@RequestMapping(value = "/questionType")
public class QuestionTypeController extends AbstractBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private QuestionTypeService questionTypeService;
	
	
	/**
	 * 获取所有题型
	 */
	@RequestMapping(value = "/getQuestionTypeList")
	@ResponseBody
	public IRestMessage getQuestionTypeList() {
		IRestMessage msg = getRestMessage();
		try {
			List questionTypeList = questionTypeService.getQuestionTypeList(new QuestionType());
			if(null != questionTypeList && questionTypeList.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(questionTypeList);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("题型列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	

}
