package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 处理Author的Dao
 * @author ChenZhongPu
 *
 */
public class AuthorDao {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
/**
 * 检查数据库是否该作者	
 * @param authorName
 * @return
 */
	public boolean isContains(String authorName)
	{
		int result = jt.queryForInt("select Count(*) from author where author_name=?"
				,new Object[]{authorName},new int[]{Types.VARCHAR});
		if(result > 0) return true;
		return false;
	}
	/**
	 * 通过作者名添加
	 * @param authorName
	 */
	public void add(final String authorName)
	{
		jt.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				 String sql = "insert into author (author_name) values (?)";
				 PreparedStatement ps = con.prepareStatement(sql);
				 ps.setString(1, authorName);
				 return ps;
			}
			
		});
	}
	/**
	 * 通过作者名、简介添加
	 * @param authorName
	 * @param authorIntro
	 */
	public void add(final String authorName, final String authorIntro){
		
		jt.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				 String sql = "insert into author (author_name,author_intro) values (?,?)";
				 PreparedStatement ps = con.prepareStatement(sql);
				 ps.setString(1, authorName);
				 ps.setString(2, authorIntro);
				 return ps;
			}
			
		});
	}
	
	/**
	 * 根据作者名获得其id
	 * @param authorName
	 * @return
	 */
	public int getIdByName(final String authorName)
	{
		int id =  jt.queryForObject("select author_id from author where author_name=?", 
	    		 new Object[]{authorName}, java.lang.Integer.class);
		return id;
	}

}
