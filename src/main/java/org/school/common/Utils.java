package org.school.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	public static Date parseDate(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date millisecondToDate(String s) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(s));
		return c.getTime();
	}
}
