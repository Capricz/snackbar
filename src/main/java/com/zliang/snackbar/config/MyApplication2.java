package com.zliang.snackbar.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.zliang.snackbar.web.rest.HelloWorldResource;
import com.zliang.snackbar.web.rest.PersonResource;

/**
 * Portable JAX-RS application.
 *
 * @author Arul Dhesiaseelan (aruld@acm.org)
 */
public class MyApplication2 extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register resources and features
        classes.add(HelloWorldResource.class);
        classes.add(PersonResource.class);
        return classes;
    }
}
