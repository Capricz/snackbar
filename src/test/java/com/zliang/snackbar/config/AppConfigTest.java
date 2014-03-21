package com.zliang.snackbar.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zliang.snackbar.service.IPersonService;
import com.zliang.snackbar.service.PersonService;

public class AppConfigTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.zliang.snackbar");
		ctx.refresh();
		IPersonService personService = ctx.getBean(PersonService.class);
		System.out.println(personService.sayHello("panasonic"));
	}
}
