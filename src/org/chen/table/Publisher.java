package org.chen.table;

import java.io.Serializable;

/**
 * 数据库表Publisher的类的映射
 * @author ChenZhongPu
 *
 */
public class Publisher implements Serializable{

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
