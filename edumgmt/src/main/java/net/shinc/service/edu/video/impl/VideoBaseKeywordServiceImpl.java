package net.shinc.service.edu.video.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseKeywordMapper;
import net.shinc.service.edu.video.VideoBaseKeywordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @ClassName VideoBaseKeywordServiceImpl 
 * @Description 视频中的关键字
 * @author wangzhiying 
 * @date 2015年8月4日 下午3:36:46  
 */
@Service
public class VideoBaseKeywordServiceImpl implements VideoBaseKeywordService {
	@Autowired
	private VideoBaseKeywordMapper videoBaseKeywordMapper;

	/**
	 * 删除关键字
	 */
	@Override
	public Integer deleteVideoKeywordById(VideoBaseKeywordKey key) {
		if (null != key) {
		return videoBaseKeywordMapper.deleteVideoKeywordById(key);
		}
		return 0;
	}

	/**
	 * 增加关键字
	 */
	@Override
	public Integer insertVideoKeyword(VideoBaseKeywordKey key) {
		if(null != key){
		return videoBaseKeywordMapper.insertVideoKeyword(key);
		}
		return 0;
	}
	/**
	 * 批量增加关键字
	 */
	@Override
	public Integer insertVideoKeywordBatch(List<VideoBaseKeywordKey> list) {
		if(null != list && list.size() > 0) {
			return videoBaseKeywordMapper.insertVideoKeywordBatch(list);
		}
		return 0;
	}

}
