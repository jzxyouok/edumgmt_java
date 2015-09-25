package net.shinc.service.edu.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.User;
import net.shinc.orm.mybatis.mappers.edu.UserMapper;
import net.shinc.service.edu.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 移动端用户服务接口实现
 * @date 2015年8月3日 下午4:33:32
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper courseMapper;

	@Override
	public Integer insert(User user) {

		return courseMapper.insert(user);
	}

	@Override
	public Integer update(User user) {
		
		return courseMapper.update(user);
	}

	@Override
	public Integer deleteById(Integer id) {

		return courseMapper.deleteById(id);
	}

	@Override
	public User getById(Integer id) {

		return null;
	}

	@Override
	public List<User> findAll(User user) {

		return courseMapper.findAll(user);
	}

}
