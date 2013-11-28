package org.chen.table;
/**
 * Customer的映射表
 * @author ChenZhongPu
 *
 */
public class Customer {

	private int id;
	private String pwd;
	private String email;
	private String alias;
	private int iconid;
	private String phone;
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 
	 * @return
	 */
	public int getIconid() {
		return iconid;
	}
	/**
	 * 
	 * @param iconid
	 */
	public void setIconid(int iconid) {
		this.iconid = iconid;
	}
	/**
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone==null?"":phone;
	}
	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
