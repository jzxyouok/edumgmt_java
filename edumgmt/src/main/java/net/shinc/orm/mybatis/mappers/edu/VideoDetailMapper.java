package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.VideoDetail;

/** 
 * @ClassName VideoDetailMapper 
 * @Description 视频详细信息
 * @author wangzhiying 
 * @date 2015年7月31日 下午7:53:32  
 */
public interface VideoDetailMapper {

    /**
     * 根据videoBaseId和type删除
     * @param videoDetail
     */
    public void deleteVideoDetailById(VideoDetail videoDetail);

	public Integer insertVideoDetail(VideoDetail videoDetail);

	public void updateVideoDetail(VideoDetail videoDetail);

	/**
	 * 根据videoBaseId和type查询
	 * @param videoDetail
	 * @return
	 */
	public VideoDetail getByVideoDetailById(VideoDetail videoDetail);

	public List<VideoDetail> getVideoDetailList(VideoDetail videoDetail);

	public Integer getVideoDetailListCount(VideoDetail videoDetail);
}