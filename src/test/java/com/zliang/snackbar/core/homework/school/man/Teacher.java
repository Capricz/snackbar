package com.zliang.snackbar.core.homework.school.man;
/**
 * This is a Teacher class
 * @author zhojiali
 *
 */
public class Teacher extends Person {
	
	/**
	 * Teacher is eating food
	 */
	@Override
	public void eat(String food) {
		System.out.println("Teacher is eating "+food);
	}

	private String tid;

	/**
	 * Teacher can teach
	 */
	public void teach(){
		System.out.println("Teacher is teaching...");
	}

	/**
	 * get teacher id
	 * @return
	 */
	public String getTid() {
		return tid;
	}

	/**
	 * set teacher id
	 * @param tid
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
