package org.chen.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 管理员事务的dao
 * @author ChenZhongPu
 *
 */
public class AdminDao {

	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public boolean isValid(String email, String pwd)
	{
		
		int rows = jt.queryForInt("select Count(*) from db_admin where dba_email=?", 
				new Object[]{email}); 
		if(rows==0) return false;
	    String dbPwd = jt.queryForObject("select dba_pwd from db_admin where dba_email=?",
	    		new Object[]{email},
	    		java.lang.String.class);
	    if(dbPwd.equals(pwd)) return true;
	    else
		return false;
	}
}
