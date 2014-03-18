package com.zliang.snackbar.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.zliang.snackbar.service.IPersonService;

@Path("helloperson")
public class PersonResource {
	
	@Autowired
	private IPersonService personService;
	
	
	@GET
	@Produces("text/plain")
	public String getHello(){
		return personService.sayHello("Adermon"); 
	}
}
