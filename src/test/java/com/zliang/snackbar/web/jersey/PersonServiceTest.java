package com.zliang.snackbar.web.jersey;

import static org.junit.Assert.*;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.zliang.snackbar.config.MyApplication;
import com.zliang.snackbar.web.rest.App;


public class PersonServiceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new MyApplication();
	}
	
	@Override
    protected URI getBaseUri() {
        return UriBuilder.fromUri(super.getBaseUri()).path("helloperson").build();
    }

    @Test
    public void testClientStringResponse() {
        String s = target().path(App.ROOT_PATH).request().get(String.class);
        assertEquals("Hello World!", s);
    }

}
