package com.zliang.snackbar.core.enumtest;

public enum Dessert {
	CAKE,PIE,ICECREAM;
	
	private String name;
	
	public void eat(){
		/*for (Dessert d : this.values()) {
			System.out.println(d.name);
		}*/
		switch(this){
			case CAKE:
				System.out.println("eat cake");
				break;
			case PIE:
				System.out.println("eat pie");
				break;
			case ICECREAM:
				System.out.println("eat ice cream");
				break;
		}
	}
}
