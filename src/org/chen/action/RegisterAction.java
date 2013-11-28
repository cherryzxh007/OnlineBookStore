package org.chen.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.chen.Dao.CustomerDao;
import org.chen.table.Customer;
import org.chen.util.BookConstont;
import org.chen.util.ValidateEmail;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户进行注册时的action
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
 * 该action的默认方法，添加用户。
 */
	public String execute(){
		
		// 先对用户头像随机生成
		customer.setIconid((int)(Math.random()* BookConstont.ALLICON));
		customerDao.add(customer);
		return SUCCESS;			
	}
	/**
	 * 注册时进行邮箱有效性验证。
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
