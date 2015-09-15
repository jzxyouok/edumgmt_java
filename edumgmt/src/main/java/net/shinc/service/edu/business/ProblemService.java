package net.shinc.service.edu.business;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;

/**
 * @ClassName: ProblemService
 * @Description: 书-题 服务接口
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
public interface ProblemService {

	public Integer addProblem(Problem problem);

	public Integer updateProblem(Problem problem);

	public Integer deleteProblemById(Integer id);

	public Problem getProblemById(Integer id);

	public List<Problem> getProblemList(Problem problem);

	/**
	 * @Title: addProblemVideoBase
	 * @Description: 题--视频关系表添加数据
	 * @param problem
	 * @return Integer
	 */
	public Integer addProblemVideoBase(Problem problem);

	public Integer deleteProblemVideoBaseById(Integer id);

	public List<ProblemHasVideoBase> getProblemVideoBaseList(ProblemHasVideoBase problemHasVideoBase);
}
