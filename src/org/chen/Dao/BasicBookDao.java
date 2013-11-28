package org.chen.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Author;
import org.chen.table.Book;
import org.chen.util.BookConstont;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * Book相关基础Dao
 * @author ChenZhongPu
 *
 */
public class BasicBookDao {

	private JdbcTemplate jt;
	private PublisherDao publisherDao;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}


	/**
	 * 根据Category的id返回书
	 * @param id表示分类的id,num表示返回书的本数
	 * @return
	 */
	public List<Book> getBooksByCateId(int id,int num)
	{
		try {
			List<Book> books = new ArrayList<Book>();
			List rows = jt.queryForList("select isbn from book_category where category_id=? offset 0 limit ?",
					new Object[]{id,num});
			Iterator iterator = rows.iterator();
			while(iterator.hasNext())
			{
				Map map = (Map) iterator.next();
				Book book = getIndexBookByIsbn(map.get("isbn").toString());
				books.add(book);	
			}
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 通过ISBN获取首页所需书的信息,
	 * isbn,图片路径，价格
	 * @return
	 */
	public Book getIndexBookByIsbn(final String isbn)
	{
		final Book book = new Book();
		jt.query("select * from book where isbn=?",
				new Object[]{isbn}, 
				new RowCallbackHandler(){
					@Override
					public void processRow(ResultSet resultSet) throws SQLException {
						book.setIsbn(isbn);
						book.setImgPath(resultSet.getString("coverimage_path"));
						book.setPrice(resultSet.getFloat("price"));
						String title = resultSet.getString("title");
						if(title.length()>18) title = title.substring(0,17);
						book.setTitle(title);
					}
			
		});
		return book;	
	}
	
	/**
	 * 利用isbn获取book的详情；
	 * 在书本详情页进行展示。
	 * @param isbn
	 * @return
	 */
	public Book getBookDetailByIsbn(final String isbn){
		final Book book = new Book();
		jt.query("select * from book where isbn=?", 
				new Object[]{isbn},
				new RowCallbackHandler(){
					@SuppressWarnings("deprecation")
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						book.setIsbn(rs.getString("isbn"));
						book.setPrice(rs.getFloat("price"));
						book.setEdition(rs.getShort("edition"));
						book.setImgPath(BookConstont.BIMG+isbn+BookConstont.IMGSUFFIX);
						book.setTitle(rs.getString("title"));
						book.setAuthor(getAuthorByIsbn(isbn));
						book.setPublisher_name(publisherDao.getNamebyId(rs.getInt("publisher_id")));
						book.setIntro(rs.getString("book_intro"));
						String intro = book.getIntro();
						book.setIntroP1(intro.substring(0, 500));
						book.setIntroP2(intro.substring(501, 1000));
						book.setIntroP3(intro.substring(1001, 1500));
						book.setIntroP4(intro.substring(1501,1878));
					    System.out.println(intro.length());
						book.setPublisher_date(rs.getDate("publication_date").toString());
					}
			
		});
		return book;
	}
	
	/**
	 * 利用isbn从数据库的视图获取该书的作者信息
	 * @param isbn
	 * @return
	 */
	public List<Author> getAuthorByIsbn(String isbn)
	{
		try {
			List<Author> authors = new ArrayList<Author>();
			
			List rows = jt.queryForList("select * from BookAuthorView where isbn=?", 
					new Object[]{isbn});   
	        Iterator iterator = rows.iterator();
            while(iterator.hasNext())
            {
            	Author author = new Author();
            	Map map = (Map) iterator.next();
            	author.setAuthor_name(map.get("author_name").toString());
            	authors.add(author);
            }
            return authors;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;	
		}
		
	}
	
}
