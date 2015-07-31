package net.shinc.service.edu.video.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPastpaper;
import net.shinc.orm.mybatis.mappers.VideoPastpaperMapper;
import net.shinc.service.edu.video.VideoPastpaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * @ClassName: VideoPastpaperServiceImpl
  * @Description: 真题、模拟题服务接口实现
  * @author hushichong
  * @date 2015年7月31日 下午5:43:01
 */
@Service
public class VideoPastpaperServiceImpl implements VideoPastpaperService {

	@Autowired
	private VideoPastpaperMapper videoPastpaperMapper;
	
	@Override
	public void deleteVideoPastpaperById(Integer id) {
		videoPastpaperMapper.deleteVideoPastpaperById(id);
		
	}

	@Override
	public Integer insertVideoPastpaper(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.insertVideoPastpaper(videoPastpaper);
	}

	@Override
	public void updateVideoPastpaper(VideoPastpaper videoPastpaper) {
		videoPastpaperMapper.updateVideoPastpaper(videoPastpaper);
		
	}

	@Override
	public VideoPastpaper getByVideoPastpaperById(Integer id) {
		return videoPastpaperMapper.getByVideoPastpaperById(id);
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperList(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.getVideoPastpaperList(videoPastpaper);
	}

	@Override
	public Integer getVideoPastpaperListCount(VideoPastpaper videoPastpaper) {
		return videoPastpaperMapper.getVideoPastpaperListCount(videoPastpaper);
	}

	@Override
	public VideoPastpaper getVideoPastpaper(VideoPastpaper videoPastpaper) {
		List list = getVideoPastpaperList(videoPastpaper);
		if(list != null && list.size() == 1){
			return (VideoPastpaper)list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperAndRelevantInfoList(VideoPastpaper videoPastpaper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoPastpaper> getVideoPastpaperAndRelevantInfoListCount(VideoPastpaper videoPastpaper) {
		// TODO Auto-generated method stub
		return null;
	}


}