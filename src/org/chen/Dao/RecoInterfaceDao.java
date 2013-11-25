package org.chen.Dao;

import java.util.List;

import org.chen.table.Book;

/**
 * 推荐图书的接口
 * @author ChenZhongPu
 *
 */
public interface RecoInterfaceDao {

	/**
	 * 
	 * @return 推荐的图书
	 */
	List<Book> getRecommentBooks();
	
    
}
