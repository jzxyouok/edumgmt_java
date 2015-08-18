package net.shinc.service.edu.video;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoPastpaper;

import org.apache.ibatis.session.RowBounds;

/**
 * @ClassName: VideoPastpaperService
 * @Description: 真题、模拟题服务接口
 * @author hushichong
 * @date 2015年7月31日 下午5:19:16
 */
public interface VideoPastpaperService {

	public void deleteVideoPastpaperById(Integer id);

	/**
	 * @Title: insertVideoPastpaper
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoPastpaper
	 * @return Map
	 */
	public Map insertVideoPastpaper(VideoPastpaper videoPastpaper);

	/**
	 * @Title: updateVideoPastpaper
	 * @Description: 返回Map key = videoBaseId value = 基础信息id
	 * @param videoPastpaper
	 * @return Map
	 */
	public Map updateVideoPastpaper(VideoPastpaper videoPastpaper);

	public VideoPastpaper getByVideoPastpaperById(Integer id);

	public List<VideoPastpaper> getVideoPastpaperList(VideoPastpaper videoPastpaper);

	public Integer getVideoPastpaperListCount(VideoPastpaper videoPastpaper);

	/**
	 * @Title: getVideoPastpaper
	 * @Description: 根据对象参数得到单个实例
	 * @param videoPastpaper
	 * @return videoPastpaper
	 */
	public VideoPastpaper getVideoPastpaper(VideoPastpaper videoPastpaper);

	/**
	 * @param videoPastpaper
	 * @param rowBounds
	 * @return 分页得到真题模拟题列表信息
	 */
	public List<Map> getVideoPastpaperAndRelevantInfoList(QueryBean queryBean, RowBounds rowBounds);

}