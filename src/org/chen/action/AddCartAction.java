package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 添加至购物车，ajax实现
 * @author ChenZhongPu
 *
 */
public class AddCartAction extends ActionSupport {

	private String isbn;
	private int bookNum;
	private InputStream result;
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public InputStream getResult() {
		return result;
	}

	public void setResult(InputStream result) {
		this.result = result;
	}
	
	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String execute()
	{
		
		ActionContext.getContext().setLocale(Locale.US);
		if(ActionContext.getContext().getSession().containsKey("BItems"))
		{
			String items = ActionContext.getContext().getSession().get("BItems").toString();
			//System.out.println(items);
			ActionContext.getContext().getSession().put("BItems", items+","+isbn);
			int num = (int) ActionContext.getContext().getSession().get("MyCartNum");
			ActionContext.getContext().getSession().put("MyCartNum",num++);
			bookNum = num;
			
		}
		else {
			ActionContext.getContext().getSession().put("BItems", isbn);
			ActionContext.getContext().getSession().put("MyCartNum", 1);
		    bookNum = 1;
		    
		}
		String outPut = String.valueOf(getBookNum());
		result = new ByteArrayInputStream(outPut.getBytes());
		return SUCCESS;
	}
	
}
