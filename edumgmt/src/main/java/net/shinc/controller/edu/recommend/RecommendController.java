package net.shinc.controller.edu.recommend;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Recommend;
import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;
import net.shinc.service.edu.recommend.RecommendService;

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
 * @ClassName: RecommendController
 * @Description: 推荐控制类
 * @author hushichong
 * @date 2015年9月16日 下午9:53:23
 */
@Controller
@RequestMapping(value = "/recommend")
public class RecommendController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RecommendService recommendService;

	/**
	 * @Title: getRecommendList
	 * @Description: 得推荐列表
	 * @param recommend
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getRecommendList")
	@ResponseBody
	public IRestMessage getRecommendList(Recommend recommend) {
		IRestMessage msg = getRestMessage();
		try {
			List<Recommend> list = recommendService.getRecommendList(recommend);
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

	/**
	 * @Title: getRecommendVideoBaseList
	 * @Description: 得到推荐视频列表
	 * @param recommend
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getRecommendVideoBaseList")
	@ResponseBody
	public IRestMessage getRecommendVideoBaseList(Recommend recommend) {
		IRestMessage msg = getRestMessage();
		try {
			RecommendHasVideoBase recommendHasVideoBase = new RecommendHasVideoBase();
			recommendHasVideoBase.setRecommendId(recommend.getId());
			List list = recommendService.getRecommendVideoBaseList(recommendHasVideoBase);
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

	/**
	 * @Title: addRecommend
	 * @Description: 添加推荐
	 * @param recommend
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addRecommend")
	@ResponseBody
	public IRestMessage addRecommend(@Valid Recommend recommend, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			recommendService.addRecommend(recommend);
			iRestMessage.setCode(ErrorMessage.ADD_SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: getRecommendInfo
	 * @Description: 得到推荐信息
	 * @param id
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getRecommendInfo")
	@ResponseBody
	public IRestMessage getRecommendInfo(@RequestParam(value = "id") Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			Recommend recommend = recommendService.getRecommendById(id);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(recommend);
		} catch (Exception e) {
			logger.error("获得推荐详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: updateRecommend
	 * @Description: 更新推荐信息
	 * @param recommend
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateRecommend")
	@ResponseBody
	public IRestMessage updateRecommend(@Valid Recommend recommend, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			recommendService.updateRecommend(recommend);
			iRestMessage.setCode(ErrorMessage.UPDATE_SUCCESS.getCode());
			iRestMessage.setMessage("修改成功");
		} catch (Exception e) {
			logger.error("更新推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: deleteRecommend
	 * @Description: 删除推荐信息，推荐下有时暂不支持删除
	 * @param recommend
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/deleteRecommend")
	@ResponseBody
	public IRestMessage deleteRecommend(Recommend recommend) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			if (recommendService.isRecommendHasVideo(recommendService.getRecommendById(recommend.getId()))) {
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该推荐下已存在视频暂不支持删除");
				return iRestMessage;
			}
			recommendService.deleteRecommendById(recommend.getId());
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除推荐失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
}
