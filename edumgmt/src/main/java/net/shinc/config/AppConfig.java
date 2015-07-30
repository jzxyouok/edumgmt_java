package net.shinc.config;

import net.shinc.aop.log.LoggingAspect;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.RestMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class AppConfig {
    
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * @return 
	 */
	@Bean
	@Scope("request")
	public IRestMessage restMessage(LocaleResolver locale) {
		
		String code = ErrorMessage.ERROR_DEFAULT.getCode();
		RestMessage msg = new RestMessage(code, messageSource, locale.resolveLocale(null));
		return msg;
	}
	
	@Bean
    public LoggingAspect loggingAspect() {
		LoggingAspect la = new LoggingAspect();
		return la;
    }
}
