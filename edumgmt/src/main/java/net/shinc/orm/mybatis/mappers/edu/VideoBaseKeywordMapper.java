package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;

/** 
 * @ClassName VideoBaseKeywordMapper 
 * @Description 视频中的关键字
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:55:30  
 */
public interface VideoBaseKeywordMapper {
    int deleteVideoKeywordById(VideoBaseKeywordKey key);

    int insertVideoKeyword(VideoBaseKeywordKey record);
    
    int insertVideoKeywordBatch(List<VideoBaseKeywordKey> record);
}