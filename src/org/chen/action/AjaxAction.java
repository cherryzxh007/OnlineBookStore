package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.chen.util.GetAuthor;
import org.chen.util.GetPublisher;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 处理Ajax事件
 * @author ChenZhongPu
 *
 */
public class AjaxAction extends ActionSupport {
      private GetPublisher publisher;
      private GetAuthor author;
      private InputStream inStream;
	  public void setPublisher(GetPublisher publisher) {
		this.publisher = publisher;
	}
	  
	public void setAuthor(GetAuthor author) {
		this.author = author;
	}


	/**
	 * 返回Ajax所需的publisher字节流
	 * @return inputsteam
	 */
	public InputStream getResult() {
		return inStream;
	}

  /**
   * 默认方法：获取Publisher列表  
   */
	public String execute() throws Exception
	{
		String publisheList = publisher.getPublisherList();
		publisheList+="#"+author.getAuthorList();
		inStream = new ByteArrayInputStream(publisheList.getBytes());
		
		return SUCCESS;
	}
	
}
