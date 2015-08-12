package net.shinc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HttpRequestTest
 * @Description http请求模拟
 * @author guoshijie
 * @date 2015年8月3日 下午6:02:22
 */
public class HttpRequestTest {
	private static Logger logger = LoggerFactory.getLogger(HttpRequestTest.class);

	public static void main(String[] args) {
		// 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
//		System.getProperties().setProperty("http.proxyHost", "10.22.40.32");
//		System.getProperties().setProperty("http.proxyPort", "8080");
		// 判断代理是否设置成功
//		System.out.println("result==》"+sendPost("http://localhost:8080/edumgmt/login", "username=admin&password=admin"));
		System.out.println("result==》"+sendPost("http://xhpfm.mobile.zhongguowangshi.com:8091/v200/user/comment", "id=211135&content=啊好不错&userID=0&udid=0&clientApp=104&clientBundleID=net.xinhuamm.mainclient&clientType=2&clientVer=2.0.2&clientMarket=337&clientOS=4.4.4&clientModel=HM NOTE 1LTE&clientNet=wifi&clientToken=1b1c92d10ac72c611ab9b5de96febb13&clientId=1b1c92d10ac72c611ab9b5de96febb13&clientLable=866401023331302&clientDev=0&clientPrison=0&clientWidth=720&clientHeight=1280&clientLongitude=116.482487&clientLatitude=39.997927&clientDate=1439284413585&province=北京市&address=北京市 朝阳区 阜通西大街 靠近保利院线电影(卜蜂莲花望京宝星店)"));
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//			conn.setRequestProperty("Host", "xhpfm.mobile.zhongguowangshi.com:8091");
//			conn.setRequestProperty("Accept-Encoding", "gzip");
//			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				logger.error(ExceptionUtils.getStackTrace(ex));
			}
		}
		return result;
	}
}
