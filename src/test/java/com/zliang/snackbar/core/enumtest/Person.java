package com.zliang.snackbar.core.enumtest;

public class Person {

	private String name;
	
	public Person(){
		this.name = "panasonic";
	}
	
	public void eatDessert(Dessert d){
		System.out.print(this.name+" ");
		d.eat();
	}
	
	public Person(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
