package net.shinc.service.edu.business.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.shinc.orm.mybatis.bean.edu.Book;
import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.mappers.edu.BookMapper;
import net.shinc.orm.mybatis.mappers.edu.ProblemMapper;
import net.shinc.service.common.QRService;
import net.shinc.service.edu.business.BookService;
import net.shinc.utils.FileUtilsShiHe;
import net.shinc.utils.FileUtilsZip;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BookService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class BookServiceImpl implements BookService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${qrcode.tempPath}")
	private String tempPath;
	
	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private ProblemMapper problemMapper;

	private HttpServletResponse httpServletResponse;
	
	@Autowired
	private QRService qrService;

	@Override
	public Integer addBook(Book book) {
		List list = new ArrayList();
		Integer record = bookMapper.insert(book);
		if (record != null && record == 1) {
			if (StringUtils.isNotEmpty(book.getNumReservation())) {
				Integer seq = 1;
				// 插入题表
				for (int i = 0; i < Integer.valueOf(book.getNumReservation()); i++) {
					Problem p = new Problem();
					p.setBookId(book.getId());
					p.setSeq(seq++);
					p.setStatus("1");
					// 优化为批量插入
					problemMapper.insert(p);
					list.add(p);
				}
			}
		}
		logger.info("生成二维码数量："+list.size());

		// 生成二维码
		for (Problem p : (List<Problem>)list) {
			@SuppressWarnings("rawtypes")
			Map param = new HashMap();
			param.put(QRService.QRPARAM_BOOKID, book.getId());
			param.put(QRService.QRPARAM_TYPE, QRService.QRPARAM_TYPE_PROBLEMID);
			param.put(QRService.QRPARAM_ID, p.getId());
			String link = qrService.generateQrCode(param);
			
			// 更新数据库qrcode
			p.setTwoCode(link);
			if(link != null) {
				problemMapper.update(p);
			}
		}
		return record;

	}
	
	@Override
	public Integer updateBook(Book book) {
		return bookMapper.update(book);
	}

	@Override
	public Integer deleteBookById(Integer id) {
		return bookMapper.deleteById(id);
	}

	@Override
	public Book getBookById(Integer id) {
		return (Book) bookMapper.findById(id);
	}

	@Override
	public List<Book> getBookList(Book book) {
		return bookMapper.findAll(book);
	}

	@Override
	public boolean isHasVideo(Book book) {
		Problem problem = new Problem();
		problem.setBookId(book.getId());
		List list = problemMapper.findAll(problem);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void dwonTwoCode(Book book,HttpServletResponse httpServletResponse) throws Exception {
		String downPath = tempPath;
		List fileNameList = new ArrayList();
		
		/*
		 * 查询书下面的题列表信息
		 */
		Problem p = new Problem();
		p.setBookId(book.getId());
		
		String bookName = "book_qrcode_" + book.getId();
		String bookZipName = bookName + ".zip";
		String bookZipPath = tempPath + "/" + bookZipName;
		String bookDir = tempPath + "/" + bookName;
		
		File dir = new File(bookDir);
		if(!dir.isDirectory()) {
			if(!dir.mkdir()) {
				logger.error("创建文件夹失败:" + dir.getAbsolutePath());
				return ;
			}
		}
		
		
		FileUtils.deleteQuietly(new File(bookZipPath));
		
		String bookPrefix = "qr_" + book.getId() + "_";
		
		List list = problemMapper.findAll(p);
		for (Problem problem : (List<Problem>) list) {
			String twoCode = problem.getTwoCode();
			String suffix = "." + StringUtils.substringAfterLast(twoCode, ".");
			HttpGet get = new HttpGet();
			FileOutputStream fileOutputStream = null;
			try {
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				try {
					get.setURI(URI.create(twoCode));
				} catch(Exception e) {
					logger.warn("get uri fail:problemid=" + problem.getId());
					continue;
				}
				

				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity httpEntity = httpResponse.getEntity();
				
				
				if (httpEntity.isStreaming()) {
					
					String fileName = bookPrefix + problem.getSeq() + suffix;
					String filePath = bookDir + "/" + fileName;
					InputStream in = httpEntity.getContent();
					File f = new File(filePath);
					if(!f.exists()) {
						f.createNewFile();
					}
					fileOutputStream = new FileOutputStream(f);
					byte[] bs = new byte[1024 * 4];
					int len = -1;
					while ((len = in.read(bs)) != -1) {
						fileOutputStream.write(bs, 0, len);
					}
					fileOutputStream.flush();
					fileNameList.add(fileName);
				}
				
			} catch (Exception e) {
				logger.info(ExceptionUtils.getStackTrace(e));
			} finally {
				get.releaseConnection();
				if(fileOutputStream != null) {
					fileOutputStream.close();
					fileOutputStream = null;
				}
			}
			

		}
		FileUtilsZip.generateZip(bookDir, bookZipPath, false);
		FileUtilsShiHe.downFile(httpServletResponse, bookZipPath, bookZipName);
		
	}

	@Override
	public boolean checkMaxProblem(Long bookId) {
		Integer o = bookMapper.checkMaxProblem(bookId);
		if(o == null) return false;
		return o == 1 ? true : false;
	}

	
}
