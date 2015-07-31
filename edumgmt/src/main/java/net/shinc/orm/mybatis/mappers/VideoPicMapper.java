package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoPic;

/** 
 * @ClassName VideoPicMapper 
 * @Description 视频截图
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:16  
 */
public interface VideoPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoPic record);

    int insertSelective(VideoPic record);

    VideoPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoPic record);

    int updateByPrimaryKey(VideoPic record);
}