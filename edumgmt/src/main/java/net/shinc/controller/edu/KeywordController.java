package net.shinc.controller.edu;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Keyword;
import net.shinc.service.edu.KeywordService;

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
 * @ClassName KeywordController 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年8月4日 上午11:45:43  
 */
@Controller
@RequestMapping(value = "/keywordManager")
public class KeywordController extends AbstractBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KeywordService keywordService;
	
	/**
	 * 删除关键字
	 */
	@RequestMapping(value = "/deleteKeyword")
	@ResponseBody
	public IRestMessage deleteKeywordById(@RequestParam(value="id",required = true) Integer id) {
		IRestMessage msg = getRestMessage();
		try {
			Boolean b = keywordService.isUsed(id);
			if(b) {
				msg.setCode(ErrorMessage.KEYWORD_ISUSED.getCode());
				return msg;
			}
			int i = keywordService.deleteKeywordById(id);
			if(i > 0) {
				msg.setCode(ErrorMessage.DELETE_SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("删除关键字失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 新增关键字
	 */
	@RequestMapping(value = "/insertKeyword")
	@ResponseBody
	public IRestMessage insertKeyword(@Valid Keyword keyword, BindingResult bindingResult) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			Boolean hasKeyword = keywordService.hasKeyword(keyword.getName());
			if(hasKeyword) {
				msg.setCode(ErrorMessage.KEYWORD_EXIST.getCode());
				return msg;
			} else {
				int i = keywordService.insertKeyword(keyword);
				logger.debug("insert Keyword ==>" + i);
				if(i > 0) {
					msg.setCode(ErrorMessage.ADD_SUCCESS.getCode());
					msg.setResult(i);
				}else {
					msg.setCode(ErrorMessage.ADD_FAILED.getCode());
				}
			}
		} catch (Exception e) {
			logger.error("关键字信息列表添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 获取所有关键字
	 */
	@RequestMapping(value = "/selectAllKeyword")
	@ResponseBody
	public IRestMessage selectAllKeyword() {
		IRestMessage msg = getRestMessage();
		try {
			List<Keyword> keyword = keywordService.selectAllKeyword();
			if(null != keyword && keyword.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(keyword);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("关键字列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 模糊查询关键字
	 */
	@RequestMapping(value = "/selectKeyword")
	@ResponseBody
	public IRestMessage selectKeyword(Keyword keyword) {
		IRestMessage msg = getRestMessage();
		try {
			List<Keyword> list = keywordService.selectKeyword(keyword);
			if(null != list) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人信息查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

}
