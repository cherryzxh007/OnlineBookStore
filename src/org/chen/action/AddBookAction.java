package org.chen.action;

import org.chen.Dao.AddBookDao;
import org.chen.Dao.AuthorDao;
import org.chen.Dao.BookAuthorDao;
import org.chen.Dao.PublisherDao;
import org.chen.table.Book;

import com.opensymphony.xwork2.ActionSupport;

public class AddBookAction extends ActionSupport {

	private AddBookDao addBookDao;
	private PublisherDao pubDao;
	private AuthorDao authorDao;
	private BookAuthorDao bookAuthorDao;
	/**
	 * 利用OGNL完成类型转换
	 */
    private Book book;
    /**
     * 需得到publisher，author的id
     */
    private String publisher;
    private String author;
	public void setAddBookDao(AddBookDao addBookDao) {
		this.addBookDao = addBookDao;
	}
	
	public void setPubDao(PublisherDao pubDao) {
		this.pubDao = pubDao;
	}

	
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	
	public void setBookAuthorDao(BookAuthorDao bookAuthorDao) {
		this.bookAuthorDao = bookAuthorDao;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
/**
 * 添加书的主逻辑
 */
	public String execute() throws Exception{
		try{
		
			if(!pubDao.isContains(publisher))
			{
				// 如果数据库里不存在该出版社，添加
				pubDao.add(publisher);
			}
			
			// 设置所添加书的出版社的id
			getBook().setPublisher_id(pubDao.getIdbyName(publisher));
			
			if(!authorDao.isContains(author))
			{
				// 如果数据库里不存在该作者，添加
				authorDao.add(author);
			}
			// 向book表添加数据
			addBookDao.add(book);
			//向书_作者联系表里添加数据
			bookAuthorDao.add(authorDao.getIdByName(author), book.getIsbn());	
			return SUCCESS;
		}catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
			
	}
	
}
