package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.CustomerDao;
import org.chen.table.Customer;
import org.chen.util.BookConstont;
import org.chen.util.CreateCode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 登录action
 * @author ChenZhongPu
 *
 */
public class LoginAction extends ActionSupport {

	private Customer customer;
	private CustomerDao customerDao;
	private InputStream result;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public InputStream getResult() {
		return result;
	}
	public void setResult(InputStream result) {
		this.result = result;
	}
	public String execute()
	{
		WebApplicationContext ctx =
				WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		customerDao = (CustomerDao) ctx.getBean("userDao");
		if(customerDao.isValid(customer.getEmail(), customer.getPwd()))
		{
			ActionContext.getContext().getSession().put("loginFlag", true);
			Customer innerCustomer = customerDao.getCustomerByMail(customer.getEmail());
			ActionContext.getContext().getSession().put("theUser", innerCustomer);
			return SUCCESS;
		}
		else {
			
			return ERROR;
		}
	}
	/**
	 * 实现注销
	 * @return
	 */
	public String signOut()
	{
		ActionContext.getContext().getSession().put("loginFlag", false);
		ActionContext.getContext().getSession().remove("theUser");
		return SUCCESS;
	}
	/**
	 * 取得验证码
	 * @return
	 */
	public String getCode()
	{
		String code = CreateCode.create();
		result = new ByteArrayInputStream((BookConstont.WEBCODEURL+code).getBytes());
		return SUCCESS;
	}
}
