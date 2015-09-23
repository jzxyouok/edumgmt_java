package net.shinc.service.edu.business.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Book;
import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.bean.edu.VideoBase;
import net.shinc.orm.mybatis.mappers.edu.BookMapper;
import net.shinc.orm.mybatis.mappers.edu.ProblemMapper;
import net.shinc.service.common.QNService;
import net.shinc.service.common.QRService;
import net.shinc.service.edu.business.BookService;

import org.apache.commons.lang3.StringUtils;
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

	@Autowired
	private QNService qnService;

	@Autowired
	private QRService qrService;
	
	@Value("${qrcode.tempPath}")
	private String qrcodeTempPath;
	
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
					problemMapper.insert(p);
					list.add(p);
				}
			}
		}
		logger.info("生成二维码数量："+list.size());

		// 生成二维码
		for (Problem p : (List<Problem>)list) {
			String content = phpPath + book.getParterId().toString()+"_"+book.getId().toString()+"_"+p.getId().toString();
			String qrImgAbPath = qrService.generateQrCode(qrcodeTempPath, phpPath, content);
			
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

}
