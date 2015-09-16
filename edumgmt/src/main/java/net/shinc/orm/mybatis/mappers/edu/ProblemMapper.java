package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.ProblemHasVideoBase;
import net.shinc.orm.mybatis.mappers.common.CommonMapper;

/**
 * @ClassName: ProblemMapper
 * @author hushichong
 * @date 2015年9月16日 下午6:02:43
 */
public interface ProblemMapper extends CommonMapper {
	/**
	 * @Title: getProblemVideoBaseList
	 * @Description: 得到题视频列表
	 * @param problemHasVideoBase
	 * @return List<Map>
	 */
	public List<Map> getProblemVideoBaseList(ProblemHasVideoBase problemHasVideoBase);
}