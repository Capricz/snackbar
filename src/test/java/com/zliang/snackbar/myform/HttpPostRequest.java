package com.zliang.snackbar.myform;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpPostRequest {

    /**
     * Main
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        System.out.println(doPost());
    }
    
    /**
     * Post Request
     * @return
     * @throws Exception
     */
    public static String doPost() throws Exception {
        String parameterData = "username=nickhuang&blog=http://www.cnblogs.com/nick-huang/";
        Map parameters = new HashMap();
        String recvEncoding = "UTF-8";
        
        StringBuffer params = new StringBuffer();
	      for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
	        Entry element = (Entry) iter.next();
	        params.append(element.getKey().toString());
	        params.append("=");
	        params.append(URLEncoder.encode(element.getValue().toString(), recvEncoding));
	        params.append("&");
	      }

	      if (params.length() > 0) {
	        params = params.deleteCharAt(params.length() - 1);
	      }
        
        URL localURL = new URL("http://localhost:8080/OneHttpServer/");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
        
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            
            outputStreamWriter.write(parameterData.toString());
            outputStreamWriter.flush();
            
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            
        } finally {
            
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            
            if (outputStream != null) {
                outputStream.close();
            }
            
            if (reader != null) {
                reader.close();
            }
            
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
            
        }

        return resultBuffer.toString();
    }
}
