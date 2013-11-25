package org.chen.tag;
import javax.servlet.jsp.JspWriter;

import org.chen.util.GetAuthor;
import org.springframework.web.servlet.tags.RequestContextAwareTag;


/**
 * 自定义标签，用以获取数据库中的列表
 * @author ChenZhongPu
 *
 */
public class AuthorListTag extends RequestContextAwareTag {

	private GetAuthor getAuthor;
	@Override
	protected int doStartTagInternal() throws Exception {
		
		JspWriter writer = pageContext.getOut();
		getAuthor = (GetAuthor) this.getRequestContext().getWebApplicationContext().getBean("getAuthor");
		String authorList = getAuthor.getAuthorList();
		writer.write(authorList);
		writer.flush();
		return 0;
	}


}
