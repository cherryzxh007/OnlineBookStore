package org.chen.table;

import java.util.List;

/**
 * 数据库表Book的类的映射
 * @author ChenZhongPu
 *
 */
public class Book {
	/**
	 * isbn , title是必须属性
	 */
	private  String isbn;
	private  String title;
	private int publisher_id;
	private String publisher_date;
	private Short edition;
	private float price;
	private String intro;
	private String imgPath;
	private int stock_qty;

	private List<Author> author;
	private String publisher_name;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getPublisher_date() {
		return publisher_date;
	}
	public void setPublisher_date(String publisher_date) {
		this.publisher_date = publisher_date;
	}
	public Short getEdition() {
		return edition;
	}
	public void setEdition(Short edition) {
		this.edition = edition;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getStock_qty() {
		return stock_qty;
	}
	public void setStock_qty(int stock_qty) {
		this.stock_qty = stock_qty;
	}
	
	
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
    
	
}
