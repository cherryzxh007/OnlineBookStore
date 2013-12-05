package org.chen.action;

import java.io.IOException;
import java.util.List;

import org.chen.table.Book;
import org.chen.table.SearchBlock;
import org.chen.util.BuildIndex;
import org.chen.util.Search;
import org.chen.util.SearchingBlock;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 全文检索的action
 * @author ChenZhongPu
 *
 */
public class SearchItemAction extends ActionSupport {

	private String item;

	private List<SearchBlock> blocks;
	
	private BuildIndex buildIndex;
	
	public BuildIndex getBuildIndex() {
		return buildIndex;
	}

	public void setBuildIndex(BuildIndex buildIndex) {
		this.buildIndex = buildIndex;
	}

	public List<SearchBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<SearchBlock> blocks) {
		this.blocks = blocks;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	public String execute() throws IOException
	{
	//buildIndex.createIndex();
	List<Book> result= new Search().search(item);
	blocks = SearchingBlock.getSearchBlocksBlocks(result);
	System.out.println(blocks.get(0).getBooks().get(0).getIsbn());
    return SUCCESS;
	}
}
