package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.chen.table.Customer;
import org.chen.util.EncryptPwd;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * �˿͵�Dao
 * @author ChenZhongPu
 *
 */
public class CustomerDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	/**
	 * �ж��Ƿ�����ͬ������
	 * @param email
	 * @return true��ʾΨһ�����Բ��룻false��ʾ������ͬ��
	 */
	public boolean isUnique(String email)
	{
		int rows = jt.queryForInt("select Count(*) from customer where customer_email=?",
				new Object[]{email});
		if(rows>0) return false;
		return true;
	}
	/**
	 * ����û���ע��ʱʹ�á�
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
	 * ��¼ʱ�ж��û��Ƿ�Ϸ���
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
	 * �޸����룬�ݲ�ʵ��
	 * @param newPwd
	 */
	public void changePwd(String newPwd)
	{
		
	}
	
}
