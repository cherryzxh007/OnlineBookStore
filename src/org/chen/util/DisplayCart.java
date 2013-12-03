package org.chen.util;

import java.util.ArrayList;
import java.util.List;

import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;



/**
 * 工具类，显示购物车信息
 * @author ChenZhongPu
 *
 */
public class DisplayCart {
	
	BasicBookDao basicBookDao;
	

	public BasicBookDao getBasicBookDao() {
		return basicBookDao;
	}


	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}


	/**
	 * 
	 * @param isbns isbn的列表，中间用，隔开
	 * @return
	 */
	public List<Book> getCartBooks(String isbn)
	{
		String[] isbns = isbn.split(",");
		List<Book> books = new ArrayList<>();
		for(String singleIsbn:isbns){
			Book book = new Book();
			book = basicBookDao.getIndexBookByIsbn(singleIsbn);
			books.add(book);
		}
		return books;
	}
}
