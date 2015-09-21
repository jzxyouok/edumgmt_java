package net.shinc.controller.edu.course;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.CourseGrade;
import net.shinc.orm.mybatis.bean.edu.CourseGradeHasVideoBase;
import net.shinc.service.edu.course.CourseGradeService;

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
 * @ClassName: CourseGradeController
 * @Description: 课程科目控制类
 * @author hushichong
 * @date 2015年9月16日 下午9:53:23
 */
@Controller
@RequestMapping(value = "/courseGrade")
public class CourseGradeController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CourseGradeService courseGradeService;

	/**
	 * @Title: getCourseGradeList
	 * @Description: 得到某课程科目
	 * @param courseGrade
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getCourseGradeList")
	@ResponseBody
	public IRestMessage getCourseGradeList(CourseGrade courseGrade) {
		IRestMessage msg = getRestMessage();
		try {
			List<CourseGrade> list = courseGradeService.getCourseGradeList(courseGrade);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("课程科目列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}

	/**
	 * @Title: getCourseGradeVideoBaseList
	 * @Description: 得到推荐视频列表
	 * @param recommend
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getCourseGradeVideoBaseList")
	@ResponseBody
	public IRestMessage getCourseGradeVideoBaseList(CourseGrade courseGrade) {
		IRestMessage msg = getRestMessage();
		try {
			CourseGradeHasVideoBase courseGradeHasVideoBase = new CourseGradeHasVideoBase();
			courseGradeHasVideoBase.setCourseGradeId(courseGrade.getId());
			List list = courseGradeService.getCourseGradeVideoBaseList(courseGradeHasVideoBase);
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
	 * @Title: addCourseGrade
	 * @Description: 添加课程科目
	 * @param courseGrade
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addCourseGrade")
	@ResponseBody
	public IRestMessage addCourseGrade(@Valid CourseGrade courseGrade, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			courseGradeService.addCourseGrade(courseGrade);
			iRestMessage.setCode(ErrorMessage.ADD_SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加课程科目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: getCourseGradeInfo
	 * @Description: 得到课程科目的详情
	 * @param id
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getCourseGradeInfo")
	@ResponseBody
	public IRestMessage getCourseGradeInfo(@RequestParam(value = "id") Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			CourseGrade courseGrade = courseGradeService.getCourseGradeById(id);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(courseGrade);
		} catch (Exception e) {
			logger.error("获得课程科目详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: updateCourseGrade
	 * @Description: 更新课程科目的信息
	 * @param courseGrade
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateCourseGrade")
	@ResponseBody
	public IRestMessage updateCourseGrade(@Valid CourseGrade courseGrade, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			courseGradeService.updateCourseGrade(courseGrade);
			iRestMessage.setCode(ErrorMessage.UPDATE_SUCCESS.getCode());
			iRestMessage.setMessage("修改成功");
		} catch (Exception e) {
			logger.error("更新课程科目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: deleteCourseGrade
	 * @Description: 删除，有视频则不能删除
	 * @param id
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/deleteCourseGrade")
	@ResponseBody
	public IRestMessage deleteCourseGrade(@RequestParam(value = "id") Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			CourseGrade courseGrade = new CourseGrade();
			courseGrade.setId(id);
			// 课程科目下有视频则不能删除
			if (courseGradeService.isHasVideo(courseGrade)) {
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该课程科目下已有视频存在暂不支持删除");
				return iRestMessage;
			}
			courseGradeService.deleteCourseGradeById(courseGrade.getId());
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除课程科目失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
}
