package org.chen.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �鱾�����Action;
 * ����ISBN��Ϣ��ȡ�ı���ϸ��Ϣ
 * @author ChenZhongPu
 *
 */
public class BookDetailAction extends ActionSupport {

	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String execute() throws Exception{
		
		
		return SUCCESS;
	}
}
