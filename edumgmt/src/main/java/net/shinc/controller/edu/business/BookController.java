package net.shinc.controller.edu.business;

import java.util.List;

import javax.validation.Valid;

import net.shinc.common.AbstractBaseController;
import net.shinc.common.ErrorMessage;
import net.shinc.common.IRestMessage;
import net.shinc.common.ShincUtil;
import net.shinc.orm.mybatis.bean.edu.Book;
import net.shinc.service.edu.business.BookService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: BookController
 * @Description: 书控制类
 * @author hushichong
 * @date 2015年9月16日 下午9:53:23
 */
@Controller
@RequestMapping(value = "/book")
public class BookController extends AbstractBaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BookService bookService;

	/**
	 * @Title: getBookList
	 * @Description: 得到某书商书列表，含视频数量
	 * @param book
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getBookList")
	@ResponseBody
	public IRestMessage getBookList(Book book) {
		IRestMessage msg = getRestMessage();
		try {
			List<Book> list = bookService.getBookList(book);
			if (null != list && list.size() > 0) {
				msg.setCode(ErrorMessage.SUCCESS.getCode());
				msg.setResult(list);
			} else {
				msg.setCode(ErrorMessage.RESULT_EMPTY.getCode());
			}
		} catch (Exception e) {
			logger.error("书列表查询失败==>" + ExceptionUtils.getStackTrace(e));
			msg.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return msg;
	}

	/**
	 * @Title: addBook
	 * @Description: 添加书时根据预定数量添加题
	 * @param book
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/addBook")
	@ResponseBody
	public IRestMessage addBook(@Valid Book book, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			bookService.addBook(book);
			iRestMessage.setCode(ErrorMessage.ADD_SUCCESS.getCode());
			iRestMessage.setMessage("添加成功");
		} catch (Exception e) {
			logger.error("添加书失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: getBookInfo
	 * @Description: 得到书的详情
	 * @param id
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/getBookInfo")
	@ResponseBody
	public IRestMessage getBookInfo(@RequestParam(value = "id") Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			Book book = bookService.getBookById(id);
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setResult(book);
		} catch (Exception e) {
			logger.error("获得书详细信息失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: updateBook
	 * @Description: 更新书的信息
	 * @param book
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/updateBook")
	@ResponseBody
	public IRestMessage updateBook(@Valid Book book, BindingResult bindingResult) {
		IRestMessage iRestMessage = getRestMessage();
		if (bindingResult.hasErrors()) {
			iRestMessage.setDetail(ShincUtil.getErrorFields(bindingResult));
			return iRestMessage;
		}
		try {
			bookService.updateBook(book);
			iRestMessage.setCode(ErrorMessage.UPDATE_SUCCESS.getCode());
			iRestMessage.setMessage("修改成功");
		} catch (Exception e) {
			logger.error("更新书失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}

	/**
	 * @Title: deleteBook
	 * @Description: 删除，有视频则不能删除
	 * @param id
	 * @param bindingResult
	 * @return IRestMessage
	 */
	@RequestMapping(value = "/deleteBook")
	@ResponseBody
	public IRestMessage deleteBook(@RequestParam(value = "id") Integer id) {
		IRestMessage iRestMessage = getRestMessage();
		try {
			Book book = new Book();
			book.setId(id);
			// 书下有视频则不能删除
			if (bookService.isHasVideo(book)) {
				iRestMessage.setCode(ErrorMessage.DELETE_FAILED.getCode());
				iRestMessage.setMessage("该书下已有视频存在暂不支持删除");
				return iRestMessage;
			}
			bookService.deleteBookById(book.getId());
			iRestMessage.setCode(ErrorMessage.SUCCESS.getCode());
			iRestMessage.setMessage("删除成功");
		} catch (Exception e) {
			logger.error("删除书失败==>" + ExceptionUtils.getStackTrace(e));
			iRestMessage.setCode(ErrorMessage.ERROR_DEFAULT.getCode());
		}
		return iRestMessage;
	}
}
