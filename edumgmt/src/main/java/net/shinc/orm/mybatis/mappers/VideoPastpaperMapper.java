package net.shinc.orm.mybatis.mappers;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPastpaper;
/**
  * @ClassName: VideoPastpaperMapper
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
}