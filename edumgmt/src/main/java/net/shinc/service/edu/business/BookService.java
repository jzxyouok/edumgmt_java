package net.shinc.service.edu.business;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.shinc.orm.mybatis.bean.edu.Book;

/**
  * @ClassName: BookService
  * @Description: 书服务接口
  * @author hushichong
  * @date 2015年9月15日 下午1:03:21
 */
public interface BookService {

	public Integer addBook(Book book);
	
	public Integer updateBook(Book book);
	
	public Integer deleteBookById(Integer id);
	
	public Book getBookById(Integer id);
	
	public List<Book> getBookList(Book book);
	
	public boolean isHasVideo(Book book);
	
	public void dwonTwoCode(Book book, HttpServletResponse httpServletResponse) throws Exception;
}
