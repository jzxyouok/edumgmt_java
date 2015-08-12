package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Lecture;
import net.shinc.service.edu.LectureService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/** 
 * @ClassName LectureController 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年8月3日 下午12:29:57  
 */
@Controller
@RequestMapping(value = "/lectureManager")
public class LectureController extends AbstractBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LectureService lectureService;
	
	@Value("${page.count}")
	private String limit;
	
	/**
	 * 删除讲解人
	 */
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteLecture")
	@ResponseBody
	public IRestMessage deleteLectureById(@RequestParam(value="id",required = true) Integer id) {
		IRestMessage msg = getRestMessage();
		try {
			int i = lectureService.deleteLectureById(id);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			}else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("删除讲解人失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 按照ID查询讲解人
	 */
	@RequestMapping(value = "/selectLectureById")
	@ResponseBody
	public IRestMessage selectLectureById(Lecture lecture) {
		IRestMessage msg = getRestMessage();
		try {
			Lecture lecturer = lectureService.selectLectureById(lecture);
			if(null != lecturer) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(lecturer);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人信息查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 	* <p>
	 	* 		<b>信息管理-->讲解人管理</b><br/>
	 	* 		查询讲解人列表
	 	* </p>
	 	*
	 	* <p>
	 	* 		<ul>
	 	* 			<li>id</li>
	 	* 			<li>name 不能为空</li>
	 	* 			<li>level 资格</li>
	 	* 			<li>videoPointNum 知识点视频总数</li>
	 	* 			<li>videoQuestionNum 题目视频总数</li>
	 	* 			<li>videoNum 视频总数</li>
	 	* 			<li>page 当前页码</li>
	 	* 		</ul>
	 	* </p>
	 	*
	 	* <p>
	 	* 		测试返回内容：
	 	* 		<ul>
	 	* 			<li>{
	 	* 		 		"code": "SUCCESS",
	 	* 		 		"message": "交易成功",
	 	* 		 		"detail": null,
	 	* 		 		"result": [{
	 	* 		 			"id": 1,
 	 	* 		 			"name": "mm",
 	 	* 		 			"level": "1",
 	 	* 		 			"videoPointNum": 0,
 	 	* 		 			"videoQuestionNum": 3,
 	 	* 		 			"videoNum": 3
 	 	* 		 		}, {
 	 	* 		 			"id": 2,
 	 	* 		 			"name": "张天才",
 	 	* 		 			"level": "100",
 	 	* 		 			"videoPointNum": 0,
 	 	* 		 			"videoQuestionNum": 0,
 	 	* 		 			"videoNum": 0
 	 	* 		 		}],
 	 	* 		 		"userInfo": null
 	 	* 			</li>
 	 	* 		</ul>
	 	* </p>
	 	*
	 	* <p>
	 	* 		报错信息：
	 	* 		<ul>
	 	* 			<li>RESULT_EMPTY 暂无数据</li>
	 	*		</ul>
	 	* </p>
	 */
	@RequestMapping(value = "/selectAllLecture")
	@ResponseBody
	public IRestMessage selectAllLecture() {
		IRestMessage msg = getRestMessage();
		try {
//			PageBounds pageBounds = new PageBounds(page, Integer.parseInt(limit), Order.formString("id.asc"));
			List<Lecture> list = lectureService.selectAllLecture();
			list = lectureService.dealListVideoNum(list);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/selectLectureForSelect")
	@ResponseBody
	public IRestMessage selectLectureForSelect() {
		IRestMessage msg = getRestMessage();
		try {
			List<Lecture> list = lectureService.selectAllLecture();
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 新增讲解人
	 */
	@RequestMapping(value = "/insertLecture")
	@ResponseBody
	public IRestMessage insertLecture(@Valid Lecture lecture, BindingResult bindingResult) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = lectureService.insertLecture(lecture);
			logger.debug("insert Lecture ==>" + i);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			}else {
				msg.setCode(ErrorMessage.ADD_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人信息列表添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	  * 更新讲解人信息
	  */
	@RequestMapping(value = "/updateLecture")
	@ResponseBody
	public IRestMessage updateLectureById(@Valid Lecture lecture, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = lectureService.updateLectureById(lecture);
			logger.info("udpate --->" + i);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			}else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("讲解人信息更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}

	
}
