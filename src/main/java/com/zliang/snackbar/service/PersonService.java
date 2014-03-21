package com.zliang.snackbar.service;

import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

	public String sayHello(String name) {
		return "Hello "+name;
	}

}
