package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.QuestionType;
import net.shinc.orm.mybatis.bean.edu.VideoPastpaper;
import net.shinc.orm.mybatis.bean.edu.VideoSelf;
import net.shinc.service.edu.QuestionTypeService;
import net.shinc.service.edu.video.VideoPastpaperService;
import net.shinc.service.edu.video.VideoSelfService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@Autowired
	private VideoPastpaperService videoPastpaperService;

	@Autowired
	private VideoSelfService videoSelfService;
	
	
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
	
	@RequestMapping(value = "/addQuestionType")
	@ResponseBody
	public IRestMessage addQuestionType(@Valid QuestionType questionType, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Integer num = questionTypeService.addQuestionType(questionType);
			if (num > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题型题库关系添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}

	@RequestMapping(value = "/deleteQuestionType")
	@ResponseBody
	public IRestMessage deleteQuestionType(QuestionType questionType) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			VideoPastpaper videoPastpaper = new VideoPastpaper();
			videoPastpaper.setQuestionTypeId(questionType.getId());
			List list = videoPastpaperService.getVideoPastpaperList(videoPastpaper);
			if(list != null && list.size() > 0){
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该题型已包含真题、模拟题，暂不支持删除");
				return iRestMessage;
				
			}
			VideoSelf videoSelf = new VideoSelf();
			videoSelf.setQuestionTypeId(questionType.getId());
			list = videoPastpaperService.getVideoPastpaperList(videoPastpaper);
			if(list != null && list.size() > 0){
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该题型已包自编题，暂不支持删除");
				return iRestMessage;
			}
			Integer num = questionTypeService.deleteQuestionType(questionType);
			if (num > 0) {
				iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				iRestMessage.setResult(num);
			} else {
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("题型题库关系删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	

}
