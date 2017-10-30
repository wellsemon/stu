package com.welleys.stu.datatype.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil
{
  public static Date getCrontabTime(String timeString)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    String[] time = timeString.split(" ");
    String hour = time[2];
    if ("*".equals(hour)) {
      hour = calendar.get(11) + "";
    }
    String min = time[1];
    if ("*".equals(min)) {
      min = calendar.get(12) + "";
    }
    String sec = time[0];
    return getCurrentTimerDate(hour + ":" + min + ":" + sec);
  }

  public static long getCrontabPeriod(String timeString) {
    String[] time = timeString.split(" ");
    if ("*".equals(time[1]))
      return 60000L;
    if ("*".equals(time[2])) {
      return 3600000L;
    }
    return 86400000L;
  }

  public static Date getTimerDate(String time)
  {
    Date timer = getCurrentTimerDate(time);
    if (timer.compareTo(new Date()) <= 0) {
      timer = new Date(timer.getTime() + 86400000L);
    }
    return timer;
  }

  public static Date getCurrentTimerDate(String time) {
    Date date = new Date();
    String year = getYear(date);
    String month = getMonth(date);
    String day = getDay(date);
    String dateString = year + "-" + month + "-" + day + " " + time;
    Date timer = null;
    timer = getDate(dateString);
    return timer;
  }

  public static Date getNowAddTimerDate(String time) {
    String dateString = getCurrDateTime();
    dateString = countTime(dateString, Integer.parseInt(time));
    Date timer = null;
    timer = get14Date(dateString);
    return timer;
  }

  public static String getDay(Date date)
  {
    if (date == null)
      return null;
    return dateToNumber(date).substring(6, 8);
  }

  public static String getMonth(Date date)
  {
    if (date == null)
      return null;
    return dateToNumber(date).substring(4, 6);
  }

  public static String dateToNumber(Date date)
  {
    if (date == null) {
      return null;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    return simpleDateFormat.format(date);
  }

  public static String getYear(Date date)
  {
    if (date == null)
      return null;
    return dateToNumber(date).substring(0, 4);
  }

  public static Date getDate(String string)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try
    {
      return simpleDateFormat.parse(string);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static Date get14Date(String string)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    try
    {
      return simpleDateFormat.parse(string);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static String countTime(String time, int second)
  {
    String nextTime = null;
    try {
      SimpleDateFormat tstDate = new SimpleDateFormat("yyyyMMddHHmmss");
      Date tstdate1 = tstDate.parse(time);
      Calendar rightNow = Calendar.getInstance();
      rightNow.setTime(tstdate1);
      rightNow.add(13, second);
      nextTime = tstDate.format(rightNow.getTime());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return nextTime;
  }

  public static String getCurrDateTime()
  {
    String currentDateTime = null;
    SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
    currentDateTime = formater.format(new Date());
    return currentDateTime; }

  public static void main(String[] args) {
    System.out.println(getNowAddTimerDate("10"));
  }
}