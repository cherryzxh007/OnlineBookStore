package org.chen.util;

import java.util.ArrayList;
import java.util.List;

import org.chen.table.Book;
import org.chen.table.SearchBlock;

/**
 * 工具类，获取搜索结果块
 * @author ChenZhongPu
 *
 */
public class SearchingBlock {

	/**
	 * 静态方法，
	 * 获取搜索结果块
	 * @return
	 */
	public static List<SearchBlock> getSearchBlocksBlocks(List<Book> books)
	{
		List<SearchBlock> blocks = new ArrayList<SearchBlock>();
		int rows = (int) Math.ceil((double)books.size()/BookConstont.BLOCKSIZE);
		for(int i = 0;i<rows;i++)
		{
			SearchBlock searchBlock = new SearchBlock();
			int end = i*BookConstont.BLOCKSIZE+BookConstont.BLOCKSIZE;
			if(end>books.size()) end=books.size();
			// sublist是前闭后开
			searchBlock.setBooks(books.subList(i*BookConstont.BLOCKSIZE, end));
			blocks.add(searchBlock);
		}
		return blocks;
	}
}
