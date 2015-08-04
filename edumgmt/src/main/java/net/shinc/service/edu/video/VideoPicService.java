package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPic;

/** 
 * @ClassName VideoPicController 
 * @Description 视频截图
 * @author wangzhiying 
 * @date 2015年8月4日 下午5:48:29  
 */
public interface VideoPicService {
	/**
	 * 一个视频对应多张截图
	 * @param id
	 * @return
	 */
	public List<VideoPic> selectPicByVideoBaseId(Integer id);
	
	public VideoPic selectPicById(Integer id);
	
	public Integer deletePicById(Integer id);
	
	/**
	 * 批量删除截图
	 */
	public Integer deletePicBatch(List<VideoPic> list);

	public Integer insertPic(VideoPic pic);
	
	/**
	 * 批量增加截图
	 */
	public Integer insertPicBatch(List<VideoPic> list);


}
