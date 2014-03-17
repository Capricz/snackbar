package com.zliang.snackbar.core.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RMBConvertTest {
	static String zero = "零";
	static char zeroChar = '0';
	static String[] chineseArr = new String[]{"壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
	static String[] unitArr = new String[]{"元","拾","百","仟"};
	static String[] scaleArr = new String[]{"万","亿"};
	static String[] pointArr = new String[]{"角","分"};

	public static void main(String[] args) {
		String input = "1060.333"; //一百二十三万四千五百六十七元二角三分
		
		String[] twoPartArr = input.split("\\.");
		String zheng = twoPartArr[0];
		String feng = twoPartArr[1];
		System.out.println(zheng);
		System.out.println(feng);
		
		//feng
		int pointLength = feng.length();
		if(pointLength>2) {
			feng = feng.substring(0, 2);
			pointLength = feng.length();
		}
//		System.out.println(point);
		String pointStr = "";
		for (int i = 0; i < pointLength; i++) {
			char c = feng.charAt(i);
			if(c != zeroChar){
				int parseInt = Integer.parseInt(String.valueOf(c));
				pointStr+=chineseArr[parseInt-1]+pointArr[i];
			} else{
				pointStr+=zero;
			}
			
			
		}
		System.out.println(pointStr);
		
		//zheng
		String zhengStr = "";
		int zhengSize = zheng.length();
		int count = 0;
		String previousChStr = "";
		for (int i = zhengSize-1; i >= 0; i--) {
			String chStr = getChinese(chineseArr,zheng.charAt(i));
			String unit = unitArr[(zhengSize - i -1)%4];
			//+万、亿
			if(count>=4 && (zhengSize-i-1)%4==0) {
				unit = scaleArr[count/4-1];
			}
			count++;
			/*if(zero.equals(previousChStr) && zero.equals(chStr) &&(zhengSize-i-1)%4!=0){
				continue;
			} else */if(zero.equals(chStr) && (zhengSize-i-1)%4!=0){
				unit = "";
			} /*else if(zero.equals(chStr) && i == zhengSize-1){
				chStr = "";
				unit
			}*/
			/*else if(zero.equals(chStr)){
				chStr = "";
			}*/
			previousChStr = chStr;
			zhengStr = chStr + unit + zhengStr;
		}
		/*for (int i = 0; i < scaleArr.length; i++) {
			if(zhengStr.indexOf(scaleArr[i]) == 0){
				zhengStr = zhengStr.substring(1);
				break;
			}
		}*/
		Pattern p = null;
		Matcher matcher = null;
		for (int i = 0; i < unitArr.length; i++) {
			String regex2 = unitArr[i]+zero + unitArr[0];
			p = Pattern.compile(regex2);
			matcher = p.matcher(zhengStr);
			if(matcher.find()){
				zhengStr = zhengStr.replaceAll(regex2, unitArr[i]+unitArr[0]);
			}
			
			String regex3 = "^"+zero+"+";
			p = Pattern.compile(regex3);
			matcher = p.matcher(zhengStr);
			if(matcher.find()){
				zhengStr = zhengStr.replaceAll(regex3, "");
			}
			for (int j = 0; j < scaleArr.length; j++) {
				String regex = unitArr[i]+zero+"+"+scaleArr[j];
				p = Pattern.compile(regex);
				matcher = p.matcher(zhengStr);
				if(matcher.find()){
					zhengStr = zhengStr.replaceAll(regex, unitArr[i]+scaleArr[j]);
				}
				String regex4 = scaleArr[j]+zero+"+"+unitArr[i];
				p = Pattern.compile(regex4);
				matcher = p.matcher(zhengStr);
				if(matcher.find()){
					zhengStr = zhengStr.replaceAll(regex4, scaleArr[j]+unitArr[i]);
				}
				
				for(int k=0;k<chineseArr.length;k++){
					String regex5 = scaleArr[j]+zero+"+"+chineseArr[k];
					p = Pattern.compile(regex5);
					matcher = p.matcher(zhengStr);
					if(matcher.find()){
						zhengStr = zhengStr.replaceAll(regex5, scaleArr[j]+zero+chineseArr[k]);
					}
					String regex6 = unitArr[i]+zero+"+"+chineseArr[k];
					p = Pattern.compile(regex6);
					matcher = p.matcher(zhengStr);
					if(matcher.find()){
						zhengStr = zhengStr.replaceAll(regex6, unitArr[i]+zero+chineseArr[k]);
					}
				}
			}
		}
		System.out.println(zhengStr);
		
		if(Integer.parseInt(feng)==0){
			pointStr = "正";
		}
		System.out.println("total = "+zhengStr+pointStr);
		
	}
	
	private static String getChinese(String[] chineseArr,char c) {
		int parseInt = Integer.parseInt(String.valueOf(c));
		if(parseInt==0){
			return zero;
		}
		return chineseArr[parseInt-1];
	}

}
