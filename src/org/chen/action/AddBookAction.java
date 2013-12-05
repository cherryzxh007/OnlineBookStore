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
	 * 
	 */
    private Book book;
    /**
     * 
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
 * 
 */
	public String execute() throws Exception{
		try{
		
			if(!pubDao.isContains(publisher))
			{
				
				pubDao.add(publisher);
			}
			
			
			getBook().setPublisher_id(pubDao.getIdbyName(publisher));
			
			if(!authorDao.isContains(author))
			{
				
				authorDao.add(author);
			}
			
			addBookDao.add(book);
			bookAuthorDao.add(authorDao.getIdByName(author), book.getIsbn());	
			return SUCCESS;
		}catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
			
	}
	
}
