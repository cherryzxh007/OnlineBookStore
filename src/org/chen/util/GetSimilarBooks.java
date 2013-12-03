package org.chen.util;

import java.util.List;

import org.chen.table.Book;

/**
 * 工具类，获取相似的书
 * @author ChenZhongPu
 *
 */
public interface GetSimilarBooks {

	public List<Book> getSimilar(String isbn);
}
