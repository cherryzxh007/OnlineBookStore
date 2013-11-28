package org.chen.action;

import java.util.Locale;

import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 书本详情的Action;
 * 依据ISBN信息获取文本详细信息
 * @author ChenZhongPu
 *
 */
public class BookDetailAction extends ActionSupport {

	private String isbn;

	private BasicBookDao basicBookDao;
	private Book book;
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String execute() throws Exception{
		
		// 设置地区，语言
				ActionContext.getContext().setLocale(Locale.US);
			    setBook(basicBookDao.getBookDetailByIsbn(getIsbn()));
		return SUCCESS;
	}
}
