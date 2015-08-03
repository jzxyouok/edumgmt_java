package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.Course;
import net.shinc.service.edu.CourseService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CourseController 
 * @Description 课程控制层
 * @author guoshijie 
 * @date 2015年8月3日 下午5:00:43
 */
@RequestMapping(value = "/course")
@Controller
public class CourseController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CourseService courseService;
	
	/**
	 * 获取课程列表
	 * @return
	 */
	@RequestMapping(value = "/getCourseList")
	@ResponseBody
	public IRestMessage getCourseList() {
		IRestMessage msg = getRestMessage();
		try {
			List<Course> list = courseService.getCourseList();
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("课程列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/getCourseById")
	@ResponseBody
	public IRestMessage getCourseById(Course course) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != course) {
				Course cos = courseService.getCourseById(course.getId());
				if(null != cos) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(cos);
				} else {
					msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("课程查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/addCourse")
	@ResponseBody
	public IRestMessage addCourse(@Valid Course course, BindingResult bindingResult, Locale locale) {
		IRestMessage iRestMessage = getRestMessage();
		if(bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			Boolean hasCourse = courseService.hasCourse(course);
			if(!hasCourse) {
				int i = courseService.addCourse(course);
				if(i > 0) {
					iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
				} else {
					iRestMessage.setCode(ErrorMessage.ADD_FAILED.getCode());
				}
			} else {
				iRestMessage.setCode(ErrorMessage.COURSE_EXIST.getCode());
			}
		} catch (Exception e) {
			logger.error("课程添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return iRestMessage;
	}
	
	@RequestMapping(value = "/deleteCourse")
	@ResponseBody
	public IRestMessage deleteCourse(Course course) {
		IRestMessage msg = getRestMessage();
		try {
			if(null != course) {
				int i = courseService.deleteCourseById(course.getId());
				if(i > 0) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(i);
				} else {
					msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("课程删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/updateCourse")
	@ResponseBody
	public IRestMessage updateCourse(@Valid Course course, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			int i = courseService.updateCourse(course);
			if(i > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(i);
			} else {
				msg.setCode(ErrorMessage.UPDATE_FAILED.getCode());
			}
		} catch (Exception e) {
			logger.error("课程更新失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
