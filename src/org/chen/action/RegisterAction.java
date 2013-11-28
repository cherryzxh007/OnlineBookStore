package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.chen.Dao.CustomerDao;
import org.chen.table.Customer;
import org.chen.util.BookConstont;
import org.chen.util.ValidateEmail;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 执行注册的action
 * @author ChenZhongPu
 *
 */
public class RegisterAction extends ActionSupport {
	
	private CustomerDao customerDao;
    private Customer customer;
    private InputStream result;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InputStream getResult() {
		return result;
	}

	public void setResult(InputStream result) {
		this.result = result;
	}
/**
 * 默认方法，注册
 */
	public String execute(){
		
		
		customer.setIconid((int)(Math.random()* BookConstont.ALLICON));
		customerDao.add(customer);
		return SUCCESS;			
	}
	/**
	 * 通过ajax交互完成email的有效性验证
	 * @return
	 */
	public String valiEmail()
	{
		if(ValidateEmail.validateByWeb(getCustomer().getEmail()))
		{
			result = new ByteArrayInputStream(getText("emailOK").getBytes());
			return SUCCESS;
		}else {
			result = new ByteArrayInputStream(getText("emailERR").getBytes());
			return ERROR;
		}
	}

}
