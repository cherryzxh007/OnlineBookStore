package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * BookAuthor的Dao
 * @author ChenZhongPu
 *
 */
public class BookAuthorDao {
	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 向book_author表中添加数据
	 * @param author_id
	 * @param isbn
	 */
	public void add(final int author_id, final String isbn){
		jt.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into book_author (author_id,isbn) values (?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, author_id);
				ps.setString(2, isbn);
				return ps;
			}
			
		});
	}

}
