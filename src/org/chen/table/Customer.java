package org.chen.table;
/**
 * ���ݿ��Customer��ӳ����
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
	 * ��ȡ�˿�id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * ���ù˿�id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * ��������
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * �������
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * ��������
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * �������
	 * @return
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * ��������
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * ��ø���ͼ��id
	 * @return
	 */
	public int getIconid() {
		return iconid;
	}
	/**
	 * ���ø���ͼ��id
	 * @param iconid
	 */
	public void setIconid(int iconid) {
		this.iconid = iconid;
	}
	/**
	 * ��õ绰
	 * @return
	 */
	public String getPhone() {
		return phone==null?"":phone;
	}
	/**
	 * ���õ绰
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
