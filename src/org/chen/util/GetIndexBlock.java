package org.chen.util;

import java.util.ArrayList;
import java.util.List;

import org.chen.Dao.BasicBookDao;
import org.chen.table.IndexBlock;
import org.chen.table.IndexInfo;

/**
 * 
 * @author ChenZhongPu
 *
 */
public class GetIndexBlock {

	private BasicBookDao basicBookDao;
	
	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}

	public  List<IndexBlock> GetBlocks() throws Exception{
		
		List<IndexInfo> indexs = XMLReader.readXML();
		List<IndexBlock> blocks = new ArrayList<IndexBlock>();
		for(IndexInfo info:indexs)
		{
			IndexBlock block = new IndexBlock();
			block.setBlockTitle(info.getName());
			if(info.getImgPath().equals("#"))
			{
				block.setHasImage(0);
				block.setBooks(basicBookDao.getBooksByCateId(info.getId(), 5));
			}
			else {
				block.setHasImage(1);
				block.setPath(info.getImgPath());
				block.setBooks(basicBookDao.getBooksByCateId(info.getId(), 3));
			}
			
			blocks.add(block);
		}
		return blocks;
		
	}
}
