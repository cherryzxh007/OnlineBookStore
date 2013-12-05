package org.chen.util;
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.document.Field;  
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.index.IndexFileNames;
import org.apache.lucene.index.IndexReader;  
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;  
import org.apache.lucene.queryparser.classic.ParseException;  
import org.apache.lucene.queryparser.classic.QueryParser;  
import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.ScoreDoc;  
import org.apache.lucene.search.TopDocs;  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.store.FSDirectory;  
import org.apache.lucene.util.Version;  
import org.chen.table.Book;

import com.thoughtworks.qdox.Searcher;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author LiuChang
 *
 */
public class Search {
	//this is the thing you want to search
	 private String[] queryString={"title","info"};
	 // state a analyzer
	 private Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	 //we want to get the isbn, so here we state the indexfield
	 static String[] indexField={"isbn","title","img","price"};
	 // the method search
	public List<Book> search(String value) throws IOException {  
		//get the index we formally write
        IndexReader reader = DirectoryReader.open(FSDirectory.open(BuildIndex.getIndexFile()));   
        //use this to search
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        //use the queryParser to wrap your request
        QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_45, queryString, analyzer); 
        //this isbn is use to return
        List<Book> book=new ArrayList<Book>();
        
        Query query = null;  
        try {  
            query = queryParser.parse("title:"+value+"~");   
        } catch (ParseException e) {  
            e.printStackTrace();  
        }    
        //we get what we want in the topdocs
        TopDocs topDocs = indexSearcher.search(query, 25);    
        System.out.println("一共查到:" + topDocs.totalHits + "记录");  
        //ScoreDoc[] scoreDoc = topDocs.scoreDocs;    
 for(int i=0;i<topDocs.scoreDocs.length;i++)
 {
	Document resultDocument=indexSearcher.doc(topDocs.scoreDocs[i].doc);
	Book mybook = new Book();
	mybook.setIsbn(resultDocument.get((indexField[0])));
	mybook.setTitle(resultDocument.get((indexField[1])));
	mybook.setImgPath(resultDocument.get((indexField[2])));
	mybook.setPrice(Float.valueOf(resultDocument.get((indexField[3]))));
	book.add(mybook);
	
 }
 return book;
    }    
      
}
