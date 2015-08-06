package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;

/** 
 * @ClassName VideoBaseKeywordService 
 * @Description 视频中的关键字
 * @author wangzhiying 
 * @date 2015年8月4日 下午3:36:27  
 */
public interface VideoBaseKeywordService {
	/**
	 * 删除关键字
	 */
	public Integer deleteVideoKeywordById(VideoBaseKeywordKey key);
	/**
	 * 增加关键字
	 */
	public Integer insertVideoKeyword(VideoBaseKeywordKey key);
	/**
	 * 批量增加关键字
	 */
	public Integer insertVideoKeywordBatch(List<VideoBaseKeywordKey> list);

}
