package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.chen.table.BookOrder;
import org.chen.table.Customer;
import org.chen.table.Orders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 注意！！！这个Dao不再使用！
 * 操作订单order的dao
 * @author ChenZhongPu
 *
 */
public class OrderDao {
 
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/*
	 * 未完成
	 */
	public void addOrder(final List<BookOrder> bookOrders, Customer customer)
	{
		int cusId = customer.getId();
		for(BookOrder bookOrder : bookOrders)
		{
			jt.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String sql = "insert into orders(customer_id,address_id,"
							+ "order_time,order_status,"
							+ "ship_method) values(?,?,)";
					return null;
				}
				
			});
		}
	}
	
}
