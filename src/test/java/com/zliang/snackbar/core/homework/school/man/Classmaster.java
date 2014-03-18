package com.zliang.snackbar.core.homework.school.man;

/**
 * This is a class master class
 * @author zhojiali
 *
 */
public class Classmaster extends Teacher {

	private String classid;
	
	/**
	 * Classmaster is managing a class
	 */
	public void manageclass(){
		System.out.println("Classmaster is managing a class");
	}

	/**
	 * get class id
	 * @return
	 */
	public String getClassid() {
		return classid;
	}

	/**
	 * set a class id to class master
	 * @param classid
	 */
	public void setClassid(String classid) {
		this.classid = classid;
	}
}
