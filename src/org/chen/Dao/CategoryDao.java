package org.chen.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.chen.table.Category;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 数据库表 Category 的 Dao
 * @author ChenZhongPu
 *
 */
public class CategoryDao {

	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
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
}
