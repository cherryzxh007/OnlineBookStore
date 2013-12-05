package org.chen.action;

import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;

import com.opensymphony.xwork2.Action;

/**
 * 管理员搜索欲修改的书，Ajax实现
 * @author ChenZhongPu
 *
 */
public class AdminAjaxAction{

	private String isbn;

	private int quality;
	private float price;
	private String imgPath;
	private boolean contains;
	

	public boolean isContains() {
		return contains;
	}

	public void setContains(boolean contains) {
		this.contains = contains;
	}

	private transient BasicBookDao basicBookDao;
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}

	public String execute()
	{
		if(basicBookDao.isHas(isbn))
		{
			contains = true;
			Book book = basicBookDao.getAdminBook(isbn);
			quality = book.getStock_qty();
			price = book.getPrice();
			imgPath = book.getImgPath();
		}
		else {
			contains = false;
		}
		
		return Action.SUCCESS;
	}
	
}
