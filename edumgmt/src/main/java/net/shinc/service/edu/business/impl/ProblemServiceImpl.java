package net.shinc.service.edu.business.impl;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;
import net.shinc.orm.mybatis.mappers.edu.ProblemHasVideoBaseMapper;
import net.shinc.orm.mybatis.mappers.edu.ProblemMapper;
import net.shinc.service.edu.business.ProblemService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ProblemService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class ProblemServiceImpl implements ProblemService {
	
	@Autowired
	private ProblemMapper problemMapper;
	@Autowired
	private ProblemHasVideoBaseMapper problemHasVideoBaseMapper;

	@Override
	public Integer addProblem(Problem problem) {
		return problemMapper.insert(problem);
	}

	@Override
	public Integer updateProblem(Problem problem) {
		return problemMapper.update(problem);
	}

	@Override
	public Integer deleteProblemById(Integer id) {
		return problemMapper.deleteById(id);
	}

	@Override
	public Problem getProblemById(Integer id) {
		return problemMapper.findById(id);
	}

	@Override
	public List<Problem> getProblemList(Problem problem) {
		return problemMapper.findAll(problem);
	}

	@Override
	public Integer addProblemVideoBase(Problem problem) {
		int i = 0;
		if(StringUtils.isNotEmpty(problem.getVideoBaseIds())){
			for (String videoBaseId : StringUtils.split(problem.getVideoBaseIds(), ",")) {
				ProblemHasVideoBase p = new ProblemHasVideoBase();
				p.setProblemId(problem.getId());
				p.setVideoBaseId(Integer.valueOf(videoBaseId));
				p.setVideoType("1");
				problemHasVideoBaseMapper.insert(p);
				i++;
			}
		}
		return i;
	}
	
	@Override
	public Integer deleteProblemVideoBaseById(Integer id) {
		return problemHasVideoBaseMapper.deleteById(id);
	}

	@Override
	public List<Map> getProblemVideoBaseList(ProblemHasVideoBase problemHasVideoBase) {
		return problemMapper.getProblemVideoBaseList(problemHasVideoBase);
	}


}
