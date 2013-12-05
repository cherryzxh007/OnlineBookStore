package org.chen.action;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.chen.table.Book;
import org.chen.table.SearchBlock;
import org.chen.util.BuildIndex;
import org.chen.util.Search;
import org.chen.util.SearchingBlock;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 全文检索的action
 * @author ChenZhongPu
 *
 */
public class SearchItemAction extends ActionSupport {

	private String item;

	private boolean hasResult;
	public boolean isHasResult() {
		return hasResult;
	}

	public void setHasResult(boolean hasResult) {
		this.hasResult = hasResult;
	}
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
		 ActionContext.getContext().setLocale(Locale.US);
	//buildIndex.createIndex();
	List<Book> result= new Search().search(item);
	blocks = SearchingBlock.getSearchBlocksBlocks(result);
	if(blocks.size()==0) hasResult = false;
	else {
		hasResult = true;
	}
    return SUCCESS;
	}
}
