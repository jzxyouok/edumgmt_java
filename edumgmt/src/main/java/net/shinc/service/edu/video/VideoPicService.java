package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoPic;

/** 
 * @ClassName VideoPicController 
 * @Description 视频截图
 * @author wangzhiying 
 * @date 2015年8月4日 下午5:48:29  
 */
public interface VideoPicService {
	/**
	 * 按照VideoBaseId选择截图（可能一个视频对应多张截图）
	 */
	public List<VideoPic> selectPicByVideoBaseId(Integer id, String domain, long expires);
	/**
	 * 按照Id选择截图
	 */	
	public VideoPic selectPicById(Integer id);
	/**
	 * 删除单张截图
	 */	
	public Integer deletePicById(Integer id);
	/**
	 * 批量删除截图
	 */
	public Integer deletePicBatch(List<VideoPic> list);
	/**
	 * 增加单张截图
	 */
	public Integer insertPic(VideoPic pic);
	/**
	 * 批量增加截图
	 */
	public Integer insertPicBatch(List<VideoPic> list);
	
	/**
	 * 重组视频截图list中的store_info列表
	 * @param list
	 * @return
	 */
	public List<String> dealVideoPicStoreInfo(List<VideoPic> list);


}
