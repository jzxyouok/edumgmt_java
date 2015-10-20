package net.shinc.service.common;

import net.shinc.EdumgmtApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName PasswordEncoderServiceTest 
 * @Description 测试密码加密与匹配
 * @author guoshijie 
 * @date 2015年8月26日 下午5:52:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EdumgmtApplication.class)
@WebAppConfiguration
public class PasswordEncoderServiceTest {

	@Autowired
	private PasswordEncoderService pwdService;
	
	@Test
	public void testEncode() {
		String password = "youknowthisisshinc";
		String pwd = pwdService.encode(password);  //$2a$10$GrRnqJFzBu7Iv4d2EInUPeuvAyyFCQY8hBoxppg/loVq59KWwoaKC
		System.out.println(pwd);
	}
	
	@Test
	public void testMatches() {
		String encodedPassword = "$2a$10$GrRnqJFzBu7Iv4d2EInUPeuvAyyFCQY8hBoxppg/loVq59KWwoaKC";
		String encodedPassword2 = "$2a$10$6KMvI71qWGbfZhUtpep0H.LQhwsi4.E.lz5dVnM0Q1SPdbb0DrkEW";
		String rawPassword = "admin";
		boolean b = pwdService.matches(rawPassword, encodedPassword2);
		System.out.println(b);
	}
}
