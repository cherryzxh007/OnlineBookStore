package org.chen.action;

import java.util.List;
import java.util.Locale;











import org.apache.struts2.ServletActionContext;
import org.chen.Dao.CategoryDao;
import org.chen.Dao.GetRandomReco;
import org.chen.Dao.RecoInterfaceDao;
import org.chen.table.Book;
import org.chen.table.Category;
import org.chen.table.IndexBlock;
import org.chen.util.BookConstont;
import org.chen.util.GetIndexBlock;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author ChenZhongPu
 *
 */
public class IndexAction extends ActionSupport{
	
	private CategoryDao cateDao;
	private RecoInterfaceDao recoDao;
	private GetIndexBlock getBlock;
	private List<IndexBlock> blocks;
	
	public CategoryDao getCateDao() {
		return cateDao;
	}
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}
	public RecoInterfaceDao getRecoDao() {
		return recoDao;
	}
	public void setRecoDao(RecoInterfaceDao recoDao) {
		this.recoDao = recoDao;
	}
	public GetIndexBlock getGetBlock() {
		return getBlock;
	}
	public void setGetBlock(GetIndexBlock getBlock) {
		this.getBlock = getBlock;
	}
	public List<IndexBlock> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<IndexBlock> blocks) {
		this.blocks = blocks;
	}
	/**
	 * 
	 */
	private void showSubCate()
	{
		
		List<Category> cate1 = cateDao.getSubCategories(BookConstont.ART);
	    ActionContext.getContext().getSession().put("subcateArt", cate1);
		List<Category> cate2 = cateDao.getSubCategories(BookConstont.CHILDREN);
		ActionContext.getContext().getSession().put("subcateChi", cate2);
		List<Category> cate3 = cateDao.getSubCategories(BookConstont.LITERATURE);
		ActionContext.getContext().getSession().put("subcateLit", cate3);
		List<Category> cate4 = cateDao.getSubCategories(BookConstont.SOCAIL);
		ActionContext.getContext().getSession().put("subcateSoc", cate4);
		List<Category> cate5 = cateDao.getSubCategories(BookConstont.LIFE);
		ActionContext.getContext().getSession().put("subcateLif", cate5);
		List<Category> cate6 = cateDao.getSubCategories(BookConstont.TECH);
		ActionContext.getContext().getSession().put("subcateTec", cate6);	
	}
	/**
	 * 
	 */
	public void showReco()
	{
		List<Book> books = recoDao.getRecommentBooks();
		ActionContext.getContext().getSession().put("recoBooks", books);
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void showMain() throws Exception
	{
		setBlocks(getBlock.GetBlocks());
	}
	 /**
     * Action默认方法。
     */
    public String execute() throws Exception
    {
            // 设置地区，语言
            ActionContext.getContext().setLocale(Locale.US);
            showSubCate();
            showReco();
            showMain();
            return SUCCESS;
            
    }

}
