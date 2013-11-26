package org.chen.action;

import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 书本详情的Action;
 * 依据ISBN信息获取文本详细信息
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
		
		// 设置地区，语言
				ActionContext.getContext().setLocale(Locale.US);
		return SUCCESS;
	}
}
