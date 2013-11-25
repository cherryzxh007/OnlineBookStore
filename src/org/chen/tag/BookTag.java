package org.chen.tag;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * 自定义标签类，
 * 得到首页模块的书的信息。
 * isbn，价格，标题，图片路径
 * @author ChenZhongPu
 *
 */
public class BookTag extends RequestContextAwareTag{
	
	private int num;
    private int catId;
	private BasicBookDao basicBookDao;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}


	@Override
	protected int doStartTagInternal() throws Exception {
		
		
		JspWriter writer = pageContext.getOut();
		basicBookDao =
		(BasicBookDao) this.getRequestContext().getWebApplicationContext().getBean("basicBookDao");
		List<Book> books = basicBookDao.getBooksByCateId(catId, num);
		for(Book b:books)
		{
			writer.write("<s:url action='#' id='BookDetail' >");
			writer.write("<s:param name='isbn'>");
			writer.write(b.getIsbn());
			writer.write("</s:param>");
			writer.write("</s:url>");
			writer.write("<div class='book_item'>");
			writer.write("<s:a href='%{BookDetail}'>");
			writer.write("<img src='");
			writer.write(b.getImgPath()+"' ");
			writer.write("onmouseover='this.style.borderColor=#234567,this.style.opacity= 0.75;'");
			writer.write(" onMouseout='this.style.borderColor=#ffffff,this.style.opacity= 1.0;'");
			writer.write(" />");
			writer.write("</s:a>");
			writer.write("<div class='book_item_intro'>");
			writer.write("<s:a cssClass='book_name_link' href='%{BookDetail}'>");
			writer.write(b.getTitle());
			writer.write("<span class='book_name_end'></span></s:a><br>");
			writer.write("<div>&yen;");
			writer.write(b.getPrice()+"</div>");
			writer.write("</div>");
			writer.write("</div>");
		}
		return 0;
	}
	



}
