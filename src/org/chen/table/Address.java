package org.chen.table;
/**
 * 地址的映射类
 * @author ChenZhongPu
 *
 */
public class Address {

	private int customer_id;
	private String rece_name;
	private String rece_phone;
	private String postCode;
	private String address;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getRece_name() {
		return rece_name;
	}
	public void setRece_name(String rece_name) {
		this.rece_name = rece_name;
	}
	public String getRece_phone() {
		return rece_phone;
	}
	public void setRece_phone(String rece_phone) {
		this.rece_phone = rece_phone;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
