package com.nathenblog.nsimplej.SimpleHttp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * <p>Simple for me to use NHttp</p>
 * <p>Ignore every thing just get and post</p>
 * <p>Base:自己的服务器；Default是别人的服务器</p>
 * <p>年终岁尾才找到我的Simple之路啊</p>
 * tody 14-01-12:思路是清晰的，效果是失败的default和base没有结果上的区别，关键可能是路由上的问题如：http://www.bter.com:502，但是访问这个http://bter.com:400.这些在浏览器都没问题的。php好像也没问题
 * 但还是要按理论上的用
 * Created by Nathen on 13-12-27.
 */
public class NHttp extends NHttpBase {

    public static String GetBase(String url, String... paires) throws IOException {
        HttpURLConnection conn = getBaseConn(url + makePaire("?", paires));
        InputStream input = conn.getInputStream();
        String str = strFromInputStream_ReadLine(input, "UTF-8");
        if (conn != null) {
            conn.disconnect();
        }
        return str;
    }

    /**
     * 在读取json时避免头部的一个字符的乱码，以“｛”为开头返回
     *
     * @throws IOException
     */
    public static String GetBaseJson(String url, String... paires) throws IOException {
        String str = GetBase(url, paires);
        return str.substring(str.indexOf("{"));
    }

    /**
     * 读取http为一个数据类似结果的返回
     *
     * @return
     */
    public static String GetBaseRet(String url, String... paires) throws IOException {
        String str = GetBase(url, paires);
        if (str.length() > 1) {
            str = str.substring(1);
        }
        return str;
    }

    public static String GetDefault(String url, String... paires) throws IOException {
        HttpURLConnection conn = getDefaultConn(url + makePaire("?", paires));
        InputStream input = conn.getInputStream();
        String str = strFromInputStream_ReadLine(input, "UTF-8");
        if (conn != null) {
            conn.disconnect();
        }
        return str;
    }

    /**
     * 在读取json时避免头部的一个字符的乱码，以“｛”为开头返回
     *
     * @throws IOException
     */
    public static String GetDefaultJson(String url, String... paires) throws IOException {
        String str = GetDefault(url, paires);
        return str.substring(str.indexOf("{"));
    }

    /**
     * 读取http为一个数据类似结果的返回
     *
     * @return
     */
    public static String GetDefaultRet(String url, String... paires) throws IOException {
        String str = GetDefault(url, paires);
        if (str.length() > 1) {
            str = str.substring(1);
        }
        return str;
    }

    /**
     * only post base one kind of Post mabey used
     *
     * @param url
     * @param paires
     * @return
     * @throws IOException
     */
    public static String PostBase(String url, String... paires) throws IOException {
        HttpURLConnection conn = getPostConn(url);
        OutputStream ops = conn.getOutputStream();
        strToOutputStream(ops, makePaire("", paires));
        InputStream ips = conn.getInputStream();
        String strRet = strFromInputStream_ReadLine(ips, "UTF-8");
        ops.close();
        conn.disconnect();
        return strRet;
    }

    public static void main(String args[]) throws IOException {
        System.out.println(GetBase("http://info.btc123.com/bter.php"));
    }
}
