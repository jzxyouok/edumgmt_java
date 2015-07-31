package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.Lecture;

/** 
 * @ClassName LectureMapper 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:52:10  
 */
public interface LectureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    Lecture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);
}