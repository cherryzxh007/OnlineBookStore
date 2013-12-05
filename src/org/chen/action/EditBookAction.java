package org.chen.action;

import org.chen.Dao.BasicBookDao;

import sun.security.pkcs.PKCS10;

import com.opensymphony.xwork2.Action;

/**
 * 编辑图书的action
 * @author ChenZhongPu
 *
 */
public class EditBookAction {

	private transient float price;
	private transient int amount;
	private transient String isbn;
	private transient BasicBookDao basicBookDao;
	private boolean ok;
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}
	public String execute()
	{
		
		if(basicBookDao.isHas(isbn))
		{
			basicBookDao.modify(isbn, price, amount);
			ok = true;
		}
		else {
			ok = false;
		}
		
		return Action.SUCCESS;
	}
	
	public String delBook()
	{
		
		
		return Action.SUCCESS;
	}
}
