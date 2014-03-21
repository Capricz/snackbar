package com.zliang.snackbar.core.enumtest;

public class DessertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		p.eatDessert(Dessert.CAKE);
		
		p = new Person("Adermon");
		p.eatDessert(Dessert.PIE);
		p.eatDessert(Dessert.ICECREAM);

	}

}
