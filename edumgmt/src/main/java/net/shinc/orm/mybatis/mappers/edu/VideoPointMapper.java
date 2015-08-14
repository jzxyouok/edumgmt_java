package net.shinc.orm.mybatis.mappers.edu;

import java.util.List;
import java.util.Map;

import net.shinc.orm.mybatis.bean.common.QueryBean;
import net.shinc.orm.mybatis.bean.edu.VideoPoint;

import org.apache.ibatis.session.RowBounds;
/**
  * @ClassName: VideoPointMapper
  * @Description: 知识点视频DAO接口
  * @author hushichong
  * @date 2015年7月31日 下午4:52:24
 */
public interface VideoPointMapper {
    
    public void deleteVideoPointById(Integer id);

	public Integer insertVideoPoint(VideoPoint videoPoint);

	public void updateVideoPoint(VideoPoint videoPoint);

	public VideoPoint getByVideoPointById(Integer id);

	public List<VideoPoint> getVideoPointList(VideoPoint videoPoint);

	public Integer getVideoPointListCount(VideoPoint videoPoint);
	
	/**
	 * @Title: getVideoPointAndRelevantInfoList
	 * @Description: 得到知识点视频以及其相关信息列表
	 * @param videoPoint
	 * @return List<VideoPoint>
	 */
	public List<Map> getVideoPointAndRelevantInfoList(QueryBean queryBean,RowBounds rowBounds);
	
	/**
	 * @Title: getVideoPointAndRelevantInfoListCount
	 * @Description: 得到知识点视频以及其相关信息列表总条数
	 * @param videoPoint
	 * @return List<VideoPoint>
	 */
	public List<VideoPoint> getVideoPointAndRelevantInfoListCount(VideoPoint videoPoint);
}