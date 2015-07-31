package net.shinc.orm.mybatis.mappers;

import net.shinc.orm.mybatis.bean.VideoBase;

public interface VideoBaseMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(VideoBase record);

	int insertSelective(VideoBase record);

	VideoBase selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(VideoBase record);

	int updateByPrimaryKey(VideoBase record);
}