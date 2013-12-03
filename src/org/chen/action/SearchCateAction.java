package org.chen.action;

import java.util.List;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.CategoryDao;
import org.chen.table.Book;
import org.chen.table.SearchBlock;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 点击分类按钮执行的action
 * @author ChenZhongPu
 *
 */
public class SearchCateAction extends ActionSupport {
	
	private int cateId;
	private String MainC;
	private String SubC;
    private List<SearchBlock> blocks;
    private CategoryDao categoryDao;
	
	
	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	
	public String getMainC() {
		return MainC;
	}

	public void setMainC(String mainC) {
		MainC = mainC;
	}

	public String getSubC() {
		return SubC;
	}

	public void setSubC(String subC) {
		SubC = subC;
	}

	public List<SearchBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<SearchBlock> blocks) {
		this.blocks = blocks;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
    
	

	public String execute(){
	
		ActionContext.getContext().setLocale(Locale.US);
		WebApplicationContext ctx =
				WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		categoryDao = (CategoryDao) ctx.getBean("cateDao");
		setBlocks(categoryDao.getSearchBlocksByCateId(cateId));
		return SUCCESS;
	}

}
