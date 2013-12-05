package org.chen.table;

import java.sql.Timestamp;

/**
 * 用于显示的Order,个人空间
 * @author ChenZhongPu
 *
 */
public class DisplayOrder {

	private Book book;
	private String timestamp;
	private String status;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
    
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
