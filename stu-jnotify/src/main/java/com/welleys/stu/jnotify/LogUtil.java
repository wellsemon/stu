package com.welleys.stu.jnotify;

public class LogUtil {
	 public static void log(Exception e, Class<?> cla)
	  {
	      org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(cla);
	      log.error(e.getMessage(), e);
	  }

	  public static void log(String info, Class<?> cla) {
	      org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(cla);
	      log.info(info);
	  }

	  public static void error(String info, Exception e, Class<?> cla) {
	      org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(cla);
	      log.error(info, e);
	  }
}
