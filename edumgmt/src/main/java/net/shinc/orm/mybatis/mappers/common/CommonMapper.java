package net.shinc.orm.mybatis.mappers.common;

import java.util.List;

/**
 * @ClassName: CommonMapper
 * @Description: 公共服务 Mapper
 * @author hushichong
 * @date 2015年9月15日 下午6:27:07
 */
public interface CommonMapper {

	public <T> Integer insert(T entity);

	public <T> Integer deleteById(Integer id);

	public <T> Integer update(T entity);

	public <T> T findById(Integer id);

	public <T> List<T> findAll(T entity);

}