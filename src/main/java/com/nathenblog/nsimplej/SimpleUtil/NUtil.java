package com.nathenblog.nsimplej.SimpleUtil;

import java.math.BigDecimal;

/**
 * Created by Nathen on 13-12-28.
 */
public class NUtil {
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

//    public static void main(String[] args) {
//        System.out.println(NoFormate.getMoney(7584938475.0));
//        System.out.println(NoFormate.getMoney(83928473.0));
//        System.out.println(NoFormate.getMoney(182792.0));
//        System.out.println(NoFormate.getMoney(5533.0));
//    }
}
