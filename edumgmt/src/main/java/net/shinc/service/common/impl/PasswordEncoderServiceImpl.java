package net.shinc.service.common.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.shinc.service.common.PasswordEncoderService;

/**
 * @author zhangtaichao 2015年6月2日
 *
 */
@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String encode(CharSequence rawPassword) {
		
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	
	

}
