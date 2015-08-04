package net.shinc.orm.mybatis.mappers;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import net.shinc.orm.mybatis.bean.Lecture;

/** 
 * @ClassName LectureMapper 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:52:10  
 */
public interface LectureMapper {
	int deleteLectureById(Integer id);

    Lecture selectLectureById(Integer id);
    
    public List<Lecture> selectAllLecture(PageBounds pb);
    
    int insertLecture(Lecture record);
   
    int updateLectureById(Lecture record);
}