package net.shinc.web.servlet.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangtaichao 2015年5月27日
 *
 */
public class LoggingFilter implements Filter {
	
	Logger logger  = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> e = req.getHeaderNames();
		StringBuilder sb = new StringBuilder();
		sb.append("headers:\n");
		while(e.hasMoreElements()) {
			String str = e.nextElement();
			sb.append(str + ":" + req.getHeader(str)).append("\n");
		}
		sb.append("body:\n");
		Enumeration<String> nameEnum = req.getParameterNames();
		while(nameEnum.hasMoreElements()) {
			String key = nameEnum.nextElement();
			sb.append(key).append("=").append(req.getParameter(key)).append("\n");
		}
		logger.debug(sb.toString());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}

