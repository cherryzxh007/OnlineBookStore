package org.chen.table;

import java.sql.Timestamp;

/**
 * Book_Order的映射类
 * @author ChenZhongPu
 *
 */
public class BookOrder {

	private String isbn;
	private int qty;
	private float price;
	private int cusId;
	private int shipMethod;
	private Timestamp timestamp;
	private int addId;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getShipMethod() {
		return shipMethod;
	}
	public void setShipMethod(int shipMethod) {
		this.shipMethod = shipMethod;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	
    
}
