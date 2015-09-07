package net.shinc.service.edu.video.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.mappers.edu.VideoBaseMapper;
import net.shinc.service.common.QNService;
import net.shinc.service.common.QRService;
import net.shinc.service.edu.video.VideoBaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

/**
  * @ClassName: VideoBaseServiceImpl
  * @Description: 视频公共基础信息服务接口实现类
  * @author hushichong
  * @date 2015年7月31日 下午5:30:18
 */
@Service
public class VideoBaseServiceImpl implements VideoBaseService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VideoBaseMapper videoBaseMapper;
	
	@Autowired
	private QNService qnService;
	
	@Autowired
	private QRService qrService;
	
	@Value("${qrcode.tempPath}")
	private String qrcodeTempPath;
	
	@Value("${php.play.video}")
	private String playVideoPath;
	
	//二维码所在空间名称
	@Value("${qiniu.eduonline.qrBucketName}")
	private String qrBucketName;
	
	//二维码所在空间域名
	@Value("${qiniu.eduonline.qrDomain}")
	private String qrDomain;
	
	@Value("${qiniu.eduonline.deadline}")
	private String expires;
	
	
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

	@Override
	public Integer updateQrCodeByVideoBaseById(VideoBase videoBase) {
		if(null != videoBase) {
			Integer integer = videoBaseMapper.updateQrCodeByVideoBaseById(videoBase);
			return integer;
		}
		return 0;
	}
	
	@Override
	public Integer generateQRCodeAndUpload(Integer videoBaseId) {
		//生成二维码
		String qrImgAbPath = qrService.generateQrCode(qrcodeTempPath, playVideoPath, videoBaseId);
		logger.info(qrImgAbPath);
		
		if(StringUtils.isEmpty(qrImgAbPath)) {
			return 0;
		} else {
			File img = new File(qrImgAbPath);
			//上传二维码
			String link = qnService.upload(qrImgAbPath, img.getName(), qnService.getUploadToken(qrBucketName, Long.parseLong(expires)), qrDomain);
			//更新数据库qrcode
			Integer num = updateQrCodeByVideoBaseById(new VideoBase(videoBaseId,link));
			return num;
		}
	}

}