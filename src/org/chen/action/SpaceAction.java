package org.chen.action;

import java.util.List;
import java.util.Locale;

import org.chen.Dao.BookOrderDao;
import org.chen.Dao.GetRandomReco;
import org.chen.table.Book;
import org.chen.table.DisplayOrder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 个人空间的action
 * @author ChenZhongPu
 *
 */
public class SpaceAction extends ActionSupport {

	private int userid;
	
	private List<DisplayOrder> displayOrders;
	private BookOrderDao bookOrderDao;
	
	private List<Book> mightLikes;
	private GetRandomReco recoDao;
	
	public GetRandomReco getRecoDao() {
		return recoDao;
	}

	public void setRecoDao(GetRandomReco recoDao) {
		this.recoDao = recoDao;
	}

	public List<Book> getMightLikes() {
		return mightLikes;
	}

	public void setMightLikes(List<Book> mightLikes) {
		this.mightLikes = mightLikes;
	}

	public List<DisplayOrder> getDisplayOrders() {
		return displayOrders;
	}

	public void setDisplayOrders(List<DisplayOrder> displayOrders) {
		this.displayOrders = displayOrders;
	}


	
	
	public BookOrderDao getBookOrderDao() {
		return bookOrderDao;
	}

	public void setBookOrderDao(BookOrderDao bookOrderDao) {
		this.bookOrderDao = bookOrderDao;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	public String execute()
	{
		ActionContext.getContext().setLocale(Locale.US);
		displayOrders = bookOrderDao.getOrdersByCusId(userid);
		mightLikes = recoDao.getRecommentBooks();
		return SUCCESS;
	}
}
