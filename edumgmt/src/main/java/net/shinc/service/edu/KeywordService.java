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
	
	public Integer deleteKeywordById(Integer id);
	
	public Integer insertKeyword(Keyword keyword);
	
	public List<Keyword> selectAllKeyword();
	
	public List<Keyword> selectKeyword(Keyword keyword);

}
