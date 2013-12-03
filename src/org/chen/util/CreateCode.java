package org.chen.util;
/**
 * 获取验证码的工具类
 * @author ChenZhongPu
 *
 */
public class CreateCode {
	/**
	 * 随机返回字符作为验证码
	 * @return
	 */

	public static String create()
	{
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<4;i++)
		{
			builder.append(BookConstont.CODES[(int)(BookConstont.CODES.length*Math.random())]);
		}
		return builder.toString();
	}
}
