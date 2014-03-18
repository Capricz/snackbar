package com.zliang.snackbar.core.homework.school.man;
/**
 * This is a Student class
 * @author zhojiali
 * @version 1.0
 */
public class Student extends Person {
	private String uid;
	
	/**
	 * Student is eating food
	 */
	@Override
	public void eat(String food) {
		System.out.println("Student is eating "+food);
//		super.eat(food);
	}

	/**
	 * student is studying
	 */
	public void study(){
		System.out.println("Student is studing...");
	}

	/**
	 * get student's id
	 * @return
	 */
	public String getUid() {
		return uid;
	}


	/**
	 * set student's id
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
}
