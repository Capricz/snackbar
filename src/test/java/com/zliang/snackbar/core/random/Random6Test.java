package com.zliang.snackbar.core.random;

import java.util.Random;

/**
 * generate 6 bit random number
 * @author Adermon
 *
 */
public class Random6Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int length = 6;
		int number = 0;
		int total = 0;
		for (int i = 1; i <= length; i++) {
			number = i*r.nextInt(10);
			if(i!=1){
				total = total*10 + number;
			} else {
				total = number;
			}
		}
		System.out.println(total);
	}

}
