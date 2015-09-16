package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.RecommendHasVideoBase;
import net.shinc.orm.mybatis.mappers.common.CommonMapper;

/**
 * @ClassName: RecommendMapper
 * @author hushichong
 * @date 2015年9月16日 下午6:01:47
 */
public interface RecommendMapper extends CommonMapper {
	/**
	 * @Title: getRecommendVideoBaseList
	 * @Description: 得到推荐视频列表
	 * @param recommendHasVideoBase
	 * @return List<Map>
	 */
	public List<Map> getRecommendVideoBaseList(RecommendHasVideoBase recommendHasVideoBase);
}