package org.chen.table;
/**
 * 数据库表 book_author的映射类
 * @author ChenZhongPu
 *
 */
public class BookAuthor {
	private String isbn;
	private int author_id;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	

}
