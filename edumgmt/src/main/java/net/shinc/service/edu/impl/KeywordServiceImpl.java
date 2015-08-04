package net.shinc.service.edu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shinc.orm.mybatis.bean.Keyword;
import net.shinc.orm.mybatis.mappers.KeywordMapper;
import net.shinc.service.edu.KeywordService;

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

	@Override
	public Integer deleteKeywordById(Integer id) {
		if (null != id) {
			return keywordMapper.deleteKeywordById(id);
		}
		return 0;
	}

	@Override
	public Integer insertKeyword(Keyword keyword) {
		return keywordMapper.insertKeyword(keyword);
	}

	@Override
	public List<Keyword> selectAllKeyword() {
		return keywordMapper.selectAllKeyword();
	}

	@Override
	public List<Keyword> selectKeyword(Keyword keyword) {
		return keywordMapper.selectKeyword(keyword);
	}

}
