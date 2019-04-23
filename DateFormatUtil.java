package com.test.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateTimeUtil
 * @Description: 日期格式工具类
 * @author LuGuanglei
 * @date 2017年12月11日 下午1:34:13
 * @version V1.0
 */
public class DateFormatUtil {

    /**
     * @Description: 日期时间格式(年-月-日 时:分:秒)
     */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * @Description: 日期格式(年-月-日)
     */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /**
     * @Description: 时间格式(时:分:秒)
     */
    public static final String FORMAT_TIME = "HH:mm:ss";

    /**
     * 字符串转日期
     *
     * @param date 字符串
     * @param format 格式
     * @return
     * @author LuGuanglei
     * @date 2017年12月11日 下午1:46:48
     */
    public static Date stringToDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转字符串
     *
     * @param date 日期
     * @param format 格式
     * @return
     * @author LuGuanglei
     * @date 2017年12月11日 下午1:52:16
     */
    public static String dateToString(Date date, String format) {
        try {
            return new SimpleDateFormat(format).format(date);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
