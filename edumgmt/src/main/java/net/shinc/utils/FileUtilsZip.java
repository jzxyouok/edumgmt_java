package net.shinc.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ZipFileUtils
 * @Description: 文件夹压缩打包工具类型
 * @author hushichong
 * @date 2015年9月25日 下午12:33:43
 */
public class FileUtilsZip {
	protected static Logger logger = LoggerFactory.getLogger(FileUtilsZip.class);
	/**
	 * 把接受的全部文件打成压缩包
	 *
	 * @param List
	 *            <File>;
	 * @param org
	 *            .apache.tools.zip.ZipOutputStream
	 */
	private static void zipFile(List<File> files, ZipOutputStream outputStream) {
		int size = files.size();
		for (int i = 0; i < size; i++) {
			File file = (File) files.get(i);
			zipFile(file, outputStream);
		}
	}

	/**
	 * 导下载压缩文件
	 * 
	 * @param response
	 * @param filePath
	 *            源文件路径
	 * @param returnFileName
	 *            压缩包文件名
	 * @param isDrop
	 *            是否删除原文件:true删除、false不删除
	 * @param encoding
	 *            编码；默认：GBK
	 * @throws Exception
	 */
	public static void downLoadFiles(HttpServletResponse response, String filePath, String returnFileName, Boolean isDrop, String encoding) throws Exception {
		File zipFile = new File(generateZip(filePath, "home/ownLoad/" + returnFileName, isDrop));
		if (zipFile.exists()) {
			response.setContentType("application/octet-stream");
			String headerDisp = "attachment;filename=" + zipFile.getName() + ".zip";
			headerDisp = new String(headerDisp.getBytes("".equals(encoding) ? "GBK" : encoding), "iso8859-1");
			response.setHeader("Content-Disposition", headerDisp);
			ServletOutputStream out = null;
			byte[] buf = new byte[8192];
			BufferedInputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream(zipFile.getPath()));
				int len = 0;
				out = response.getOutputStream();
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			} catch (Exception e) {
				throw new Exception("导出ZIP文件异常,请于系统管理员联系！");
			} finally {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				if (isDrop) {
					File f = new File(zipFile.getPath());
					f.delete();
				}
			}
		} else {
			throw new Exception("文件不存在");
		}
	}

	/**
	 * 根据输入的文件与输出流对文件进行打包
	 *
	 * @param File
	 * @param org
	 *            .apache.tools.zip.ZipOutputStream
	 */
	private static void zipFile(File inputFile, ZipOutputStream ouputStream) {
		try {
			if (inputFile.exists()) {
				/**
				 * 如果是目录的话这里是不采取操作的， 至于目录的打包正在研究中
				 */
				if (inputFile.isFile()) {
					FileInputStream IN = new FileInputStream(inputFile);
					BufferedInputStream bins = new BufferedInputStream(IN, 512);
					// org.apache.tools.zip.ZipEntry
					logger.info("需要打包文件inputFile：[" + inputFile.getName() + " ] ");
					ZipEntry entry = new ZipEntry(inputFile.getName());
					ouputStream.putNextEntry(entry);
					// 向压缩文件中输出数据
					int nNumber;
					byte[] buffer = new byte[1024];
					while ((nNumber = bins.read(buffer)) != -1) {
						ouputStream.write(buffer, 0, nNumber);
					}
					// 关闭创建的流对象
					bins.close();
					IN.close();
				} else {
					try {
						File[] files = inputFile.listFiles();
						for (int i = 0; i < files.length; i++) {
							zipFile(files[i], ouputStream);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空文件和文件目录
	 *
	 * @param f
	 */
	private static void clean(File f) throws Exception {
		String cs[] = f.list();
		if (cs == null || cs.length <= 0) {
			System.out.println("delFile:[ " + f + " ]");
			boolean isDelete = f.delete();
			if (!isDelete) {
				System.out.println("delFile:[ " + f.getName() + "文件删除失败！" + " ]");
				throw new Exception(f.getName() + "文件删除失败！");
			}
		} else {
			for (int i = 0; i < cs.length; i++) {
				String cn = cs[i];
				String cp = f.getPath() + File.separator + cn;
				File f2 = new File(cp);
				if (f2.exists() && f2.isFile()) {
					System.out.println("delFile:[ " + f2 + " ]");
					boolean isDelete = f2.delete();
					if (!isDelete) {
						System.out.println("delFile:[ " + f2.getName() + "文件删除失败！" + " ]");
						throw new Exception(f2.getName() + "文件删除失败！");
					}
				} else if (f2.exists() && f2.isDirectory()) {
					clean(f2);
				}
			}
			System.out.println("delFile:[ " + f + " ]");
			boolean isDelete = f.delete();
			if (!isDelete) {
				System.out.println("delFile:[ " + f.getName() + "文件删除失败！" + " ]");
				throw new Exception(f.getName() + "文件删除失败！");
			}
		}
	}

	/**
	 * 文件夹打包
	 * 
	 * @param path
	 *            原文件路径
	 * @param returnPath
	 *            压缩后文件路径
	 * @param isDrop
	 *            是否删除原文件:true删除、false不删除
	 * @return
	 * @throws Exception
	 */
	public static String generateZip(String path, String returnPath, Boolean isDrop) throws Exception {
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		if (!file.exists()) {
			logger.error("待压缩文件不存在:" + file.getAbsolutePath());
			throw new Exception("原因文件：[ " + file.getPath() + " ]不存在，打包失败！");
		}
		if (file.exists() && file.isFile()) {
			files.add(file);
		} else if (file.exists() && file.isDirectory()) {
			File[] fil = new File(path).listFiles();
			for (int i = 0; i < fil.length; i++) {
				files.add(fil[i]);
			}
		}
		File outFile = new File(returnPath);
		
		if (!outFile.exists()) {
			boolean isMkDirs = outFile.createNewFile();
			if (!isMkDirs) {
				logger.error("压缩文件目录：[ " + outFile.getName() + " ]，创建压缩文件失败！");
				throw new Exception("压缩文件目录：[ " + outFile.getName() + " ]，创建压缩文件失败！");
			}
		}
		// 创建文件输出流
		FileOutputStream fous = new FileOutputStream(outFile);
		/**
		 * 打包的方法我们会用到ZipOutputStream这样一个输出流, 所以这里我们把输出流转换一下
		 */
		ZipOutputStream zipOut = new ZipOutputStream(fous);
		try {
			/**
			 * 这个方法接受的就是一个所要打包文件的集合， 还有一个ZipOutputStream
			 */
			if (files != null && files.size() > 0) {
				zipFile(files, zipOut);
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		} finally {
			zipOut.close();
			fous.close();
			if (isDrop) {
				clean(new File(path));
			}
		}
		return outFile.getPath();
	}

	public static void main(String[] args) {
		try {
			// clean(new File("C:\\Users\\Administrator\\Desktop\\新建文件夹 (3)"));
			System.out.println(generateZip("C:\\Users\\Administrator\\Desktop\\新建文件夹 (6) - 副本\\666666666.zip", "C:/Users/Administrator/Desktop/新建文件夹 (6)/", true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// new File("E:/新建文件夹/erer").delete();
	}
}