package org.chen.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Book;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 
 * @author ChenZhongPu
 *
 */
public class GetRandomReco implements RecoInterfaceDao {
	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public List<Book> getRecommentBooks() {
		
		try{
			
			List<Book> books = new ArrayList<Book>();
			int allCount = jt.queryForInt("select Count(*) from book");
			List rows;
			if(allCount<6)
			{
			   rows = jt.queryForList("select * from book");
			}
			else {
				int offset = (int) (Math.random()*(allCount-5));
				rows = jt.queryForList("select * from book offset ? limit 5",new Object[]{offset});
			}
			
			Iterator iterator = rows.iterator();
			while(iterator.hasNext())
			{
				Book book = new Book();
				Map map = (Map) iterator.next();
				book.setIsbn(map.get("isbn").toString());
				String title = map.get("title").toString();
				if(title.length()>20) title = title.substring(0, 17);
				book.setTitle(title);
				book.setPrice((float)map.get("price"));
				book.setImgPath(map.get("coverimage_path").toString());
				books.add(book);
				
			}
		return books;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
