package net.shinc.service.edu.video.impl;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseMapper;
import net.shinc.service.common.QNService;
import net.shinc.service.edu.video.VideoBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
  * @ClassName: VideoBaseServiceImpl
  * @Description: 视频公共基础信息服务接口实现类
  * @author hushichong
  * @date 2015年7月31日 下午5:30:18
 */
@Service
public class VideoBaseServiceImpl implements VideoBaseService {

	@Autowired
	private VideoBaseMapper videoBaseMapper;
	
	@Autowired
	private QNService qnService;
	
	@Override
	public void deleteVideoBaseById(Integer id) {
		videoBaseMapper.deleteVideoBaseById(id);
		
	}

	@Override
	public Integer insertVideoBase(VideoBase videoBase) {
		return videoBaseMapper.insertVideoBase(videoBase);
	}

	@Override
	public void updateVideoBase(VideoBase videoBase) {
		videoBaseMapper.updateVideoBase(videoBase);
		
	}

	@Override
	public VideoBase getByVideoBaseById(Integer id) {
		return videoBaseMapper.getByVideoBaseById(id);
	}

	@Override
	public List<VideoBase> getVideoBaseList(VideoBase videoBase) {
		return videoBaseMapper.getVideoBaseList(videoBase);
	}

	@Override
	public Integer getVideoBaseListCount(VideoBase videoBase) {
		return videoBaseMapper.getVideoBaseListCount(videoBase);
	}

	@Override
	public VideoBase getVideoBase(VideoBase videoBase) {
		List list = getVideoBaseList(videoBase);
		if(list != null && list.size() == 1){
			return (VideoBase)list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public List<Map> appendQrUrl(List<Map> list) {
		if(!CollectionUtils.isEmpty(list)) {
			for (Map map : list) {
				String qrcode = (String) map.get("qrcode");
				map.put("qrcode", qnService.generateQrDownUrl(qrcode));
			}
		}
		return list;
	}

}