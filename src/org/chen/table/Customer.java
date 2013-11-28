package org.chen.table;
/**
 * 数据库表Customer的映射类
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
	 * 获取顾客id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置顾客id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取密码
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 设置密码
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获得邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置邮箱
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获得名称
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置名称
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获得个人图像id
	 * @return
	 */
	public int getIconid() {
		return iconid;
	}
	/**
	 * 设置个人图像id
	 * @param iconid
	 */
	public void setIconid(int iconid) {
		this.iconid = iconid;
	}
	/**
	 * 获得电话
	 * @return
	 */
	public String getPhone() {
		return phone==null?"":phone;
	}
	/**
	 * 设置电话
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
