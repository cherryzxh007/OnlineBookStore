package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;


/**
 * 处理Publisher的Dao
 * @author ChenZhongPu
 *
 */
public class PublisherDao {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 检查是否包含该出版社
	 * @param pubName
	 * @return
	 */
	public boolean isContains(String pubName) 
	{
	
		int result = jt.queryForInt("select Count(*) from publisher where publisher_name=?"
				,new Object[]{pubName},new int[]{Types.VARCHAR});
		if(result>0) return true;
		return false;
	}
	/**
	 * 添加出版社
	 * @param pubName
	 */
	public void add(final String pubName)
	{
	   jt.update(new PreparedStatementCreator(){

		@Override
		public PreparedStatement createPreparedStatement(Connection con)
				throws SQLException {
			String sql = "insert into publisher (publisher_name) values(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pubName);
			return ps;
		}
		   
	   });
	}
	/**
	 * 通过出版社名字找其id
	 * @param pubName
	 * @return
	 */
	public int getIdbyName(final String pubName)
	{
	    int id =  jt.queryForObject("select publisher_id from publisher where publisher_name=?", 
	    		 new Object[]{pubName}, java.lang.Integer.class);
		return id;
	}
	/**
	 * 通过出版社id找名字。
	 * @param id
	 * @return
	 */
	public String getNamebyId(final int id)
	{
		String name = jt.queryForObject("select publisher_name from publisher where publisher_id=?",
				new Object[]{id}, java.lang.String.class);
		return name;
	}

}
