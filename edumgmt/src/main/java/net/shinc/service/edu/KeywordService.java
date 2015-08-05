package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.Keyword;

/** 
 * @ClassName KeywordService 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年8月4日 上午11:05:02  
 */
public interface KeywordService {
	/**
	 * 删除关键字
	 */	
	public Integer deleteKeywordById(Integer id);
	/**
	 * 新增关键字
	 */	
	public Integer insertKeyword(Keyword keyword);
	/**
	 * 获取所有关键字
	 */	
	public List<Keyword> selectAllKeyword();
	/**
	 * 模糊查询关键字
	 */	
	public List<Keyword> selectKeyword(Keyword keyword);

}
