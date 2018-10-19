package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static DateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static DateFormat d2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getDateStr() {
		return d.format(new Date());
	}

	public static String getDateStr(Date date) {
		return d.format(date);
	}

	public static Date getDate(String dateStr) {
		try {
			Date date = d2.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
