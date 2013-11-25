package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.chen.converter.ConvertToDate;
import org.chen.table.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 添加Book的Dao
 * @author ChenZhongPu
 *
 */

public class AddBookDao {
	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 向数据库插入书
	 * @param book
	 */
	public void add(final Book book)
	{
		jt.update(new PreparedStatementCreator(
				) {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into book "
						+ "(isbn,title,publisher_id,publication_date,edition,"
						+ "price,stock_qty,book_intro,coverimage_path)"
						+ " values"
						+ "(?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, book.getIsbn());
				ps.setString(2, book.getTitle());
				ps.setInt(3, book.getPublisher_id());
				ps.setDate(4, ConvertToDate.getDate(book.getPublisher_date()));
				ps.setInt(5, book.getEdition());
				ps.setDouble(6, book.getPrice());
				ps.setInt(7, book.getStock_qty());
				ps.setString(8, book.getIntro());
				ps.setString(9, book.getImgPath());
				return ps;
			}
		});
		
	}

}
