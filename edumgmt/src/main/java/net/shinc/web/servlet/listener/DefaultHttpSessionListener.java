package net.shinc.web.servlet.listener;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultHttpSessionListener implements HttpSessionListener {
	
	private int timeout = 3;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		logger.info("session created:" + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession s = se.getSession();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
		if(s != null) {
			logger.info("session destroyed:" + s.getId());
			logger.info("last session access:" + fmt.format(s.getLastAccessedTime()));
		} else {
			logger.info("session destroyed");
		}
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
}
