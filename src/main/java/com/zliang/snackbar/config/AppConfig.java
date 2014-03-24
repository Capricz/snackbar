package com.zliang.snackbar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zliang.snackbar.service.IPersonService;
import com.zliang.snackbar.service.PersonService;

@Configuration
@ComponentScan("com.zliang.snackbar")
public class AppConfig { 

	@Bean
	public IPersonService personService(){
		return new PersonService();
	}
}
