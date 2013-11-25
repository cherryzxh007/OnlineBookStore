package org.chen.tag;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class SubCateTag extends RequestContextAwareTag {

	private String mainCate;
	
	public String getMainCate() {
		return mainCate;
	}

	public void setMainCate(String mainCate) {
		this.mainCate = mainCate;
	}

	@Override
	protected int doStartTagInternal() throws Exception {
		
		return 0;
	}
	
	

}
