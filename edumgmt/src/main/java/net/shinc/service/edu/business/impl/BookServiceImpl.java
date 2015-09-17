package net.shinc.service.edu.business.impl;

import java.util.List;

import net.shinc.orm.mybatis.bean.edu.Book;
import net.shinc.orm.mybatis.bean.edu.Problem;
import net.shinc.orm.mybatis.mappers.edu.BookMapper;
import net.shinc.service.edu.business.BookService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BookService
 * @Description: 书商服务接口实现
 * @author hushichong
 * @date 2015年9月15日 下午1:03:21
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public Integer addBook(Book book) {
		Integer record = bookMapper.insert(book);
		if(record != null && record == 1){
			if(StringUtils.isNotEmpty(book.getNumReservation())){
				// 插入题表
				for (int i = 0; i < Integer.valueOf(book.getNumReservation()); i++) {
					Problem p = new Problem();
					p.setBookId(book.getId());
				}
			}
			return record;
		}
		return null;
		
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
		return (Book)bookMapper.findById(id);
	}

	@Override
	public List<Book> getBookList(Book book) {
		return bookMapper.findAll(book);
	}

	

}
