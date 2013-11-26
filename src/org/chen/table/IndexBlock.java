package org.chen.table;

import java.util.List;

/**
 * ��ʵ�洢��ҳ��Ϣ�Ŀ顣
 * ����һ������⣻3��5��ͼ��
 * @author ChenZhongPu
 *
 */
public class IndexBlock {

	private String blockTitle;
	private List<Book> books;
	private int hasImage;
	private String path;
    
	public String getBlockTitle() {
		return blockTitle;
	}
	public void setBlockTitle(String blockTitle) {
		this.blockTitle = blockTitle;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getHasImage() {
		return hasImage;
	}
	public void setHasImage(int hasImage) {
		this.hasImage = hasImage;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
