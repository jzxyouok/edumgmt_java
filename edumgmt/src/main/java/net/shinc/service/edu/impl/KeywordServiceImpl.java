package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Keyword;
import net.shinc.orm.mybatis.bean.edu.VideoBaseKeywordKey;
import net.shinc.orm.mybatis.mappers.edu.KeywordMapper;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseKeywordMapper;
import net.shinc.service.edu.KeywordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/** 
 * @ClassName KeywordServiceImpl 
 * @Description 关键字
 * @author wangzhiying 
 * @date 2015年8月4日 上午11:45:30  
 */
@Service
public class KeywordServiceImpl implements KeywordService {
	
	@Autowired
	private KeywordMapper keywordMapper;
	
	@Autowired
	private VideoBaseKeywordMapper videoBaseKeywordMapper;
	
	/**
	 * 删除关键字
	 */
	@Override
	public Integer deleteKeywordById(Integer id) {
		if (null != id) {
			return keywordMapper.deleteKeywordById(id);
		}
		return 0;
	}
	
	/**
	 * 新增关键字
	 */
	@Override
	public Integer insertKeyword(Keyword keyword) {
		return keywordMapper.insertKeyword(keyword);
	}
	
	/**
	 * 获取所有关键字
	 */
	@Override
	public List<Keyword> selectAllKeyword() {
		return keywordMapper.selectAllKeyword();
	}
	
	/**
	 * 模糊查询关键字
	 */
	@Override
	public List<Keyword> selectKeyword(Keyword keyword) {
		return keywordMapper.selectKeyword(keyword);
	}

	@Override
	public Boolean hasKeyword(String name) {
		Keyword keyword = keywordMapper.selectKeywordByName(new Keyword(name));
		if(null != keyword) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean isUsed(Integer id) {
		if(null != id && id > 0) {
			List<VideoBaseKeywordKey> list = videoBaseKeywordMapper.selectVideoBaseKeywordByKwId(id);
			if(CollectionUtils.isEmpty(list)) {
				return false; 
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}
