package com.zliang.snackbar.web.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.zliang.snackbar.service.IPersonService;

@Path("person")
public class PersonResource {
	
	@Autowired
	private IPersonService personService;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello(){
		return personService.sayHello("Adermon"); 
	}
}
