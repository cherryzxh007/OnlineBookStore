package org.chen.util;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * 工具类，获取当前时间
 * @author ChenZhongPu
 *
 */
public class GetCurrentTime {

	
	public static Timestamp getTime()
	{
		Calendar calendar = Calendar.getInstance();
		
        @SuppressWarnings("deprecation")
		Timestamp timestamp = new Timestamp(calendar.get(Calendar.YEAR),
        		calendar.get(Calendar.MONTH),
        		calendar.get(Calendar.DAY_OF_MONTH),
        		calendar.get(Calendar.AM_PM),
        		calendar.get(Calendar.MINUTE), 0, 0);
        return timestamp;
	}
}
