package com.epam.ta.framework.ui.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static Date currentDate = new Date();
    private static DateFormat inputFormat = new SimpleDateFormat("MM/dd/yy");
    private static DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static long msDay = 7 * 24 * 60 * 60 * 1000;
    private static long msNextDate = currentDate.getTime() + msDay;
    private static Date nextDate = new Date(msNextDate);

    public static Date getCurrentDate() {
        return currentDate;
    }

    public static String getInputFormat(Date date) {
        return inputFormat.format(date);
    }

    public static String getSdf(Date date) {
        return sdf.format(date);
    }

    public static long getMsDay() {
        return msDay;
    }

    public static Date getNextDate(){
        return nextDate;
    }
}
