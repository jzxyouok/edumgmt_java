package net.shinc.service.edu.questionbank.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.Course;
import net.shinc.orm.mybatis.bean.QuestionBank;
import net.shinc.orm.mybatis.bean.QuestionBankCourseKey;
import net.shinc.orm.mybatis.mappers.QuestionBankCourseMapper;
import net.shinc.service.edu.questionbank.QuestionBankCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName QuestionBankServiceImpl 
 * @Description 题库与科目对应关系服务接口实现
 * @author guoshijie 
 * @date 2015年7月31日 下午5:42:27  
 */
@Service
public class QuestionBankCourseServiceImpl implements QuestionBankCourseService {

	@Autowired
	private QuestionBankCourseMapper questionBankCourseMapper;

	@Override
	public Integer addQuestionBankCourse(QuestionBankCourseKey questionBankCourseKey) {
		if(null != questionBankCourseKey) {
			return questionBankCourseMapper.insertSelective(questionBankCourseKey);
		}
		return 0;
	}

	@Override
	public Integer deleteQuestionBankCourseById(QuestionBankCourseKey questionBankCourseKey) {
		if(null != questionBankCourseKey) {
			return questionBankCourseMapper.deleteById(questionBankCourseKey);
		}
		return 0;
	}

	@Override
	public Boolean hasQuestionBankCourseKey(QuestionBankCourseKey questionBankCourseKey) {
		if(null != questionBankCourseKey) {
			QuestionBankCourseKey key = questionBankCourseMapper.selectQuestionBankCourse(questionBankCourseKey);
			if(null != key) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Course> getCourseListByQuestionBank(QuestionBank questionBank) {
		if(null != questionBank) {
			return questionBankCourseMapper.getCourseListByQuestionBank(questionBank);
		}
		return null;
	}

}
