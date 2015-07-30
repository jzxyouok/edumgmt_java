package net.shinc.service.common;

public interface PasswordEncoderService {
	
	public String encode(CharSequence rawPassword);
	
	public boolean matches(CharSequence rawPassword, String encodedPassword);

}
