package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPastpaper;
/**
  * @ClassName: VideoPastpaperService
  * @Description: 真题、模拟题服务接口
  * @author hushichong
  * @date 2015年7月31日 下午5:19:16
 */
public interface VideoPastpaperService {
	
	public void deleteVideoPastpaperById(Integer id);

	public Integer insertVideoPastpaper(VideoPastpaper videoPastpaper);

	public void updateVideoPastpaper(VideoPastpaper videoPastpaper);

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
}