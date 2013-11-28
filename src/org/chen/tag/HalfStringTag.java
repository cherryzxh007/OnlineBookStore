package org.chen.tag;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 自定义标签。
 * 对字符串进行拆分；
 * 
 * @author ChenZhongPu
 *
 */
public class HalfStringTag extends SimpleTagSupport {

	private String info;
    private int part;
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public void doTag() throws IOException{
		
		String left = "";
		String right = "";
		if(info.length()>450)
		{
			left = info.substring(0,400);
			if(info.length()>800)
			{
				right = info.substring(401,780);
			}
			else {
				right = info.substring(401);
			}
		}
		
		if(part==1) getJspContext().getOut().write(left);
		else getJspContext().getOut().write(right);
	}
}
