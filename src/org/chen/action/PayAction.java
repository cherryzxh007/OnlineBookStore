package org.chen.action;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.chen.Dao.AddressDao;
import org.chen.Dao.BookOrderDao;
import org.chen.table.Address;
import org.chen.table.Customer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 付款action
 * @author ChenZhongPu
 *
 */
public class PayAction extends ActionSupport {

	private Customer customer;
	private String addCountry;
	private String addState;
	private String addCity;
	private String detailAdd;
	private String fname;
	private String lname;
	private Address address;
	
	
	private int delivery_radio;
	
	private AddressDao addressDao;
	private BookOrderDao bookOrderDao;

	public AddressDao getAddressDao() {
		return addressDao;
	}
	public BookOrderDao getBookOrderDao() {
		return bookOrderDao;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAddCountry() {
		return addCountry;
	}
	public void setAddCountry(String addCountry) {
		this.addCountry = addCountry;
	}
	public String getAddState() {
		return addState;
	}
	public void setAddState(String addState) {
		this.addState = addState;
	}
	public String getAddCity() {
		return addCity;
	}
	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}
	
	public String getDetailAdd() {
		return detailAdd;
	}
	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	} 
    
	public int getDelivery_radio() {
		return delivery_radio;
	}
	public void setDelivery_radio(int delivery_radio) {
		this.delivery_radio = delivery_radio;
	}
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	
	
	public void setBookOrderDao(BookOrderDao bookOrderDao) {
		this.bookOrderDao = bookOrderDao;
	}
	private void doAddress()
	{
		address.setAddress(getAddCountry()+","+getAddState()+","+getAddCity()+","
				+getDetailAdd());
		address.setRece_name(getFname()+" "+getLname());
		setCustomer((Customer) ActionContext.getContext().getSession().get("theUser"));
		address.setCustomer_id(getCustomer().getId());
	    System.out.println(getCustomer().getAlias()+getCustomer().getId());
		addressDao.addAddress(address);
		
	}
	
	@SuppressWarnings("rawtypes")
	private void doOrderBook()
	{
		Map map = ActionContext.getContext().getSession();
		List list = (List) map.get("OrderBooks");
		bookOrderDao.addBookOrder(bookOrderDao.getBookOrders(list, getCustomer(), getDelivery_radio()));
		
	}
	/**
	 * 默认方法
	 */
	public String execute(){
		 ActionContext.getContext().setLocale(Locale.US);
		 doAddress();
		 doOrderBook();
		 ActionContext.getContext().getSession().remove("OrderBooks");
		 ActionContext.getContext().getSession().remove("BItems");
		return SUCCESS;
	}
	
}
