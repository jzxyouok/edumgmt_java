package net.shinc.service.edu.recommend;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.Recommend;

/**
 * @ClassName: RecommendService
 * @Description: 推荐 服务接口
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
public interface RecommendService {
	public Integer addRecommend(Recommend recommend);

	public Integer updateRecommend(Recommend recommend);

	public Integer deleteRecommendById(Integer id);

	public Recommend getRecommendById(Integer id);

	public List<Recommend> getRecommendList(Recommend recommend);

	/**
	 * @Title: addRecommendVideoBase
	 * @Description: 推荐--视频关系表添加数据
	 * @param recommend
	 * @return Integer
	 */
	public Integer addRecommendVideoBase(Recommend recommend);

	public Integer deleteRecommendVideoBase(Recommend recommend);

	/**
	 * @Title: getRecommendVideoBaseList
	 * @Description: 得到推荐视频列表
	 * @param recommendHasVideoBase
	 * @return List<Map>
	 */
	public List<Map> getRecommendVideoBaseList(Recommend recommend);

	/**
	 * @Title: isRecommendHasVideo
	 * @Description: 该推荐下是否有视频
	 * @param recommend
	 * @return boolean
	 */
	public boolean isRecommendHasVideo(Recommend recommend);

}
