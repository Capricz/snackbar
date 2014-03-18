package com.zliang.snackbar.core.homework.school.man.combine;

import com.zliang.snackbar.core.homework.school.man.Person;

/**
 * This is a combine student class, it will combine Person class
 * @author zhojiali
 *
 */
public class CombineStudent {
	private Person p;
	
	public CombineStudent(){
		p = new Person();
	}
	
	/**
	 * CombineStudent is eating food
	 * @param food
	 */
	public void eat(String food){
		p.eat(food);
	}
	
	/**
	 * CombineStudent is running
	 */
	public void run(){
		p.run();
	}
	
}
