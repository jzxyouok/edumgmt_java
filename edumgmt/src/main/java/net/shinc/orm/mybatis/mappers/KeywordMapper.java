package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.Keyword;

/** 
 * @ClassName KeywordMapper 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:50:32  
 */
public interface KeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
}