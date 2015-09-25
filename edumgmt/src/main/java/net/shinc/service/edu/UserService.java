package net.shinc.service.edu;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.User;

/**
 * @ClassName: UserService
 * @Description: 移动端用户服务接口
 * @author hushichong
 * @date 2015年9月25日 下午7:47:07
 */
public interface UserService {
	public Integer insert(User user);

	public Integer update(User user);

	public Integer deleteById(Integer id);

	public User getById(Integer id);

	public List<User> findAll(User user);


}
