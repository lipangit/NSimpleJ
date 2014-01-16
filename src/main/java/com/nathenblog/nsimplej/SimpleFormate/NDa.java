package com.nathenblog.nsimplej.SimpleFormate;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Created by Nathen on 14-1-8.
 */
public class NDa {
    /**
     * 从mysql的int中取得日期:1389183157=10位
     */
    public static String getDate_MySql(String date, String formate) {
        return new DateTime(Long.valueOf(date + "000")).toString(formate);
    }

    /**
     * 这里应该判断一下位数，否则还停留在1970年3月份
     *
     */
    public static Long getDuration_BySec(String start, String end) {
        Duration du = new Duration(Long.valueOf(start), Long.valueOf(end));
        return du.getStandardSeconds();
    }

}
