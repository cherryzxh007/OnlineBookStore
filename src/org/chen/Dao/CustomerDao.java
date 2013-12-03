package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.chen.table.Customer;
import org.chen.util.BookConstont;
import org.chen.util.EncryptPwd;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * 顾客 Dao
 * @author ChenZhongPu
 *
 */
public class CustomerDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean isUnique(String email)
	{
		int rows = jt.queryForInt("select Count(*) from customer where customer_email=?",
				new Object[]{email});
		if(rows>0) return false;
		return true;
	}
	/**
	 * 
	 * @param customer
	 */
	public void add(final Customer customer)
	{
		jt.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into customer"
						+ "(customer_pwd,customer_email,customer_alias,customer_phone,customer_iconid) "
						+ "values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, customer.getPwd());
				ps.setString(2, customer.getEmail());
				ps.setString(3, customer.getAlias());
				ps.setString(4, customer.getPhone());
				ps.setInt(5, customer.getIconid());
				return ps;
			}
			
		});
	}
	
	/**
	 * 
	 * @param email
	 * @param pwd
	 * @return
	 */
	public boolean isValid(String email, String pwd)
	{
		if(isUnique(email))
		{
			return false;
		}
		String real_pwd = EncryptPwd.getEncryption(pwd);
		String pwd_row = jt.queryForObject("select customer_pwd from customer where customer_email=?", 
				new Object[]{email}, 
				java.lang.String.class);
		if(real_pwd.equals(pwd_row))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public Customer getCustomerByMail(final String email)
	{
		final Customer customer = new Customer();
		jt.query("select * from customer where customer_email=?",
				new Object[]{email},
				new RowCallbackHandler(){
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						customer.setAlias(rs.getString("customer_alias"));
						int icon = rs.getInt("customer_iconid");
						customer.setIconPath(BookConstont.ICONPATH+icon+BookConstont.IMGSUFFIX);
						customer.setPhone(rs.getString("customer_phone"));
						customer.setEmail(email);
						customer.setId(rs.getInt("customer_id"));
					}
			
		});
		return customer;
	}
	/**
	 * 
	 * @param newPwd
	 */
	public void changePwd(String newPwd)
	{
		
	}
	
	public String getUserNameById(int id)
	{
		String name = jt.queryForObject("select customer_alias from customer where customer_id=?",
				new Object[]{id}, 
				java.lang.String.class);
		return name;
	}
	
}
