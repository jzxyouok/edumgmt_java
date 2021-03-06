package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Keyword;

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

	/**
	 * 判断是否已存在该关键字
	 * @param name 关键字内容
	 * @return
	 */
	public Boolean hasKeyword(String name);
	
	/**
	 * 判断该关键字是否已被视频使用
	 * @param id
	 * @return
	 */
	public Boolean isUsed(Integer id);

}
