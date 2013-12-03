package org.chen.table;
/**
 * 送货方式delivery的映射类
 * @author ChenZhongPu
 *
 */
public class Delivery {

	private int deli_id;
	private float charge;
	private String detail;
	public int getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(int deli_id) {
		this.deli_id = deli_id;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
