package org.chen.table;

import java.io.Serializable;

/**
 * ���ݿ��Category��ӳ����
 * @author ChenZhongPu
 *
 */
public class Category implements Serializable {

	private int categoryId;
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString()
	{
		return getCategoryName();
	}
	
}
