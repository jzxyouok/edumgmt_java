package net.shinc.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @ClassName: FileUtilsShiHe
  * @Description: 文件下载工具类
  * @author hushichong
  * @date 2015年9月25日 下午12:39:24
 */
public class FileUtilsShiHe {

	private static Logger logger = LoggerFactory.getLogger(FileUtilsShiHe.class);

	/**
	 * 文件下载
	 * @param response
	 * @param str
	 * @param fileName导出后文件名
	 */
	public static HttpServletResponse downFile(HttpServletResponse response, String filePath, String fileName) {
		try {
			String path = filePath;
			File file = new File(path);
			if (file.exists()) {
				InputStream ins = new FileInputStream(path);
				BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
				OutputStream outs = response.getOutputStream();// 获取文件输出IO流
				BufferedOutputStream bouts = new BufferedOutputStream(outs);
				response.setContentType("application/x-download");// 设置response内容的类型
				response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));// 设置头部信息
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				// 开始向网络传输文件流
				while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
					bouts.write(buffer, 0, bytesRead);
				}
				bouts.flush();// 这里一定要调用flush()方法
				ins.close();
				bins.close();
				outs.close();
				bouts.close();

			} else {
				logger.error("文件下载出错文件不存在");
				response.getOutputStream().write(-1);
			}
		} catch (IOException e) {
			logger.error("文件下载出错", e);
		}
		return response;
	}
}