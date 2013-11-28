package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.chen.table.Customer;
import org.chen.util.EncryptPwd;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 顾客的Dao
 * @author ChenZhongPu
 *
 */
public class CustomerDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * 判断是否有相同的邮箱
	 * @param email
	 * @return true表示唯一，可以插入；false表示已有相同。
	 */
	public boolean isUnique(String email)
	{
		int rows = jt.queryForInt("select Count(*) from customer where customer_email=?",
				new Object[]{email});
		if(rows>0) return false;
		return true;
	}
	/**
	 * 添加用户。注册时使用。
	 * @param customer
	 */
	public void add(final Customer customer)
	{
		jt.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into customer"
						+ " (customer_pwd,customer_email,customer_alias,customer_phone,customer_iconid) "
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
	 * 登录时判断用户是否合法。
	 * @return
	 */
	public boolean isValid(String email, String pwd)
	{
		String real_pwd = EncryptPwd.getEncryption(pwd);
		String pwd_row = jt.queryForObject("select customer_pwd from customer where customer_email=?", 
				new Object[]{}, 
				java.lang.String.class);
		if(real_pwd.equals(pwd_row))
		{
			return true;
		}
		return false;
	}
	/**
	 * 修改密码，暂不实现
	 * @param newPwd
	 */
	public void changePwd(String newPwd)
	{
		
	}
	
}
