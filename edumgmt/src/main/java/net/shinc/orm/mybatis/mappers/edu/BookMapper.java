package net.shinc.orm.mybatis.mappers.edu;

import net.shinc.orm.mybatis.mappers.common.CommonMapper;

public interface BookMapper extends CommonMapper{
	/**
	 * 检查当前书所有题目总数是否已到最大限制
	 * @param bookId
	 * @return 1=是，0=否
	 */
	public Integer checkMaxProblem(Long bookId);
}