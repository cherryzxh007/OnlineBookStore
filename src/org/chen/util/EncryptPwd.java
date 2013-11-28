package org.chen.util;

import java.security.MessageDigest;

/**
 * �����࣬���ڶ�������й�ϣɢ�С�
 * 
 * @author ChenZhongPu
 * 
 */
public class EncryptPwd {

	public static String getEncryption(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// ���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			md5.update(btInput);
			// �ٴμ���
			MessageDigest mds1 = MessageDigest.getInstance("SHA1");
			mds1.update(md5.digest());
			// �������
			byte[] md = mds1.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
