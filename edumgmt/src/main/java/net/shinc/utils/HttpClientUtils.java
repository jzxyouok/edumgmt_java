package net.shinc.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName HttpClientUtils 
 * @Description 发送post请求与get请求
 * @author guoshijie 
 * @date 2015年8月14日 下午3:05:33
 */
public class HttpClientUtils {
	
	private static Logger logger = Logger.getLogger(HttpClientUtils.class);
	private static String charset = "UTF-8";

	@Autowired
	private CloseableHttpClient httpClient;
	
	/**
	 * 发送post请求
	 * @param postUrl
	 * @param params
	 * @return
	 */
	public String post(String postUrl, List<NameValuePair> params) {
		HttpPost post = new HttpPost();
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			post.setURI(URI.create(postUrl));
			
			HttpEntity entity = new UrlEncodedFormEntity(params, charset);
			post.setEntity(entity);
//			post.setHeader("X-Forwarded-For", RandomUtils.generateIp());
			
			HttpResponse res = httpClient.execute(post);
			Header[] headers = res.getAllHeaders();
			for(int i = 0; i < headers.length; i++) {
				logger.info("responseHeaders["+i+"]: "+headers[i]);
			}
			
			String result = EntityUtils.toString(res.getEntity());
			logger.info("responseBody: " + UnicodeUtils.decodeUnicode(result));
			return result;
		} catch (Exception e) {
			logger.info(ExceptionUtils.getStackTrace(e));
		} finally {
			post.releaseConnection();
		}
		return null;
	}
	
	public String get(String url) {
		HttpGet get = new HttpGet();
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			get.setURI(URI.create(url));
//			get.setHeader("X-Forwarded-For", RandomUtils.generateIp());
			
			HttpResponse res = httpClient.execute(get);
			Header[] headers = res.getAllHeaders();
			for(int i = 0; i < headers.length; i++) {
				logger.info("responseHeaders["+i+"]: "+headers[i]);
			}
			
			String result = EntityUtils.toString(res.getEntity());
			logger.info("responseBody: " + UnicodeUtils.decodeUnicode(result));
			return result;
		} catch (Exception e) {
			logger.info(ExceptionUtils.getStackTrace(e));
		} finally {
			get.releaseConnection();
		}
		return null;
	}
	
	/**
	 * 准备请求参数
	 * @return
	 */
	public static List<NameValuePair> getAddParams() {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("username", "admin"));
		list.add(new BasicNameValuePair("password", "admin"));
		return list;
	}
	
	public static void main(String[] args) {
		HttpClientUtils client = new HttpClientUtils();
		client.post("http://localhost:8080/edumgmt/login123", getAddParams());
		
//		String url = "http://7xkw22.com1.z0.glb.clouddn.com/o_19tna2i94k6l1clvlhetbt1qvmb.mp4?avinfo&e=1440674148&token=2vfqNhAmF6Mn9SVe6-g6wMaqIIfaSpX3oynfBWlr:Fltbd5JrQ5WTannydxeQYKAvI_8=";
//		client.get(url);
	}
}
