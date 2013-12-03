package org.chen.util;

import java.util.Calendar;

/**
 * 获取广告图片Id,以星期几划分。
 * @author ChenZhongPu
 *
 */
public class GetAdByDay implements GetAd{

	@Override
	public int getAdNum() {
		Calendar calendar = Calendar.getInstance();
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			
			return 1;
		case Calendar.TUESDAY:
			return 2;
		case Calendar.THURSDAY:
			return 4;
		case Calendar.FRIDAY:
		    int id = (int)(Math.random()*6);
			return id==0?1:id;
		case Calendar.WEDNESDAY:
			return 3;
		case Calendar.SATURDAY:
			return 6;
		default:
			return 5;
		}
	}

	
}
