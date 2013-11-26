package org.chen.table;

import java.io.Serializable;

/**
 * 首页信息的配置映射
 * @author ChenZhongPu
 *
 */
public class IndexInfo implements Serializable{

	private String name;
	private int id;
	private String imgPath;
	/**
	 * 获取大标题名
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取图书分类的id
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取图片路径
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
}
