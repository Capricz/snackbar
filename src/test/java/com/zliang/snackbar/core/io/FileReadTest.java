package com.zliang.snackbar.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class FileReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("c:\\a.txt"));
			BufferedReader br = new BufferedReader(fr);
			String c = "";
			StringBuffer sb =new StringBuffer();
			while((c=br.readLine())!=null){
				sb.append(c+"\r");
			}
			br.close();
			System.out.println(sb.toString());
			
			int i = 1;
			Integer ii = new Integer(97);
			byte[] a = new byte[10];
			a[0] = ii.byteValue();
			String s = new String(a,Charset.forName("UTF-8"));
			System.out.println("############"+s);
			
			
			/*InputStream is = new FileInputStream(new File("c:\\a.txt"));
			BufferedReader br = new BufferedReader(is);
			int content = 0;
			StringBuffer sb = new StringBuffer();
			byte[] b = new byte[100];
			int index = 0;
			while((content = is.read())!=-1){
				
			}*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
