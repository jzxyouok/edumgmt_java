package net.shinc.service.edu.video.impl;

import java.util.ArrayList;
import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoPic;
import net.shinc.orm.mybatis.mappers.edu.VideoPicMapper;
import net.shinc.service.common.QNService;
import net.shinc.service.edu.video.VideoPicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

@Service
public class VideoPicServiceImpl implements VideoPicService {
	
	@Autowired
	private VideoPicMapper videlPicMapper;
	
	@Autowired
	private QNService qnService;
	
	/**
	 * 按照VideoBaseId选择截图（可能一个视频对应多张截图）
	 */
	@Override
	public List<VideoPic> selectPicByVideoBaseId(Integer id,String domain, long expires) {
		if (null != id) {
			List<VideoPic> list = videlPicMapper.selectPicByVideoBaseId(id);
			List<VideoPic> list2 = setRemoteUrlForVideoPic(list, domain, expires);
			return list2;
		}
		return null;
	}
	
	/**
	 * 计算远程url,并赋值
	 * @return
	 */
	public List<VideoPic> setRemoteUrlForVideoPic(List<VideoPic> list, String domain, long expires) {
		if(!CollectionUtils.isEmpty(list)) {
			for (VideoPic videoPic : list) {
				String storeInfo = videoPic.getStoreInfo();
				if(!StringUtils.isEmpty(storeInfo)) {
					String remoteUrl = domain + storeInfo;
					videoPic.setRemoteUrl(remoteUrl);
					videoPic.setDownloadUrl(qnService.getDownloadUrl(remoteUrl, expires));
				}
			}
		}
		return list;
	}
	
	/**
	 * 按照Id选择截图
	 */
	@Override
	public VideoPic selectPicById(Integer id) {
		if (null != id) {
			return videlPicMapper.selectPicById(id);
		}
		return null;
	}
	
	/**
	 * 删除单张截图
	 */
	@Override
	public Integer deletePicById(Integer id) {
		if (null != id) {
			return videlPicMapper.deletePicById(id);
		}
		return 0;
	}
	
	/**
	 * 批量删除截图
	 */
	@Override
	public Integer deletePicBatch(List<VideoPic> list) {
		if(null != list && list.size() > 0) {
			return videlPicMapper.deletePicBatch(list);
		}
		return 0;
	}
	
	/**
	 * 增加单张截图
	 */
	@Override
	public Integer insertPic(VideoPic pic) {
		if (null != pic) {
			return videlPicMapper.insertPic(pic);
		}
		return 0;
		
	}
	
	/**
	 * 批量增加截图
	 */
	@Override
	public Integer insertPicBatch(List<VideoPic> list) {
		if(null != list && list.size() > 0) {
			return videlPicMapper.insertPicBatch(list);
		}
		return 0;
	}
	
	@Override
	public List<String> dealVideoPicStoreInfo(List<VideoPic> list) {
		List<String> keyList = new ArrayList<String>();
		if(!CollectionUtils.isEmpty(list)) {
			for (VideoPic videoPic : list) {
				String key = videoPic.getStoreInfo();
				keyList.add(key);
			}
		}
		return keyList;
	}
}
