package net.shinc.service.common;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: CommonMapper
 * @Description: 公共服务 Mapper
 * @author hushichong
 * @date 2015年9月15日 下午6:27:07
 */
public interface CommonService<T> {

	public Integer insert(T entity);

	public Integer deleteById(Integer id);

	public Integer update(T entity);

	public T findById(Integer id);

	public List<T> findAll(T entity);
	
}