package org.chen.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Author;
import org.chen.table.Book;
import org.chen.table.Rating;
import org.chen.util.BookConstont;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * Book��ػ�Dao
 * @author ChenZhongPu
 *
 */
public class BasicBookDao {

	private JdbcTemplate jt;
	private PublisherDao publisherDao;
	private CustomerDao customerDao;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

    
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * 获取分类id下的最多num本书
	 * @param id
	 * @param num
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
	 * ͨ��ISBN��ȡ��ҳ���������Ϣ,
	 * isbn,ͼƬ·�����۸�
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
						if(title.length()>18) title = title.substring(0,16);
						book.setTitle(title);
					}
			
		});
		return book;	
	}
	
	/**
	 * ����isbn��ȡbook�����飻
	 * ���鱾����ҳ����չʾ��
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
						book.setPage(rs.getInt("page"));
						book.setPublisher_date(rs.getDate("publication_date").toString());
						if(isReviewed(isbn))
						{
							book.setRatings(getRatings(isbn));
							book.setReviewed(true);
						}
						else {
							book.setReviewed(false);
						}
						
					}
			
		});
		return book;
	}
	
	/**
	 * ����isbn����ݿ����ͼ��ȡ�����������Ϣ
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
            	author.setAuthor_intro(map.get("author_intro").toString());
            	authors.add(author);
            }
            return authors;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;	
		}
		
	}
	
	public boolean isReviewed(String isbn){
		
		int rows = jt.queryForInt("select Count(*) from book_review where isbn=?", 
				new Object[]{isbn});
		if(rows>0) return true;
		return false;
	}
	/**
	 * 获取该书的评论列表，取按时间新旧，前5个
	 * @param isbn
	 * @return
	 */
	public List<Rating> getRatings(String isbn)
	{
		List<Rating> ratings = new ArrayList<Rating>();
		List list = jt.queryForList("select * from book_review where isbn=? order by comment_time DESC offset 0 limit 5", 
				new Object[]{isbn});
		Iterator iterator = list.iterator();
	    while(iterator.hasNext())
	    {
	    	Rating rating = new Rating();
	    	Map map = (Map) iterator.next();
	    	rating.setComment(map.get("book_commetn").toString());
	    	int userId = (int)map.get("customer_id");
	        rating.setCustomerName(customerDao.getUserNameById(userId));
	        rating.setStar((int)map.get("star_level"));
	    	ratings.add(rating);
	    	
	    }
	    return ratings;
	}
	/**
	 * 根据isbn获取所在分类id
	 * @param isbn
	 * @return
	 */
	public int getCateIdbyIsbn(String isbn)
	{
		int id = jt.queryForObject("select category_id from book_category where isbn=?",
				new Object[]{isbn}, 
				java.lang.Integer.class);
		return id;
		
	}
	
}
