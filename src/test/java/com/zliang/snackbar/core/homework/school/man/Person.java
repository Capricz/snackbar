package com.zliang.snackbar.core.homework.school.man;

/**
 * This is a Person class.
 * @author zhojiali
 *@version 1.0
 */
public class Person {
	
	private String name;
	private int age;
	
	/**
	 * Person can eat food
	 */
	public void eat(String food){
		System.out.println("Person eat "+food);
	}
	
	/**
	 * Person can run
	 */
	public void run(){
		System.out.println("Person is running");
	}

	/**
	 * return a person name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * set a person name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get a person age
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * set a person age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
