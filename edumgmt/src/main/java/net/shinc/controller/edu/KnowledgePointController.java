package net.shinc.controller.edu;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.Course;
import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.service.edu.KnowledgePointService;
import net.shinc.service.edu.video.VideoBaseKnowledgePointService;

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
 * @ClassName KnowledgePointController 
 * @Description 知识点控制层接口
 * @author guoshijie 
 * @date 2015年8月4日 下午12:32:07
 */
@RequestMapping(value = "/knowledgePoint")
@Controller
public class KnowledgePointController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KnowledgePointService knowledgePointService;
	
	@Autowired
	private VideoBaseKnowledgePointService videoBaseKnowledgePointService;
	
	/**
	 * 查询某课程下的知识点
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/getKnowledgePointListByCourse")
	@ResponseBody
	public IRestMessage getKnowledgePointListByCourse(Course course) {
		IRestMessage msg = getRestMessage();
		try {
			List<KnowledgePoint> list = knowledgePointService.getKnowledgePointListByCourse(course);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("知识点列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 查询某课程下，根据知识点名称模糊匹配知识点列表
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/getKnowledgePointListByName")
	@ResponseBody
	public IRestMessage getKnowledgePointListByName(Course course,String name) {
		IRestMessage msg = getRestMessage();
		try {
			List<KnowledgePoint> list = knowledgePointService.getKnowledgePointListByName(course, name);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("知识点列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	/**
	 * 查询某视频拥有的知识点
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/getKnowledgePointListByVideoBase")
	@ResponseBody
	public IRestMessage getKnowledgePointListByVideoBase(VideoBase videoBase) {
		IRestMessage msg = getRestMessage();
		try {
			List<KnowledgePoint> list = videoBaseKnowledgePointService.getKnowledgePointListByVideo(videoBase);
			if(null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("知识点列表查询失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/addKnowledgePoint")
	@ResponseBody
	public IRestMessage addKnowledgePoint(@Valid KnowledgePoint konwledegPoint, BindingResult bindingResult, Locale locale) {
		IRestMessage msg = getRestMessage();
		if(bindingResult.hasErrors()) {
			msg.setDetail(ShincUtil.getErrorFields(bindingResult));
			return msg;
		}
		try {
			Boolean hasKnowledgePoint = knowledgePointService.hasKnowledgePoint(konwledegPoint);
			if(!hasKnowledgePoint) {
				int i = knowledgePointService.addKnowledgePoint(konwledegPoint);
				if(i > 0) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(i);
				} else {
					msg.setCode(ErrorMessage.ADD_FAILED.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.KNOWLEDGEPOINT_EXIST.getCode());
			}
		} catch (Exception e) {
			logger.error("知识点添加失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
	@RequestMapping(value = "/deleteKnowledgePoint")
	@ResponseBody
	public IRestMessage deleteKnowledgePoint(@RequestParam(value="id",required = true) Integer id) {
		IRestMessage msg = getRestMessage();
		try {
			Boolean b = knowledgePointService.isUsedKnowledgePoint(new KnowledgePoint(id));
			if(!b) {
				int i = knowledgePointService.deleteKnowledgePointById(id);
				if(i > 0) {
					msg.setCode(ErrorMessage.SUCCESS.getCode());
					msg.setResult(i);
				} else {
					msg.setCode(ErrorMessage.DELETE_FAILED.getCode());
				}
			} else {
				msg.setCode(ErrorMessage.KNOWLEDGE_USED.getCode());
			}
		} catch (Exception e) {
			logger.error("知识点删除失败==>" + ExceptionUtils.getStackTrace(e));
		}
		return msg;
	}
	
}
