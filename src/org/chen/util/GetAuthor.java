package org.chen.util;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 获取 author 列表，用以Ajax调用
 * @author ChenZhongPu
 *
 */
public class GetAuthor {
	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public String getAuthorList() throws SQLException
	{
		StringBuilder authorLsit = new StringBuilder(); 
		List rows = jt.queryForList("select author_name from author");
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			Map map = (Map) iterator.next();
			authorLsit.append(map.get("author_name")+"|");
			
		}
		return authorLsit.toString();
	}

}
