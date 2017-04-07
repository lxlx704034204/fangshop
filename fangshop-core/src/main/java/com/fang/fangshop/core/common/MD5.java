package com.fang.fangshop.core.common;

import java.security.MessageDigest;

public class MD5 {

	public static String convertToMd5(String strSource) throws Exception{
		
		char[] arrChar = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] byteSource = strSource.getBytes();
		messageDigest.update(byteSource);
		byte[] updateBytes = messageDigest.digest();
		int len = updateBytes.length;
		char[] resChar = new char[len*2];
		//将 MD5 密文 转成十六进制
		int k=0;
		for(int i=0;i<len;i++){
			byte byte0=updateBytes[i];
			resChar[k++] = arrChar[byte0 >>> 4 & 0x0f];
			resChar[k++] = arrChar[byte0 & 0x0f];
		}
		return new String(resChar);
	}
}
