package com.zliang.snackbar.myjaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MyJAXBTest {
	public static void main(String[] args) {
		Classroom c = new Classroom();
		c.setId(1);
		c.setrName("classroom 1");
		
		try {
			JAXBContext ctx = JAXBContext.newInstance(Classroom.class);
			
			Marshaller mars = ctx.createMarshaller();
			mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			mars.marshal(c, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
