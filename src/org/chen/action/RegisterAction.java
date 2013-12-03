package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.CustomerDao;
import org.chen.table.Customer;
import org.chen.util.BookConstont;
import org.chen.util.EncryptPwd;
import org.chen.util.ValidateEmail;
import org.chen.util.GetAd;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 执行注册的action
 * @author ChenZhongPu
 *
 */
public class RegisterAction extends ActionSupport {
	
	private CustomerDao customerDao;
    private Customer customer;
    private String inputEmail;
    private InputStream result;
    private GetAd getAd;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public InputStream getResult() {
		return result;
	}

	public void setResult(InputStream result) {
		this.result = result;
	}
	
	
    public void setGetAd(GetAd getAd) {
		this.getAd = getAd;
	}

/**
 * 默认方法，注册
 */
	public String execute(){
		ActionContext.getContext().setLocale(Locale.US);
		WebApplicationContext ctx =
				WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		customerDao = (CustomerDao) ctx.getBean("userDao");
		if(!customerDao.isUnique(getCustomer().getEmail()))
		{
			
			return ERROR;
		}
		customer.setPwd(EncryptPwd.getEncryption(customer.getPwd()));
		int iconid = (int)(Math.random()* BookConstont.ALLICON);
		customer.setIconid(iconid==0?1:iconid);
		customerDao.add(customer);
		return SUCCESS;			
	}
	/**
	 * 通过ajax交互完成email的有效性验证
	 * @return
	 */
	public String valiEmail()
	{
		ActionContext.getContext().setLocale(Locale.US);
		WebApplicationContext ctx =
				WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		customerDao = (CustomerDao) ctx.getBean("userDao");
		if(ValidateEmail.validateByWeb(getInputEmail())&& customerDao.isUnique(getInputEmail()))
		{
			result = new ByteArrayInputStream(BookConstont.EMAIL.getBytes());
			
		}else {
			result = new ByteArrayInputStream(("<label class='alert-warning'>"+getText("emailERR")+"</label>").getBytes());
			
		}
		return SUCCESS;
	}
	
	public String toSign()
	{ 
		   ActionContext.getContext().setLocale(Locale.US);
		   String imgAd = BookConstont.ADPATH+getAd.getAdNum()+BookConstont.ADSUFFIX;
           ActionContext.getContext().getSession().put("imgAd", imgAd);
           return SUCCESS;
	}

}
