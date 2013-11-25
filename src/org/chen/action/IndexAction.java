package org.chen.action;

import java.util.List;
import java.util.Locale;









import org.apache.struts2.ServletActionContext;
import org.chen.Dao.CategoryDao;
import org.chen.Dao.GetRandomReco;
import org.chen.Dao.RecoInterfaceDao;
import org.chen.table.Book;
import org.chen.table.Category;
import org.chen.table.IndexInfo;
import org.chen.util.BookConstont;
import org.chen.util.XMLReader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * ������ҳ�����е�Action�Ĵ���
 * @author ChenZhongPu
 *
 */
public class IndexAction extends ActionSupport{
	
	private CategoryDao categoryDao;
	private RecoInterfaceDao recoDao;
	/**
	 * ʵ���Է������ʾ
	 * ����session
	 */
	private void showSubCate()
	{
		
		List<Category> cate1 = categoryDao.getSubCategories(BookConstont.ART);
	    ActionContext.getContext().getSession().put("subcateArt", cate1);
		List<Category> cate2 = categoryDao.getSubCategories(BookConstont.CHILDREN);
		ActionContext.getContext().getSession().put("subcateChi", cate2);
		List<Category> cate3 = categoryDao.getSubCategories(BookConstont.LITERATURE);
		ActionContext.getContext().getSession().put("subcateLit", cate3);
		List<Category> cate4 = categoryDao.getSubCategories(BookConstont.SOCAIL);
		ActionContext.getContext().getSession().put("subcateSoc", cate4);
		List<Category> cate5 = categoryDao.getSubCategories(BookConstont.LIFE);
		ActionContext.getContext().getSession().put("subcateLif", cate5);
		List<Category> cate6 = categoryDao.getSubCategories(BookConstont.TECH);
		ActionContext.getContext().getSession().put("subcateTec", cate6);	
	}
	/**
	 * ��ʾ�Ƽ�ͼ��
	 */
	public void showReco()
	{
		List<Book> books = recoDao.getRecommentBooks();
		ActionContext.getContext().getSession().put("recoBooks", books);
	}
	/**
	 * ʵ��ҳ�����岿��
	 * @throws Exception 
	 */
	public void showMain() throws Exception
	{
		List<IndexInfo> indexs = XMLReader.readXML();
		ActionContext.getContext().getSession().put("mainPage",indexs);
	}
	/**
	 * ActionĬ�Ϸ�����
	 */
	public String execute() throws Exception
	{
		// ���õ���������
		ActionContext.getContext().setLocale(Locale.US);
		// �õ�Spring����
		WebApplicationContext ctx =
		WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		categoryDao = (CategoryDao) ctx.getBean("cateDao");
		recoDao = (GetRandomReco) ctx.getBean("recoDao");
	    showSubCate();
	    showReco();
		return SUCCESS;
		
	}

}
