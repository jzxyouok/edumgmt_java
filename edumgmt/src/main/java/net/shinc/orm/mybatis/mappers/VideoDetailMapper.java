package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoDetail;

/** 
 * @ClassName VideoDetailMapper 
 * @Description 视频详细信息
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:53:32  
 */
public interface VideoDetailMapper {

    int insert(VideoDetail record);

    int insertSelective(VideoDetail record);

    int updateByPrimaryKeySelective(VideoDetail record);

    int updateByPrimaryKey(VideoDetail record);
}