package com.nathenblog.nsimplej.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this is not good will be paoqi
 */
public class NFLog {
    // 为了保证文件太大每次写入都会检查文件是否存在 如果不存在就创建文件开始写 如果存在就在现有的文件之后继续写
    private String logpath;// 这是固定的不变的
    private FileOutputStream fis;
    private File logfile;

    public NFLog(String logpath) throws FileNotFoundException {
        this.logpath = logpath;
        initLog();
    }

    public void initLog() throws FileNotFoundException {
        initFile();
        initStream();
    }

    private void closeStream() throws IOException {
        fis.flush();
        fis.close();
        fis = null;
    }

    private void initFile() {
        logfile = new File(createlogpath());
    }

    private void initStream() throws FileNotFoundException {
        fis = new FileOutputStream(logfile);
    }

    private String createlogpath() {
        return logpath + "." + getTime("yyyy_MM_dd_HH_mm_ss");
    }

    public void writeString(String str) {
        try {
            if (logfile.length() > (1024 * 1024)) {
                closeStream();
                initLog();
            }
            fis.write(("[" + getTime("yyyy-MM-dd HH:mm:ss") + "]" + str + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTime(String form) {//"yyyy_MM_dd_HH_mm_ss"
        SimpleDateFormat format = new SimpleDateFormat(form);// yyyy_MM_dd_HH_mm_ss
        return format.format(new Date());
    }

    public static void main(String[] args) {

        try {
            NFLog ml = new NFLog("E:/log/ll");
            while (true) {
                ml.writeString("hellofdasfjdaslfjdslajfdlksajklfjdslakfjdsklfjldkafjdklasjk");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		/*
         * try { FileOutputStream fis=new FileOutputStream(new
		 * File("E:/log.log")); while(true){ fis.write("hello1\r\n".getBytes());
		 * fis.write("hello2\r\n".getBytes()); } } catch (FileNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
    }
}