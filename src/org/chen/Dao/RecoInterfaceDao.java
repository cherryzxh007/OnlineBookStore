package org.chen.Dao;

import java.util.List;

import org.chen.table.Book;

/**
 * �Ƽ�ͼ��Ľӿ�
 * @author ChenZhongPu
 *
 */
public interface RecoInterfaceDao {

	/**
	 * 
	 * @return �Ƽ���ͼ��
	 */
	List<Book> getRecommentBooks();
	
    
}
