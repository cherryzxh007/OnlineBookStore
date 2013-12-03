package org.chen.table;
/**
 * 书评的映射类
 * @author ChenZhongPu
 *
 */
public class Rating {

	public String customerName;
	public String comment;
	public int star;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
}
