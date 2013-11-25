package org.chen.converter;

import java.sql.Date;

import org.apache.commons.lang.text.StrBuilder;
/**
 * 工具类，实现yyyy-mm-dd形式的字符串转换成java.sql.Date类型
 * @author ChenZhongPu
 *
 */
public class ConvertToDate {
	/**
	 * yyyy-mm-dd字符串到Date
	 * @param dateString
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date getDate(String dateString)
	{

        try{
        	String[] date = dateString.split("-");
        	
    		int year = Integer.valueOf(date[0]);
    		int month = Integer.valueOf(date[1]);
    		int day = Integer.valueOf(date[2]);
    		return new Date(year, month, day);
        }
        catch(Exception e)
        {
        	//e.printStackTrace();
        	return new Date(2000, 1, 1);
        }
		
	}

}
