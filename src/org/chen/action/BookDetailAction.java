package org.chen.action;

import java.util.Locale;

import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �鱾�����Action;
 * ����ISBN��Ϣ��ȡ�ı���ϸ��Ϣ
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
		
		// ���õ���������
				ActionContext.getContext().setLocale(Locale.US);
			    setBook(basicBookDao.getBookDetailByIsbn(getIsbn()));
		return SUCCESS;
	}
}
