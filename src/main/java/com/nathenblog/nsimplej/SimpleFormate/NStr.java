package com.nathenblog.nsimplej.SimpleFormate;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Nathen on 13-12-28.
 */
public class NStr {
    public final static Double yi = 100000000.0;
    //    public final static Double baiwan = 1000000.0;
    public final static Double wan = 10000.0;

    /**
     * 取得多少多少万，？百万？亿。就三个单位就够了=
     */
    public static String getMoney(Double d) {
        if (d > yi) {
            BigDecimal bg = new BigDecimal(d / yi);
            double j = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return j + "亿";
        }
        // else if (d < yi && d > baiwan) {
        // BigDecimal bg = new BigDecimal(d / baiwan);
        // double j = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        // return j + "百万";
        // }
        else if (d < yi && d > wan) {
            BigDecimal bg = new BigDecimal(d / wan);
            double j = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return j + "万";
        } else if (d < wan && d > 0) {
            BigDecimal bg = new BigDecimal(d / 1);
            double j = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return j + "";
        }
        return "0.0";
    }

    /**
     * 截取最长这么长的字符
     *
     * @param no
     * @return
     */
    public static String getNo(Double dou, int no) {
        String str = String.valueOf(dou);
        if (dou < 0.01) {
            String aa = convert(dou, 2);
            if (no > str.length()) no = str.length();
            return String.valueOf(Double.valueOf(aa)).substring(0, no);
        }
        if (no > str.length()) no = str.length();
        return String.valueOf(dou).substring(0, no);
    }

    public static String convert(Double d, int scale) {
        BigDecimal de = BigDecimal.valueOf(d);
        MathContext m = new MathContext(scale);
        return de.divide(BigDecimal.ONE, m).toString();
    }

    public static void main(String[] args) {
        System.out.println(getNo(0.000123, 6));
        System.out.println(convert(0.000123, 2));
    }
}
