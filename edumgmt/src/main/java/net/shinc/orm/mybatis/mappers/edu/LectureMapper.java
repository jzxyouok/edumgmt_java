package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import net.shinc.orm.mybatis.bean.edu.Lecture;

/** 
 * @ClassName LectureMapper 
 * @Description 视频讲解人
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:52:10  
 */
public interface LectureMapper {
	int deleteLectureById(Integer id);

    Lecture selectLectureById(Lecture record);
    /**
     * 分页选出所有讲解人
     * @param pb
     * @return
     */
    public List<Lecture> selectAllLecture(PageBounds pb);
    /**
     * 不分页选出所有讲解人
     * @return
     */
    public List<Lecture> selectAllLecture();
    
    int insertLecture(Lecture record);
   
    int updateLectureById(Lecture record);
    
	int getVideoPastpaperNumByLecture(Lecture record);

	int getVideoSelfNumByLecture(Lecture record);

	int getVideoPointNumByLecture(Lecture record);
}