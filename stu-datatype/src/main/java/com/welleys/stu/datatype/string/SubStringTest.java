package com.welleys.stu.datatype.string;

import java.util.Date;

import com.suzhw.data.type.util.TimeUtil;

public class SubStringTest {
	public static void main(String[] args) {
		String timeInfo="string$now+60";
		String str = timeInfo.substring(timeInfo.indexOf("now+") + "now+".length());
		System.out.println(str);
		Date time = TimeUtil.getNowAddTimerDate(str);
		System.out.println(time);
	}
}
