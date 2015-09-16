package net.shinc.service.edu.recommend.impl;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.Recommend;
import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;
import net.shinc.orm.mybatis.mappers.edu.RecommendHasVideoBaseMapper;
import net.shinc.orm.mybatis.mappers.edu.RecommendMapper;
import net.shinc.service.edu.recommend.RecommendService;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RecommendService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	private RecommendMapper recommendMapper;
	@Autowired
	private RecommendHasVideoBaseMapper recommendHasVideoBaseMapper;
	
	@Override
	public Integer addRecommend(Recommend recommend) {
		return recommendMapper.insert(recommend);
	}

	@Override
	public Integer updateRecommend(Recommend recommend) {
		return recommendMapper.update(recommend);
	}

	@Override
	public Integer deleteRecommendById(Integer id) {
		return recommendMapper.deleteById(id);
	}

	@Override
	public Recommend getRecommendById(Integer id) {
		return recommendMapper.findById(id);
	}

	@Override
	public List<Recommend> getRecommendList(Recommend recommend) {
		return recommendMapper.findAll(recommend);
	}

	@Override
	public Integer addRecommendVideoBase(Recommend recommend) {
		int i = 0;
		if(StringUtils.isNotEmpty(recommend.getVideoBaseIds())){
			for (String videoBaseId : StringUtils.split(recommend.getVideoBaseIds(), ",")) {
				RecommendHasVideoBase r = new RecommendHasVideoBase();
				r.setRecommendId(recommend.getId());
				r.setVideoBaseId(Integer.valueOf(videoBaseId));
				r.setVideoType("1");
				recommendHasVideoBaseMapper.insert(r);
				i++;
			}
		}
		return i;
	}

	@Override
	public Integer deleteRecommendVideoBaseById(Integer id) {
		return recommendHasVideoBaseMapper.deleteById(id);
	}

	@Override
	public List<Map> getRecommendVideoBaseList(RecommendHasVideoBase recommendHasVideoBase){
		return recommendMapper.getRecommendVideoBaseList(recommendHasVideoBase);
	}

}
