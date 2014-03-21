package com.zliang.snackbar.core.homework;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 实现类似String类的substring()方法，按字节截取字符串，其中英文占1个字节，中文占2个字节
 * @author Adermon
 * @date 2014-3-11
 */
public class CutStringTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Charset charSet = Charset.forName("UTF-8");
//		String a = "大abcdefghij";
//		String a = new String("中国abc");
		String a = "中国abc";
//		byte[] b = a.getBytes(charSet);
		int start = 3;
		int end = 5;
		String result = a.substring(1,3);
		System.out.println("result(subString) = "+result);
		
		result = mySubString(a,2,5);
		System.out.println("result(mySubString) = "+result);
	}

	private static String mySubString(String a, int start,int end) throws UnsupportedEncodingException {
		Charset charSet = Charset.forName("GBK");
		byte[] bytes = a.getBytes(charSet);
		int byteArrLength = bytes.length;
		if(end>byteArrLength){
			end = byteArrLength;
		}
//		start--;
		int length = end - start;
		System.out.println("start = "+start+", end = "+end+", byteArrLength = "+byteArrLength+", length ="+length);
		return new String(bytes,start,length,charSet);
		
		/*int length = a.length();
//		char c = a.charAt(i);
//		StringBuffer sb = new StringBuffer();
		String s = "";
		for(int j=i;j<length;j++){
			char c = a.charAt(j);
//			sb.append(c);
			s += c;
			System.out.print(c+" ");
		}
//		return sb.toString();
		return s;*/
//		return null;
	}

}
