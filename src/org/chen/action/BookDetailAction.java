package org.chen.action;

import java.util.List;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;
import org.chen.util.GetSimilarBooks;
import org.chen.util.GetSimilarBooksByCate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 显示书本详情
 * @author ChenZhongPu
 *
 */
public class BookDetailAction extends ActionSupport {

	private String isbn;

	private BasicBookDao basicBookDao;
	private Book book;
	private List<Book> similarBooks;
	private List<Book> similarBooks2;
	private GetSimilarBooksByCate similarFac;
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
	
	public List<Book> getSimilarBooks() {
		return similarBooks;
	}

	public void setSimilarBooks(List<Book> similarBooks) {
		this.similarBooks = similarBooks;
	}
    

	public List<Book> getSimilarBooks2() {
		return similarBooks2;
	}

	public void setSimilarBooks2(List<Book> similarBooks2) {
		this.similarBooks2 = similarBooks2;
	}

	public void setSimilarFac(GetSimilarBooksByCate similarFac) {
		this.similarFac = similarFac;
	}

	public String execute() throws Exception{
		WebApplicationContext ctx =
				WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		similarFac = (GetSimilarBooksByCate) ctx.getBean("getSimilar");
				ActionContext.getContext().setLocale(Locale.US);
			    setBook(basicBookDao.getBookDetailByIsbn(getIsbn()));
			    setSimilarBooks(similarFac.getSimilar(getIsbn()));
			    setSimilarBooks2(similarFac.getSimilar(getIsbn()));
		return SUCCESS;
	}
}
