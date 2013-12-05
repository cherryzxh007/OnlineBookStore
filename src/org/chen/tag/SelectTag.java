package org.chen.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.chen.Dao.CategoryDao;
import org.chen.table.Category;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class SelectTag extends RequestContextAwareTag {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void doTag() throws IOException
	{
		
		
	}

	@Override
	protected int doStartTagInternal() throws Exception {
	 CategoryDao categoryDao =  (CategoryDao) this.getRequestContext().getWebApplicationContext().getBean("cateDao");
		List<Category> categories = categoryDao.getMainCategory();
		JspWriter writer = pageContext.getOut();
		for(Category c:categories)
		{
			String name = c.getCategoryName();
			int value = c.getCategoryId();
			writer.write("<option value="+value+">"+name+"</option>");
		}
		return 0;
	}
}
