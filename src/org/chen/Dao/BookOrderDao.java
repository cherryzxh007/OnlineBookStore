package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Book;
import org.chen.table.BookOrder;
import org.chen.table.Customer;
import org.chen.table.DisplayOrder;
import org.chen.util.GetCurrentTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 书，订单的dao
 * @author ChenZhongPu
 *
 */
public class BookOrderDao {

	private JdbcTemplate jt;

	private BasicBookDao basicBookDao;
	
	public BasicBookDao getBasicBookDao() {
		return basicBookDao;
	}
	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 获取BookOrder列表，利用List泛型，List保存book
	 * @param books
	 * @return
	 */
	public List<BookOrder> getBookOrders(List<?> books,Customer customer,int ship)
	{
		int cusId = customer.getId();
		List<BookOrder> bookOrders = new ArrayList<BookOrder>();
		for(Object object:books)
		{
			Book book = (Book) object;
			BookOrder bookOrder = new BookOrder();
			bookOrder.setIsbn(book.getIsbn());
			bookOrder.setPrice(book.getPrice());
			bookOrder.setQty(1);
			bookOrder.setCusId(cusId);
			bookOrder.setTimestamp(GetCurrentTime.getTime());
			bookOrder.setShipMethod(ship);
			bookOrders.add(bookOrder);
		
		}
		return bookOrders;
	}
	/**
	 * 向数据库插入book_order的选项
	 * @param List<BookOrder> bookOrders
	 */
	public void addBookOrder(List<BookOrder> bookOrders)
	{
		for(final BookOrder bookOrder:bookOrders)
		{
		   
			jt.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
				   String sql = "insert into order_book(isbn,orderbook_qty,"
				   		+ "orderbook_price,customer_id,"
				   		+ "order_time) values(?,?,?,?,?)";
				   PreparedStatement ps = con.prepareStatement(sql);
				   ps.setString(1, bookOrder.getIsbn());
				   ps.setInt(2, bookOrder.getQty());
				   ps.setFloat(3, bookOrder.getPrice());
				   ps.setInt(4, bookOrder.getCusId());
				   ps.setTimestamp(5, bookOrder.getTimestamp());
				   return ps;
				}
				
			});
		}
		
	}
	
	/**
	 * 用于个人页面显示订单
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<DisplayOrder> getOrdersByCusId(int id)
	{
		basicBookDao.getIndexBookByIsbn("1118504224");
		List<DisplayOrder> bookOrders = new ArrayList<DisplayOrder>();
		
		List rows = jt.queryForList("select * from order_book where customer_id=?",
				new Object[]{id});
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			DisplayOrder displayOrder = new DisplayOrder();
			Map map = (Map) iterator.next();
			String isbn = map.get("isbn").toString();
			System.out.println(isbn);
			displayOrder.setBook(basicBookDao.getIndexBookByIsbn(isbn));
			displayOrder.setStatus(map.get("order_status").toString());
			//displayOrder.setTimestamp((Timestamp) map.get("order_time"));
			Timestamp timestamp = (Timestamp) map.get("order_time");
			displayOrder.setTimestamp(timestamp.getMonth()+"/"+timestamp.getDay()+", "
					+timestamp.getYear());
			bookOrders.add(displayOrder);
			
		}
		
		return bookOrders;
	}
}
