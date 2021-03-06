package com.zliang.snackbar.myform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Demo {

  public static void main(String[] args) throws Exception {
    Map m = new HashMap();
    String url = "http://www.ecice06.com/cn/search_gjdo.asp";
    String code = "UTF-8";

//    m.put("sel_zazhimc", "");
//
//    m.put("sel_niandu", "");
//
//    m.put("txt_qishiye", "");
//
//    m.put("txt_doi", "");
//    m.put("xueke", "");
//    m.put("zhuanye", "");
//    m.put("txt_zuozhe", "");
//    m.put("txt_zuozhe2", "");
//    m.put("txt_zuozhedw", "");
//
//    m.put("txt_zhaiyao", "");
//    m.put("txt_guanjianci", "");
//    m.put("txt_fenleihao", "");
//    m.put("sel_niandus", "");
//    m.put("sel_niandue", "");

    m.put("txt_wenti", "数据");
    m.put("pagesize", "10");
    m.put("Submit2", "查询");
    m.put("rad_px", "zuozhexm,kanchurq desc");
    String rus = doPost(url, m, code);

    System.out.println(rus);
  }

  public static String doPost(String reqUrl, Map parameters, String recvEncoding) {
    HttpURLConnection conn = null;
    String responseContent = null;
    try {
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
      URL url = new URL(reqUrl);
      HttpURLConnection url_con = (HttpURLConnection) url.openConnection();
      url_con.setRequestMethod("POST");
      // System.setProperty("sun.net.client.defaultConnectTimeout", String
      // .valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
      // System.setProperty("sun.net.client.defaultReadTimeout", String
      // .valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
      url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
      // 1.5换成这个,连接超时
      url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
      url_con.setDoOutput(true);
      byte[] b = params.toString().getBytes();
      url_con.getOutputStream().write(b, 0, b.length);
      url_con.getOutputStream().flush();
      url_con.getOutputStream().close();

      InputStream in = url_con.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(in, recvEncoding));
      String tempLine = rd.readLine();
      StringBuffer tempStr = new StringBuffer();
      String crlf = System.getProperty("line.separator");
      while (tempLine != null) {
        tempStr.append(tempLine);
        tempStr.append(crlf);
        tempLine = rd.readLine();
      }
      responseContent = tempStr.toString();
      rd.close();
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return responseContent;
  }

}