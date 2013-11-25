package org.chen.table;
/**
 * 数据库表Publisher的类的映射
 * @author ChenZhongPu
 *
 */
public class Author {

	private String authord_id;
	private String author_name;
	private String author_intro;
	public String getAuthord_id() {
		return authord_id;
	}
	public void setAuthord_id(String authord_id) {
		this.authord_id = authord_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_intro() {
		return author_intro;
	}
	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}
	
}
