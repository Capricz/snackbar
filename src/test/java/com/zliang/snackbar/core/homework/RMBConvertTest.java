package com.zliang.snackbar.core.homework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class RMBConvertTest {
	
	private RMBConvert tool;
	
	@Before
	public void startUp(){
		tool = new RMBConvert();
		System.out.println("startUp invoked...");
	}

	@Test
	public void test1() {
		String input = "";
		String result = tool.convert(input);
		String expected = "";
		assertEquals(expected , result);
	}
	
	@Test
	public void test2() {
		String input = "10.123";
		String result = tool.convert(input);
		String expected = "壹拾元壹角贰分";
		assertEquals(expected , result);
	}
	
	@Test
	public void test3() {
		String input = "10.125";
		String result = tool.convert(input);
		String expected = "壹拾元壹角叁分";
		assertEquals(expected , result);
	}
	
	@Test
	public void test4() {
		String input = "1230";
		String result = tool.convert(input);
		String expected = "壹仟贰百叁拾元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test5() {
		String input = "1234";
		String result = tool.convert(input);
		String expected = "壹仟贰百叁拾肆元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test6() {
		String input = "12345";
		String result = tool.convert(input);
		String expected = "壹万贰仟叁百肆拾伍元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test7() {
		String input = "123456789";
		String result = tool.convert(input);
		String expected = "壹亿贰仟叁百肆拾伍万陆仟柒百捌拾玖元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test8() {
		String input = "1203";
		String result = tool.convert(input);
		String expected = "壹仟贰百零叁元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test9() {
		String input = "1003";
		String result = tool.convert(input);
		String expected = "壹仟零叁元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test10() {
		String input = "10234";
		String result = tool.convert(input);
		String expected = "壹万零贰百叁拾肆元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test11() {
		String input = "0012345";
		String result = tool.convert(input);
		String expected = "壹万贰仟叁百肆拾伍元正";
		assertEquals(expected , result);
	}
	
	@Test
	public void test12() {
		String input = "12304";
		String result = tool.convert(input);
		String expected = "壹万贰仟叁百零肆元正";
		assertEquals(expected , result);
	}
	
	@Test
	@Ignore
	public void test13() {
		String input = "30500";
		String result = tool.convert(input);
		String expected = "叁万零伍百元正";
		assertEquals(expected , result);
	}
}
