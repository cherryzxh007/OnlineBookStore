package org.chen.action;



import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.views.xslt.ArrayAdapter;
import org.chen.Dao.AdminDao;
import org.chen.Dao.CategoryDao;
import org.chen.table.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 进入管理页面使用的action
 * @author ChenZhongPu
 *
 */
public class AdminAction extends ActionSupport {
	
	private String email;
	private String pwd;
	
	private AdminDao adminDao;
	private CategoryDao cateDao;
	
	private List<String> cateList;
	public CategoryDao getCateDao() {
		return cateDao;
	}

	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}

	public List<String> getCateList() {
		return cateList;
	}

	public void setCateList(List<String> cateList) {
		this.cateList = cateList;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    

	/**
	 * 默认方法，用于管理员未登录时进入管理员的登录页面
	 */
	public String execute()
	{
		if(ActionContext.getContext().getSession().containsKey("admin"))
		{
			
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		
		
	}
	/**
	 * 管理登录时的方法，
	 * Ajax处理
	 * @return
	 */
	public String adminLogin()
	{
		
		if(adminDao.isValid(getEmail(), getPwd()))
				{
			cateList = new ArrayList<String>();
			ActionContext.getContext().getSession().put("admin", "admin");
			
			List<Category> mainCategories = cateDao.getMainCategory();
			
			ActionContext.getContext().getSession().put("mainCate", mainCategories);
			return SUCCESS;
				}
		else {
			return ERROR;
		}
		
		
	}
}
