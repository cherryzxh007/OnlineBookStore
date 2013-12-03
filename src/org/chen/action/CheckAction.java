package org.chen.action;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.DeliveryDao;
import org.chen.table.Book;
import org.chen.table.Delivery;
import org.chen.util.DisplayCart;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 结算时的action
 * @author ChenZhongPu
 *
 */
public class CheckAction extends ActionSupport {
	
	private DisplayCart displayCart;
	private List<Book> books;
	private List<Delivery> deliveries;
    private boolean cartEmpty;
    private DeliveryDao deliveryDao;
    
	public DisplayCart getDisplayCart() {
		return displayCart;
	}

	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public boolean isCartEmpty() {
		return cartEmpty;
	}

	public void setCartEmpty(boolean cartEmpty) {
		this.cartEmpty = cartEmpty;
	}

	
	public void setDisplayCart(DisplayCart displayCart) {
		this.displayCart = displayCart;
	}
/**
 * 默认方法，显示购物车
 */
	public String execute(){
		ActionContext.getContext().setLocale(Locale.US);
		if(ActionContext.getContext().getSession().containsKey("theUser"))
		{
			@SuppressWarnings("rawtypes")
			Map map = ActionContext.getContext().getSession();
			if(map.containsKey("BItems"))
			{
				String isbn = map.get("BItems").toString();
				setBooks(displayCart.getCartBooks(isbn));
				setCartEmpty(false);
				setDeliveries(deliveryDao.getDeliveries());
				ActionContext.getContext().getSession().put("OrderBooks", books);
			}
			else {
				setCartEmpty(true);
			}
			return SUCCESS;
		}
			
		else {
			return "ToLogin";
		}
		
		
	}

}
