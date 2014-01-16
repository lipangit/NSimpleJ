//package com.nathenblog.nsimplej.SimpleHttp;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// * <p>Simple for me to use NHttp</p>
// * <p>Ignore every thing just get and post</p>
// * <p>年终岁尾才找到我的Simple之路啊</p>
// * Created by Nathen on 13-12-27.
// */
//public class NHttpBackUp extends NHttpBase {
//
//    static NHttpUtil nhu = new NHttpUtil();
//
//    public static String Get(String url, String... paires) throws IOException {
//        HttpURLConnection connection = (HttpURLConnection) new URL(url + nhu.makePaire("?", paires)).openConnection();
//        String strRes = strFromInputStream(connection.getInputStream());
//        return strRes;
//    }
//
//    /**
//     * 网页抓取方法
//     * 没搞清楚完全模拟浏览器登录
//     * 这个版本目前就用这个了
//     *
//     * @param urlString 要抓取的url地址
//     * @param charset   网页编码方式
//     * @param timeout   超时时间
//     * @return 抓取的网页内容\
//     * //http://blog.csdn.net/yjflinchong
//     * @throws java.io.IOException 抓取异常
//     */
//    public static String Get(String urlString, final String charset, int timeout) throws IOException {//是否需要这些判断类
//        if (urlString == null || urlString.length() == 0) {//这里是否需要还要实践来证明
//            return null;
//        }
//        urlString = (urlString.startsWith("http://") || urlString.startsWith("https://")) ? urlString : ("http://" + urlString).intern();
//        URL url = new URL(urlString);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoOutput(true);
//        int temp = Integer.parseInt(Math.round(Math.random() * 7) + "");
//        conn.setRequestProperty(
//                "User-Agent",
//                "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");//UserAgent[temp]);  // 模拟手机系统
//        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");//只接受text/html类型，当然也可以接受图片,pdf,*/*任意，就是tomcat/conf/web里面定义那些
//        conn.setConnectTimeout(timeout);
//        conn.setReadTimeout(timeout);
////        try {
////            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
////                System.out.println("--" + conn.getResponseCode());
////                return null;
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
//        InputStream input = conn.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input,
//                charset));
//        String line = null;
//        StringBuffer sb = new StringBuffer();
//        while ((line = reader.readLine()) != null) {
//            sb.append(line).append("\r\n");
//        }
//        //http://blog.csdn.net/yjflinchong
//        if (reader != null) {
//            reader.close();
//        }
//        if (conn != null) {
//            conn.disconnect();
//        }
//        return sb.toString();
//    }
//
//
//    /**
//     * 在读取json时避免头部的一个字符的乱码，以“｛”为开头返回
//     *
//     * @throws IOException
//     */
//    public static String Get_Json(String url, String charSet, int timeout) throws IOException {
//        String str = Get(url, charSet, timeout);
//        return str.substring(str.indexOf("{"));
//    }
//
//    /**
//     * 读取http为一个数据类似结果的返回
//     *
//     * @return
//     */
//    public static String Get_Ret() {
//        return "";
//    }
//
//    public static String Post(String url, String... paires) throws IOException {
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setDoOutput(true);
//        connection.setRequestMethod("POST");
//        OutputStream ops = connection.getOutputStream();
//        strToOutputStream(ops, nhu.makePaire("", paires));
//        InputStream ips = connection.getInputStream();
//        String strRet = strFromInputStream(ips);
//        ops.close();
//        ips.close();
//        return strRet;
//    }
//
//    public static void main(String args[]) throws IOException {
//        System.out.println(Get("http://info.btc123.com/bter.php"));
//    }
//    /**
//     * <p>Read all of the stream then to utf8 str</p>
//     * <p>Will not close the stream</p>
//     */
//    public static String strFromInputStream(InputStream ips) throws IOException {
//        byte[] rb = new byte[1024];
//        int rc = 0;
//        String retStr = "";
//        while ((rc = ips.read(rb)) != -1) {
//            retStr += new String(rb, 0, rc, "UTF-8");
//        }
//        ips.close();
//        return retStr;
//    }
//}
