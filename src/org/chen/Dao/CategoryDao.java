package org.chen.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Book;
import org.chen.table.Category;
import org.chen.table.SearchBlock;
import org.chen.util.BookConstont;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * ��ݿ�� Category �� Dao
 * @author ChenZhongPu
 *
 */
public class CategoryDao {

	private JdbcTemplate jt;

	private BasicBookDao basicBookDao;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}

	public List<Category> getMainCategory()
	{
		List<Category> mainCategories = new ArrayList<Category>();
		
		List rows = jt.queryForList("select distinct category_id from subcategory");
		Iterator iterator = rows.iterator();
		while(iterator.hasNext()){
			Category category = new Category();
			Map map = (Map) iterator.next();
			int id = (int) map.get("category_id");
			String name = getCatNameById(id);
			category.setCategoryId(id);
			category.setCategoryName(name);
			mainCategories.add(category);
		}
		return mainCategories;
	}
	/**
	 * 通过图书的所在分类名，获取分类id.
	 * @param name
	 * @return
	 */
	public int getCatIdByName(String name)
	{
		try{
			int id = jt.queryForObject("select category_id from category where category_name=?",
					new Object[]{name},
					java.lang.Integer.class);
			return id;
		}catch(Exception e)
		{
			e.printStackTrace();
			return 500001;
		}
	}
	
	public String getCatNameById(int id)
	{
		try{
			String name = jt.queryForObject("select category_name from category where category_id=?",
					new Object[]{id},
					java.lang.String.class);
			return name;
		}catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
		
	}
	
	public List<Category> getSubCategories(int id){
		List<Category> subCategories = new ArrayList<Category>();
		List rows = jt.queryForList("select subcategory_id from subcategory where category_id=?",
				new Object[]{id});
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			Category subCategory = new Category();
			Map map = (Map) iterator.next();
			int subId = (int) map.get("subcategory_id");
			String subName = getCatNameById(subId);
			subCategory.setCategoryId(subId);
			subCategory.setCategoryName(subName);
			subCategories.add(subCategory);
			
		}
		return subCategories;
	}
	
	/**
	 * 根据分类id,获取该分类的图书
	 * @return
	 */
	public List<Book> getBooksByCateId(int id){
		List<Book> books = new ArrayList<Book>();
		List rows = jt.queryForList("select isbn from book_category where category_id=?",
				new Object[]{id});
		Iterator iterator = rows.iterator();
		while(iterator.hasNext())
		{
			Map map = (Map) iterator.next();
			String isbn = map.get("isbn").toString();
			Book book = basicBookDao.getIndexBookByIsbn(isbn);
			books.add(book);
		}
		return books;
	}
	
	public int getMainBySubId(int subId)
	{
		int mainId = jt.queryForObject("select category_id from subcategory where subcategory_id=?",
				new Object[]{subId},
				java.lang.Integer.class);
		return mainId;
	}
	/**
	 * 根据分类的id,返回搜索Block列表。
	 * @param id
	 * @return
	 */
	public List<SearchBlock> getSearchBlocksByCateId(int id)
	{
		List<SearchBlock> blocks = new ArrayList<SearchBlock>();
		List<Book> books = getBooksByCateId(id);
		int rows = (int) Math.ceil((double)books.size()/BookConstont.BLOCKSIZE);
		for(int i = 0;i<rows;i++)
		{
			SearchBlock searchBlock = new SearchBlock();
			int end = i*BookConstont.BLOCKSIZE+BookConstont.BLOCKSIZE;
			if(end>books.size()) end=books.size();
			// sublist是前闭后开
			searchBlock.setBooks(books.subList(i*BookConstont.BLOCKSIZE, end));
			blocks.add(searchBlock);
		}
	/*	SearchBlock searchBlock=new SearchBlock();
		for(int i=0;i<books.size();i++)
		{
			if(i!=0 && (i%BookConstont.BLOCKSIZE)==0)
			{
				blocks.add(searchBlock);
				searchBlock=new SearchBlock();
			}
			searchBlock.getBooks().add(books.get(i));
		}
		if(searchBlock.getBooks().size()==0)
		{
			blocks.add(searchBlock);
			searchBlock=new SearchBlock();
		}*/
		return blocks;
	}
}
