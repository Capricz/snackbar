package com.zliang.snackbar.myjaxb.sample1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JaxbReadXml {

    @SuppressWarnings("unchecked")
    public static <T> T readString(Class<T> clazz, String context) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            URL url = JaxbReadXml.class.getClassLoader().getResource(context);
            return (T) u.unmarshal(new File(url.getFile()));
//            return (T) u.unmarshal(new File(url));
        } catch (JAXBException e) {
            // logger.trace(e);
            throw e;
        } /*catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;*/
    }

    @SuppressWarnings("unchecked")
    public static <T> T readConfig(Class<T> clazz, String config, Object... arguments) throws IOException,
            JAXBException {
        InputStream is = null;
        try {
            if (arguments.length > 0) {
                config = MessageFormat.format(config, arguments);
            }
            // logger.trace("read configFileName=" + config);
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            is = new FileInputStream(config);
            return (T) u.unmarshal(is);
        } catch (IOException e) {
            // logger.trace(config, e);
            throw e;
        } catch (JAXBException e) {
            // logger.trace(config, e);
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T readConfigFromStream(Class<T> clazz, InputStream dataStream) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(dataStream);
        } catch (JAXBException e) {
            // logger.trace(e);
            throw e;
        }
    }

    public static void main(String[] args) throws JAXBException {
        TestOrgs testOrgs = JaxbReadXml.readString(TestOrgs.class, "test.xml");
        System.out.println(testOrgs.getSize());
        System.out.println(testOrgs.getBatchNumber());
        System.out.println(testOrgs.getErrmsg());
        for (TestOrg o : testOrgs) {
            System.out.println(o.getOrgName());
        }
    }
}