package org.chen.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.chen.Dao.BasicBookDao;
import org.chen.table.Book;

import com.sun.mail.iap.Literal;

/**
 * 
 * @author LiuChang
 * 
 */
public class BuildIndex {
	// use the dao to get the information.
	private  BasicBookDao basicBookDao;
	public BasicBookDao getBasicBookDao() {
		return basicBookDao;
	}

	public void setBasicBookDao(BasicBookDao basicBookDao) {
		this.basicBookDao = basicBookDao;
	}

	// the index will be stored in this way
	private static File indexFile = new File("F:\\luceneIndex");
	public static File getIndexFile() {
		return indexFile;
	}

	public static void setIndexFile(File indexFile) {
		BuildIndex.indexFile = indexFile;
	}

	// define a analyzer
	private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	// get the booklist
	private static List<Book> booklist;

	// create the index
	@SuppressWarnings("deprecation")
	public void createIndex() throws IOException {
       //store in the directory
		Directory directory =  new SimpleFSDirectory(indexFile);															
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_45, analyzer);
		indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);// 准备写入
	    booklist= basicBookDao.getAllBooks();
		if (booklist.size() > 0) {
			long time1 = System.currentTimeMillis();
			for (int i = 0; i < booklist.size(); i++) {
				Document document = new Document();
				document.add(new Field("isbn", booklist.get(i).getIsbn(),
						Field.Store.YES,Field.Index.ANALYZED));	
				document.add(new Field("title", booklist.get(i).getTitle(),
						Field.Store.YES,Field.Index.ANALYZED));	
				document.add(new Field("info", booklist.get(i).getIntro(),
						Field.Store.NO,Field.Index.ANALYZED));	
				document.add(new Field("img", booklist.get(i).getImgPath(),
						Field.Store.YES,Field.Index.ANALYZED));	
				document.add(new Field("price", String.valueOf(booklist.get(i).getPrice()),
						Field.Store.YES,Field.Index.ANALYZED));	
				
				writer.addDocument(document);
			}
			long time2 = System.currentTimeMillis();
			System.out.println("创建了" + writer.numDocs() + "索引");
			System.out.println("一共花了" + (time2 - time1) + "时间");
		}
		writer.close();
	}

	

}
