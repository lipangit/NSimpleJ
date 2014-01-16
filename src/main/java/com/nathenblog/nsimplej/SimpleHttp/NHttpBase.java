package com.nathenblog.nsimplej.SimpleHttp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * <p>Base methods for NHttp</p>
 * Created by Nathen on 13-12-27.
 */
public class NHttpBase {

    public static HttpURLConnection getBaseConn(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(8000);
        return conn;
    }

    public static HttpURLConnection getDefaultConn(String url) throws IOException {
        HttpURLConnection conn = getBaseConn(url);
        conn.setDoOutput(true);
        conn.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");//UserAgent[temp]);  // 模拟手机系统
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");//只接受text/html类型，当然也可以接受图片,pdf,*/*任意，就是tomcat/conf/web里面定义那些
        return conn;
    }

    public static HttpURLConnection getPostConn(String url) throws IOException {
        HttpURLConnection conn = getBaseConn(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        return conn;
    }

    public static String strFromInputStream_ReadLine(InputStream ips, String charset) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ips,
                charset));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        if (reader != null) {
            reader.close();
        }
        return sb.toString();
    }

    public static void strToOutputStream(OutputStream ops, String str) throws IOException {
        byte[] wb = str.getBytes("UTF-8");
        ops.write(wb);
    }

    /**
     * <p>h is '?' or '' if get or post</p>
     * <p>Has been UrlEncoded</p>
     */
    public static String makePaire(String sep, String... vPaire) throws UnsupportedEncodingException {
        String url = "";
        url += sep;
        for (int i = 0; i < vPaire.length; i++) {
            if (i % 2 == 0) {
                url += "&";
                url += vPaire[i];
                url += "=";
            } else {
                url += URLEncoder.encode(vPaire[i], "UTF-8");
            }
        }
        return url;
    }
}
