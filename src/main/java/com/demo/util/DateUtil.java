/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {

    public static String simpleDataType = "yyyy年MM月dd日 HH:mm:ss";
    public static String simpleDataType1 = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 格式化时间,Date -> String
     *
     * @param date
     * @param simpleDataType，格式化规则
     * @return
     */
    public static String formatDate(Date date, String simpleDataType) {
        DateFormat format = new SimpleDateFormat(simpleDataType);
        return format.format(date);
    }

    /**
     * 格式化时间 String -> Date
     *
     * @param dateStr
     * @param simpleDataType, 格式化规则
     * @return
     * @throws ParseException
     */
    public static Date parseDateStr(String dateStr, String simpleDataType) throws ParseException {
        DateFormat format = new SimpleDateFormat(simpleDataType);
        return format.parse(dateStr);
    }

    /**
     * 返回当前电脑时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNowTimeString() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = format.format(date);
        return time;
    }

    /**
     * 返回当前电脑时间 （格式自定） toString为返回格式
     *
     * @return
     */
    public static String getNowTime(String toString) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat(toString);
        String time = format.format(date);
        return time;
    }

    /**
     * 返回当前年份
     *
     * @return
     */
    public static int getYearInt() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy");
        String time = format.format(date);
        return Integer.parseInt(time);
    }

    /**
     * 根据Date转换为String时间 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getLongTimeString(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    /**
     * 根据Date转换为String时间 yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static String getDayTimeString(String strDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        try {
            date = format.parse(strDate);
        } catch (ParseException ex) {
        }

        String time = format.format(date);
        return time;
    }

    public static String getDayString(String strDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = format.parse(strDate);
        } catch (ParseException ex) {
        }

        String time = format.format(date);
        return time;
    }

    /**
     * 根据Date转换为String日期 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getLongTimeStringYYYYMMDD(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }

    /**
     * 根据Date转换为String日期 MM月dd日
     * 在一对一限时优惠时显示使用
     * @param date
     * @return
     */
    public static String getLongTimeStringMMDD(Date date) {
        DateFormat format = new SimpleDateFormat("MM月dd日");
        String time = format.format(date);
        return time;
    }

    /**
     * 返回当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getNowDayString() {
        SimpleDateFormat dfday = new SimpleDateFormat("yyyy-MM-dd");
        String nowday = dfday.format(new Date());
        return nowday;
    }

    /**
     * 1对1订单号专用获取当前系统时间，因为原来采用的格式是yyMMddhhmmssffff，Java里好像获取不了，所以采用yyMMddhhmmssSSS，并且返回时在后面加个0，对应以前的订单号
     *
     * @return
     */
    public static String getConsultOrderNowTimeString() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyMMddhhmmssSSS");
        String time = format.format(date) + "0";
        return time;
    }

    /**
     * PC网站钻石卡订单号专用获取当前系统时间
     *
     * @return
     */
    public static String getCardOrderNowTimeString() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String time = format.format(date);
        return time;
    }

    /**
     * 返回当前的Timestamp类型的时间
     *
     * @return
     */
    public static Timestamp getTimestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    /**
     * 返回指定日期的Timestamp类型的时间
     *
     * @param dateString 2016-10-10
     * @return
     */
    public static Timestamp getTimestamp(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            Timestamp ts = new Timestamp(format.parse(dateString).getTime());
            return ts;
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * 将long类型时间转为String类型时间（Sqlserver类型Datetime一般为long类型）
     *
     * @param time
     * @return
     */
    public static String getStringDateByTimestamp(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型  
        java.util.Date dt = new Date(time);
        String sDateTime = sdf.format(dt);
        return sDateTime;
    }

    //返回2016年6月12日格式的日期
    public static String getTimeString(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String time = format.format(date);
        return time;
    }

    //返回用户上次测评时间和当前时间的时间差
    public static Long getTimeInterval(Date date) {
        Date dateNow = new Date();
        Long interval = (Long) (dateNow.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
        return interval;
    }

    //返回当前年份是否高考年份之内
    /**
     * 返回当前时间是否大于用户（高考年份+"-08-31"），判断用户前程卡是否过期
     *
     * @param year 用户高考年份
     * @return
     */
    public static boolean isGaokaoYearExpire(int year) {
        try {
            Date gaokaoYear = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date timeNow = new Date();//当前时间
            gaokaoYear = sdf.parse(year + "-08-31");//高考年份-08-31      
            return (timeNow.getTime() > gaokaoYear.getTime());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断现在是否是高考模拟时间
     */ 
    public static boolean isGaokaoBetweenDate() throws Exception {
        Date timeNow = new Date();//当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date everyGaokaoBeginDate = sdf.parse(DateUtil.getYearInt() + "-06-07");
        Date everyGaokaoEndDate = sdf.parse(DateUtil.getYearInt() + "-08-31");
        //如果现在是高考模拟时间
        if(timeNow.getTime() >= everyGaokaoBeginDate.getTime() && timeNow.getTime() <= everyGaokaoEndDate.getTime())
            return true;
        else
            return false;
    }
    
    /**
     * 当前日期和用户输入日期对比，返回值为 当前日期是否小于用户输入日期
     *
     * @param date
     * @return true大于当前时间，false小于当前时间
     */
    public static boolean DateNowCompareDate(String date) {
        try {
            Date gaokaoYear = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date timeNow = new Date();//当前时间
            gaokaoYear = sdf.parse(date);//输入时间  
            return (timeNow.getTime() < gaokaoYear.getTime());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 当前日期和用户输入日期对比，返回值为 当前日期是否小于用户输入日期
     *
     * @param date
     * @return true大于当前时间，false小于当前时间
     */
    public static boolean DateNowCompareDate(Timestamp timestamp) {
        try {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            return time.before(timestamp);

        } catch (Exception e) {
            return false;
        }
    }
    //返回时间字符串2016/01/11
    public static String  TimestampToString(Object timestamp) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return(format.format(timestamp));  
        } catch (Exception e) {
            return "";
        }
    }
    //返回时分秒的时间字符串
    public static String  TimestampToStringAndSecond(Object timestamp) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            return(format.format(timestamp));  
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * 对date进行天数（日）处理
     * 
     * @param date
     * @param days, 正数为加，负数为减
     * @param simpleDateFormatStr，时间格式化的样式
     * @return 
     */
    public static String updateDays(Date date, Integer days, String simpleDateFormatStr){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat(simpleDateFormatStr);
        calendar.add(Calendar.DAY_OF_MONTH, +days);
        return format.format(calendar.getTime());
    }
    
    /**  
     * 计算两个日期之间相差的天数  
     * 日期格式的计算 
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
        return Integer.parseInt(String.valueOf(between_days));           
    }    
      
    /** 
    * 计算两个日期之间相差的天数  
    * 字符串的日期格式的计算 
    * @param smdate 较小的时间 
    * @param bdate  较大的时间 
    * @return 相差天数  
    */  
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
        return Integer.parseInt(String.valueOf(between_days));     
    }  
    
    /**
     * 日志时间
     * 
     * @return 
     */
    public static String getLogTime(){
        return new SimpleDateFormat(simpleDataType1).format(new Date());
    }
    
}
