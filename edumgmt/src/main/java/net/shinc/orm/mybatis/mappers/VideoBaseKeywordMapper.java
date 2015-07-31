package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoBaseKeywordKey;

/** 
 * @ClassName VideoBaseKeywordMapper 
 * @Description 视频中的关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:55:30  
 */
public interface VideoBaseKeywordMapper {
    int deleteByPrimaryKey(VideoBaseKeywordKey key);

    int insert(VideoBaseKeywordKey record);

    int insertSelective(VideoBaseKeywordKey record);
}