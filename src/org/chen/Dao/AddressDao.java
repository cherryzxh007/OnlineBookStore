package org.chen.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.chen.table.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/**
 * 管理地址信息的Dao
 * @author ChenZhongPu
 *
 */
public class AddressDao {

	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public boolean addAddress(final Address address)
	{
		
		try{
			jt.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					String sql = "insert into address"
							+ "(customer_id,recipient_name,recipient_phone,"
							+ "postcode,fulladdress) values(?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, address.getCustomer_id());
					ps.setString(2, address.getRece_name());
					ps.setString(3, address.getRece_phone());
					ps.setString(4, address.getPostCode());
					ps.setString(5, address.getAddress());
					return ps;
				}
			});
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	
		
	}
}
