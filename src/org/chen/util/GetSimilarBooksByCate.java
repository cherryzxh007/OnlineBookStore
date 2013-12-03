package org.chen.util;

import java.util.List;

import org.chen.Dao.BasicBookDao;
import org.chen.Dao.GetRandomReco;
import org.chen.table.Book;

/**
 * 
 * @author ChenZhongPu
 *
 */
public class GetSimilarBooksByCate implements GetSimilarBooks{
	
    GetRandomReco randomReco;
	public void setRandomReco(GetRandomReco randomReco) {
		this.randomReco = randomReco;
	}


	@Override
	public List<Book> getSimilar(String isbn) {
		List<Book> books = randomReco.getRecommentBooks();
		return books;
	}

	
}

