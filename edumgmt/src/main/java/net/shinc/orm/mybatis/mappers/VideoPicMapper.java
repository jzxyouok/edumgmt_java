package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPic;

/** 
 * @ClassName VideoPicMapper 
 * @Description 视频截图
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:54:16  
 */
public interface VideoPicMapper {
	public List<VideoPic> selectPicByVideoBaseId(Integer id);
	
	VideoPic selectPicById(Integer id);
	
	int deletePicById(Integer id);
	
	int deletePicBatch(List<VideoPic> record);

    int insertPic(VideoPic record);
    
    int insertPicBatch(List<VideoPic> record);
}