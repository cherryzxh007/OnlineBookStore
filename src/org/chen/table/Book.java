package org.chen.table;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表Book的类的映射
 * @author ChenZhongPu
 *
 */
public class Book implements Serializable{
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
	private String introP1;
	private String introP2;
	private String introP3;
	private String introP4;
	
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
	public String getIntroP1() {
		return introP1;
	}
	public void setIntroP1(String introP1) {
		this.introP1 = introP1;
	}
	public String getIntroP2() {
		return introP2;
	}
	public void setIntroP2(String introP2) {
		this.introP2 = introP2;
	}
	public String getIntroP3() {
		return introP3;
	}
	public void setIntroP3(String introP3) {
		this.introP3 = introP3;
	}
	public String getIntroP4() {
		return introP4;
	}
	public void setIntroP4(String introP4) {
		this.introP4 = introP4;
	}
	
}
