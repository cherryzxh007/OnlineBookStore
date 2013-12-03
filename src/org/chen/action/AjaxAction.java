package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.chen.util.GetAuthor;
import org.chen.util.GetPublisher;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ����Ajax�¼�
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
	 * ����Ajax�����publisher�ֽ���
	 * @return inputsteam
	 */
	public InputStream getResult() {
		return inStream;
	}

  /**
   * Ĭ�Ϸ�������ȡPublisher�б�  
   */
	public String execute() throws Exception
	{
		String publisheList = publisher.getPublisherList();
		publisheList+="#"+author.getAuthorList();
		inStream = new ByteArrayInputStream(publisheList.getBytes());
		
		return SUCCESS;
	}
	
}
