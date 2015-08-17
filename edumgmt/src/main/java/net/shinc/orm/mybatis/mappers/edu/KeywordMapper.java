package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Keyword;

/** 
 * @ClassName KeywordMapper 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:32  
 */
public interface KeywordMapper {
    int deleteKeywordById(Integer id);

    int insertKeyword(Keyword record);
    
    public List<Keyword> selectAllKeyword();

	public List<Keyword> selectKeyword(Keyword keyword);
	
	public Keyword selectKeywordByName(Keyword keyword);

//    int updateByPrimaryKeySelective(Keyword record);

//    int updateByPrimaryKey(Keyword record);
}