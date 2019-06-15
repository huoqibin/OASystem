package qibinhuo.oas.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getTodayString() {
		Date d = new Date();
		return sdf.format(d);
	}
	
	public static Date getDate(String date) {
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			throw new RuntimeException("parse date error");
		}	
	}
	
	public static String getDateString(Date d) {
		return sdf.format(d);
	}

	/**
	 * 日期格式转换  2019/2/4
	 * @param date  日期
	 * @return  特定格式的日期
	 */
	public static String formatDate(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}
}
