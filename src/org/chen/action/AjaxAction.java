package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.chen.util.GetAuthor;
import org.chen.util.GetPublisher;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author ChenZhongPu
 *
 */
public class AjaxAction extends ActionSupport {
      private GetPublisher getPublisher;
      private GetAuthor getAuthor;
      private InputStream inStream;
       

	public GetPublisher getGetPublisher() {
		return getPublisher;
	}

	public void setGetPublisher(GetPublisher getPublisher) {
		this.getPublisher = getPublisher;
	}

	public GetAuthor getGetAuthor() {
		return getAuthor;
	}

	public void setGetAuthor(GetAuthor getAuthor) {
		this.getAuthor = getAuthor;
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	/**
	 * 
	 * @return
	 */
	public InputStream getResult() {
		return inStream;
	}

  /**
   * 
   */
	public String execute() throws Exception
	{
		String publisheList = getPublisher.getPublisherList();
		publisheList+="#"+getAuthor.getAuthorList();
		inStream = new ByteArrayInputStream(publisheList.getBytes());
		
		return SUCCESS;
	}
	
}
