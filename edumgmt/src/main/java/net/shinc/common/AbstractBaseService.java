package net.shinc.common;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

/**
 * 写服务层，想省事就继承我！！！
 * @author zhangtaichao 2015年9月28日
 *
 */
public abstract class AbstractBaseService implements ApplicationContextAware {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected ApplicationContext applicationContext;
	
	@Autowired
	protected MessageSource messageSource;
	
	@Autowired
	@Qualifier("sqlSession")
	protected SqlSessionTemplate sqlSession;
	
	public String getExceptionStackTrace(Throwable t) {
		return ExceptionUtils.getStackTrace(t);
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
