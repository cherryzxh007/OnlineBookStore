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
	private String iconPath;
	
	private String fDis;
	private String fAdd;
	private String zipCodeS;
	
	
	public String getfDis() {
		return fDis==null?"":fDis;
	}
	public void setfDis(String fDis) {
		this.fDis = fDis;
	}
	public String getfAdd() {
		return fAdd==null?"":fAdd;
	}
	public void setfAdd(String fAdd) {
		this.fAdd = fAdd;
	}
	public String getZipCodeS() {
		return zipCodeS==null?"":fDis;
	}
	public void setZipCodeS(String zipCodeS) {
		this.zipCodeS = zipCodeS;
	}
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
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	
	
}
