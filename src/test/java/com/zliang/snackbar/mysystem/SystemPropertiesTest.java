package com.zliang.snackbar.mysystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SystemPropertiesTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Map<String,String> propMap = new HashMap<String,String>();
		propMap.put("os.name", "os.name");//Operating system name 
		propMap.put("os.arch", "os.arch");//Operating system architecture 
		propMap.put("os.version", "os.version");//Operating system version 
		propMap.put("file.separator", "file.separator");//File separator ("/" on UNIX) 
		propMap.put("path.separator", "path.separator");//Path separator (":" on UNIX)
		propMap.put("line.separator", "line.separator");//Line separator ("\n" on UNIX)  
		propMap.put("user.name", "user.name");//User's account name
		propMap.put("user.home", "user.home");//User's home directory
		propMap.put("user.dir", "user.dir");//User's current working directory
//		String osName = System.getProperty("os.name");
//		String osArch = System.getProperty("os.arch");
//		String osVersion = System.getProperty("os.version");
//		String fileSeparator = System.getProperty("file.separator");
//		String pathSeparator = System.getProperty("path.separator");
//		String lineSeparator  = System.getProperty("line.separator");
//		String userName = System.getProperty("user.name");
//		String userHome = System.getProperty("user.home");
//		String userDir = System.getProperty("user.dir");
		sb.append("{\n");
		for (Iterator it = propMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			String key = entry.getKey();
//			String value = entry.getValue();
			String value = System.getProperty(key);
			if(value==null || "".equals(value)){
				value = "null";
			}
			sb.append(key +" : "+value+",\n");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("\n}");
		
		System.out.println(sb.toString());
	}

}
