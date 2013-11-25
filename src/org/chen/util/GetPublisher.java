package org.chen.util;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 
 * @author ChenZhongPu
 *
 */
public class GetPublisher {


	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public String getPublisherList() throws SQLException
	{
		StringBuilder publisherLsit = new StringBuilder(); 
		List rows = jt.queryForList("select publisher_name from publisher");
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			Map map = (Map) iterator.next();
			publisherLsit.append(map.get("publisher_name")+"|");
			
		}
		return publisherLsit.toString();
	}
	
}
