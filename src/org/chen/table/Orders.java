package org.chen.table;

import java.sql.Timestamp;

/**
 * Order的映射类
 * @author ChenZhongPu
 *
 */
public class Orders {

	private int customer_id;
	private int address_id;
	private Timestamp time;
	private String order_status;
	private int deli_id;
	private float postage;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(int deli_id) {
		this.deli_id = deli_id;
	}
	public float getPostage() {
		return postage;
	}
	public void setPostage(float postage) {
		this.postage = postage;
	}
} 
