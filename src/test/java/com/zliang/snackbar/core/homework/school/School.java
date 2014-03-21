package com.zliang.snackbar.core.homework.school;

/**
 * This ia a school class
 * @author zhojiali
 *
 */
public class School {
	
	private String name;
	
	/**
	 * Shchool is built
	 */
	public void built(){
		System.out.println("School has been built...");
	}

	/**
	 * get school name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * set school name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
