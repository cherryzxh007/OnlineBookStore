package org.chen.table;

import java.io.Serializable;

/**
 * ��ҳ��Ϣ������ӳ��
 * @author ChenZhongPu
 *
 */
public class IndexInfo implements Serializable{

	private String name;
	private int id;
	private String imgPath;
	/**
	 * ��ȡ�������
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡͼ������id
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ȡͼƬ·��
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
}
