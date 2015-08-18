package net.shinc.config;

import net.shinc.security.DBUserDetailsService;
import net.shinc.security.ForwardLogoutSuccessHandler;
import net.shinc.security.LoginSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().anyRequest().permitAll().and().formLogin().withObjectPostProcessor(new ObjectPostProcessor<LoginUrlAuthenticationEntryPoint>() {
//
//			@Override
//			public <O extends LoginUrlAuthenticationEntryPoint> O postProcess(O laep) {
//				laep.setUseForward(true);
//				return laep;
//			}
//		}).loginPage("/login").permitAll().and().logout().logoutUrl("/logout").permitAll().and().csrf().disable();

		http
		.authorizeRequests()
//				.antMatchers("/adminUser/**").hasAnyAuthority("adminUserManage")
//				.antMatchers("/adminUser/getAdminUserList").hasAnyAuthority("adminUserList")
				.antMatchers("/loginFail").permitAll()
				.antMatchers("/logoutSuccess").permitAll()
				
				.antMatchers("/manage/**").permitAll()
				.antMatchers("/videoPastpaper/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.withObjectPostProcessor(new ObjectPostProcessor<LoginUrlAuthenticationEntryPoint>(){
					@Override
					public <O extends LoginUrlAuthenticationEntryPoint> O postProcess(O laep) {
						 laep.setUseForward(true);
						 return laep;
					}
				})
				.loginPage("/login")
				.successHandler(successHandler())
				.failureHandler(failureHandler())
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(logoutHandler())
				.permitAll()
				.and()
			.csrf()
				.disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(dbUserDetailService()).passwordEncoder(defaultPasswordEncoder());
		auth.userDetailsService(dbUserDetailService());
	}

	@Bean
	public UserDetailsService dbUserDetailService() {
		UserDetailsService ds = new DBUserDetailsService();
		return ds;
	}

	@Bean
	public PasswordEncoder defaultPasswordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Bean
	public SimpleUrlAuthenticationFailureHandler failureHandler() {
		SimpleUrlAuthenticationFailureHandler failHandler = new SimpleUrlAuthenticationFailureHandler();
		failHandler.setUseForward(true);
		failHandler.setDefaultFailureUrl("/loginFail");
		return failHandler;
	}

	@Bean
	public LoginSuccessHandler successHandler() {
		LoginSuccessHandler successHandler = new LoginSuccessHandler();
		successHandler.setDefaultTargetUrl("/isLogin");
		successHandler.setAlwaysUseDefaultTargetUrl(true);
		return successHandler;
	}

	public ForwardLogoutSuccessHandler logoutHandler() {
		ForwardLogoutSuccessHandler handler = new ForwardLogoutSuccessHandler();
		handler.setDefaultTargetUrl("/logoutSuccess");
		return handler;
	}
	
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder(4);
		System.out.println(encoder.encode("admin"));
	}

}
