package org.bobo.mvc;

import org.apache.commons.lang.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Discribe:
 * Project:springmvc-datasource
 * Package: org.bobo.mvc
 * User: Chengwenbo
 * Date:  2016/2/16
 * Time: .15:22
 */
public class TimeTest {
    public static void main(String[] args) {

        System.out.println(makeLovelyDate(new Date(new Date().getTime() + 24*3600*1000*3)));
        System.out.println(makeLovelyDate(new Date(new Date().getTime() + 24*3600*1000*2)));
        System.out.println(makeLovelyDate(new Date(new Date().getTime() + 24*3600*1000*1)));
        System.out.println(makeLovelyDate(new Date()));
        System.out.println(makeLovelyDate(new Date(new Date().getTime() - 24*3600*1000*1)));
        System.out.println(makeLovelyDate(new Date(new Date().getTime() - 24*3600*1000*2)));
        System.out.println(makeLovelyDate(new Date(new Date().getTime() - 24*3600*1000*3)));


        //System.out.println(FastDateFormat.getInstance().format(new Date(date.getTime()-86400000)));
    }

    public static String makeLovelyDate(Date date) {
        String datePattern = "yyyy-MM-dd";
        String timePattern = " HH:mm";
        String weekPattern = "E";
        FastDateFormat fastDateFormat = null;
        String dateString;
        long timeMinus = date.getTime() - System.currentTimeMillis();
        int n = new Double(Math.floor(timeMinus / 24D/3600/1000)).intValue();
       /* if(n == -2)
       {
           dateString = "前天";
       }else*/
        if(n == -1)
        {
            dateString = "昨天" ;
        }else if(n == 0)
        {
            dateString = "今天";
        }else if(n == 1)
        {
            dateString = "明天";
        }else if(n >= 2 && n <= 5)
        {
            dateString = FastDateFormat.getInstance(weekPattern).format(date);
        }else
        {
            dateString = FastDateFormat.getInstance(datePattern).format(date);
        }
        dateString = dateString  + FastDateFormat.getInstance(timePattern).format(date);
        return dateString;
    }


}
