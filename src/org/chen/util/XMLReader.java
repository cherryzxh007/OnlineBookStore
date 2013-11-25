package org.chen.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.chen.table.IndexInfo;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * ��ȡIndexConfig XML�ļ������
 * ��ҳ��ʾ��Ϣ��
 * @author ChenZhongPu
 *
 */
public class XMLReader {
	
	private static final String XML_PATH = "WEB-INF/web.xml";
   /**
    *  
    * ��ȡXML�õ��й���ҳ��ʾ���б�
    * @return �й���ҳ��ʾ���б�
    * @throws Exception
    * @see IndexInfo
    */
	public static List<IndexInfo> readXML() throws Exception{
		try {
			Document doc;
			SAXBuilder saxBuilder = new SAXBuilder();
			FileInputStream fin = new FileInputStream(XML_PATH);
			doc = saxBuilder.build(fin);
			List<IndexInfo> indexs = new ArrayList<IndexInfo>();
			// ��ȡ���ڵ�
			Element root = doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> parts = root.getChildren("part");
			IndexInfo indexInfo = null;
			for(Element e:parts)
			{
				indexInfo = new IndexInfo();
				indexInfo.setId(Integer.valueOf(e.getChildTextTrim("id")));
				indexInfo.setName(e.getChildText("name"));
				indexInfo.setImgPath(e.getChildText("img"));
				indexs.add(indexInfo);
			}
			return indexs;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
