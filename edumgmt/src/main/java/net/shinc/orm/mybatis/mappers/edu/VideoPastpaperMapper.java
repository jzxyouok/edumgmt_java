package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoPastpaper;

import org.apache.ibatis.session.RowBounds;
/**
  * @ClassName: VideoPastpaperMapper
  * @Description: 真题、模拟题DAO接口
  * @author hushichong
  * @date 2015年7月31日 下午4:43:13
 */
public interface VideoPastpaperMapper {
	
	public void deleteVideoPastpaperById(Integer id);

	public Integer insertVideoPastpaper(VideoPastpaper videoPastpaper);

	public void updateVideoPastpaper(VideoPastpaper videoPastpaper);

	public VideoPastpaper getByVideoPastpaperById(Integer id);

	public List<VideoPastpaper> getVideoPastpaperList(VideoPastpaper videoPastpaper);

	public Integer getVideoPastpaperListCount(VideoPastpaper videoPastpaper);
	
	
	/**
	 * 分页得到真题模拟题列表信息
	 * @param videoPastpaper
	 * @param rowBounds
	 * @return 
	 */
	public List<Map> getVideoPastpaperAndRelevantInfoList(QueryBean queryBean,RowBounds rowBounds);
	
	/**
	 * @Title: getVideoPastpaperAndRelevantInfoListCount
	 * @Description: 得到真题、模拟题以及其相关信息列表总条数
	 * @param videoPastpaper
	 * @return List<VideoPastpaper>
	 */
	public List<VideoPastpaper> getVideoPastpaperAndRelevantInfoListCount(VideoPastpaper videoPastpaper);
}