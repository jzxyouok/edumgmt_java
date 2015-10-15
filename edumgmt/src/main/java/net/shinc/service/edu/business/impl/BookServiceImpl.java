package net.shinc.service.edu.business.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.shinc.orm.mybatis.bean.edu.Book;
import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.mappers.edu.BookMapper;
import net.shinc.orm.mybatis.mappers.edu.ProblemMapper;
import net.shinc.service.common.QNService;
import net.shinc.service.common.QRService;
import net.shinc.service.edu.business.BookService;
import net.shinc.utils.FileUtilsShiHe;
import net.shinc.utils.FileUtilsZip;
import net.shinc.utils.HttpClientUtils;

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
	
	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private ProblemMapper problemMapper;

	private HttpServletResponse httpServletResponse;
	
	@Autowired
	private QNService qnService;

	@Autowired
	private QRService qrService;
	
	@Value("${qrcode.tempPath}")
	private String tempPath;
	
	@Value("${php.play.video}")
	private String phpPath;
	
	//二维码所在空间名称
	@Value("${qiniu.eduonline.qrBucketName}")
	private String qrBucketName;
	
	//二维码所在空间域名
	@Value("${qiniu.eduonline.qrDomain}")
	private String qrDomain;
	
	@Value("${qiniu.eduonline.deadline}")
	private String expires;

	@Override
	public Integer addBook(Book book) {
		List list = new ArrayList();
		Integer record = bookMapper.insert(book);
		if (record != null && record == 1) {
			if (StringUtils.isNotEmpty(book.getNumReservation())) {
				// 插入题表
				for (int i = 0; i < Integer.valueOf(book.getNumReservation()); i++) {
					Problem p = new Problem();
					p.setBookId(book.getId());
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
			String content = phpPath + book.getParterId().toString()+"_"+book.getId().toString()+"_"+p.getId().toString();
			String qrImgAbPath = qrService.generateQrCode(tempPath, phpPath, content);
			
			File img = new File(qrImgAbPath);
			// 上传二维码
			String link = qnService.upload(qrImgAbPath, img.getName(), qnService.getUploadToken(qrBucketName, Long.parseLong(expires)), qrDomain);
			// 更新数据库qrcode
			p.setTwoCode(link);
			problemMapper.update(p);
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
		Problem p = new Problem();
		p.setBookId(book.getId());
		List list = problemMapper.findAll(p);
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		for (Problem problem : (List<Problem>) list) {
			String twoCode = problem.getTwoCode();
			HttpGet get = new HttpGet();
			try {
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				get.setURI(URI.create(twoCode));
				// get.setHeader("X-Forwarded-For", RandomUtils.generateIp());

				HttpResponse httpResponse = httpClient.execute(get);
				HttpEntity httpEntity = httpResponse.getEntity();
				String fileName = StringUtils.substringAfterLast(twoCode, "/");
				FileUtils.deleteQuietly(new File(tempPath + "/down/book_" + book.getId().toString() + "/book_" + book.getId().toString() + ".zip"));
				File file = new File(downPath + "/book_" + book.getId().toString());
				// 如果文件夹不存在则创建
				if (!file.exists() && !file.isDirectory()) {
					System.out.println("//不存在");
					System.out.println(file.mkdir());
				} else {
					System.out.println("//目录存在");
				}
				if (httpEntity.isStreaming()) {
					InputStream in = httpEntity.getContent();
					File f = new File(downPath + "/book_" + book.getId().toString() + "/" + fileName);
					if(!f.exists()) {
						f.createNewFile();
					}
					FileOutputStream fileOutputStream = new FileOutputStream(f);
					byte[] bs = new byte[1024 * 4];
					int len = -1;
					while ((len = in.read(bs)) != -1) {
						fileOutputStream.write(bs, 0, len);
					}
					fileOutputStream.flush();
					fileOutputStream.close();
				}
				fileNameList.add(fileName);
			} catch (Exception e) {
				logger.info(ExceptionUtils.getStackTrace(e));
			} finally {
				get.releaseConnection();
			}
			

		}
		FileUtilsZip.generateZip(downPath + "/book_" + book.getId().toString(), downPath + "/book_" + book.getId().toString() + "/", false);
		FileUtilsShiHe.downFile(httpServletResponse, downPath + "/book_" + book.getId().toString() + "/book_" + book.getId().toString() + ".zip", "book_"
				+ book.getId().toString() + ".zip");
		
	}

}
