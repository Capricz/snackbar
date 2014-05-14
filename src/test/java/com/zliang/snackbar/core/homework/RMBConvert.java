package com.zliang.snackbar.core.homework;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RMBConvert {
	//定义零变量
	static String zero = "零";
	//定义零字符变量
	static char zeroChar = '0';
	//定义1-9对应中文大写数组
	static String[] chineseArr = new String[]{"壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
	//定义整数部分货币基本单位
	static String[] unitArr = new String[]{"元","拾","百","仟"};
	//定义整数部分大单位
	static String[] scaleArr = new String[]{"万","亿"};
	//定义小数部分基本单位
	static String[] pointArr = new String[]{"角","分"};

	public String convert(String input) {
//		String input = "1060.335"; //一百二十三万四千五百六十七元二角三分
		
		//非空验证
		if(input==null || input.length()==0){
			System.out.println("the input is empty");
			return "";
		}
		
		//分割整数部分和小数部分
		String[] twoPartArr = input.split("\\.");
		String zheng = twoPartArr[0];
//		String feng = twoPartArr[1];
		String feng = "";
		
		//验证是否包含小数,四舍五入
		if(input.indexOf(".")!=-1){
			Double pointDouble = Double.valueOf(("0"+input.substring(input.indexOf("."))));
			BigDecimal reserv2point = BigDecimal.valueOf(pointDouble);
			feng = reserv2point.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			feng = feng.substring(2);
		}
		
		
		System.out.println("整数部分  : "+zheng);
		System.out.println("小数部分  : "+feng);
		
		
		//feng,计算小数部分长度
		int pointLength = feng.length();
		if(pointLength>2) {
			feng = feng.substring(0, 2);
			pointLength = feng.length();
		}
//		System.out.println(point);

		//转换小数部分、并对于小于分的小数进行四舍五入
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
//		System.out.println(pointStr);
		
		//zheng，计算整数部分
		String zhengStr = "";
		int zhengSize = zheng.length();
		int count = 0;
		String previousChStr = "";
		//从个位进行遍历整数部分
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
			} else */
			if(zero.equals(chStr) && (zhengSize-i-1)%4!=0){//判断是否需要补零
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
		//遍历整数部分，通过正则表达式，将多余的零过滤掉
		for (int i = 0; i < unitArr.length; i++) {
			//如果字符串满足基本单位+零元，则过滤零
			String regex2 = unitArr[i]+zero + unitArr[0];
			p = Pattern.compile(regex2);
			matcher = p.matcher(zhengStr);
			if(matcher.find()){
				zhengStr = zhengStr.replaceAll(regex2, unitArr[i]+unitArr[0]);
			}
			
			//过滤数值前的零，例如003456.23
			String regex3 = "^"+zero+"+";
			p = Pattern.compile(regex3);
			matcher = p.matcher(zhengStr);
			if(matcher.find()){
				zhengStr = zhengStr.replaceAll(regex3, "");
			}
			//验证和大单位有关的补零
			for (int j = 0; j < scaleArr.length; j++) {
				//过滤基本单位与大单位之间的零
				String regex = unitArr[i]+zero+"+"+scaleArr[j];
				p = Pattern.compile(regex);
				matcher = p.matcher(zhengStr);
				if(matcher.find()){
					zhengStr = zhengStr.replaceAll(regex, unitArr[i]+scaleArr[j]);
				}
				
				//过滤大单位与基本单位之间的零，例如：30500->过滤零仟
				String regex4 = scaleArr[j]+zero+"+"+unitArr[i];
				p = Pattern.compile(regex4);
				matcher = p.matcher(zhengStr);
				if(matcher.find()){
					zhengStr = zhengStr.replaceAll(regex4, scaleArr[j]+unitArr[i]);
				}
				
				//遍历中文换算
				for(int k=0;k<chineseArr.length;k++){
					//过滤大单位与中文间的补零,例如:一万零仟零百伍拾
					String regex5 = scaleArr[j]+zero+"+"+chineseArr[k];
					p = Pattern.compile(regex5);
					matcher = p.matcher(zhengStr);
					if(matcher.find()){
						zhengStr = zhengStr.replaceAll(regex5, scaleArr[j]+zero+chineseArr[k]);
					}
					
					//过滤基本单位与中文之间的补零，例如：壹仟零零伍拾
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
		
		if(feng == null || feng == ""){
			pointStr = "正";
		}
		System.out.println("total = "+zhengStr+pointStr);
		String result = zhengStr + pointStr;
		return result;
		
	}
	
	/**
	 * 针对字符进行相应的数值转换 ， 如1->壹
	 * @param chineseArr
	 * @param c
	 * @return
	 */
	private static String getChinese(String[] chineseArr,char c) {
		int parseInt = Integer.parseInt(String.valueOf(c));
		if(parseInt==0){
			return zero;
		}
		return chineseArr[parseInt-1];
	}

}
