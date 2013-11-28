package org.chen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 使用WebService进行邮箱是否真实存在的工具类。
 * @author ChenZhongPu
 *
 */
public class ValidateEmail {

	private static final String URL = "http://webservice.webxml.com.cn/WebServices/ValidateEmailWebService.asmx/ValidateEmailAddress?theEmail=";
	private static final String TAG = "</unsignedByte>";
	/**
	 * 通过webservice 验证邮箱的真实性。
	 * @param email 待验证的邮箱。
	 * @return true表示有效。
	 */
	public static boolean validateByWeb(String email)
	{
		BufferedReader in = null;
		String xmlString="";
		try{
			String urlName =URL+email;
			URL realUrl = new URL(urlName);
			//the URLConnection
			URLConnection conn = realUrl.openConnection();
			//set the request 
			conn.setRequestProperty("accept", "*/*"); 
			conn.setRequestProperty("connection", "Keep-Alive"); 
			conn.setRequestProperty("user-agent", 
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
			//build the connection
			conn.connect(); 
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine())!= null)
			{
			xmlString += line;
			}
			int index = xmlString.indexOf(TAG);
			if(xmlString.substring(index-1, index).equals("1"))
			{
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}	
}
