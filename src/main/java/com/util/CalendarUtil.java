package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期处理类
 * 
 * @author qwu
 * @created 2016年2月22日 下午4:44:04
 * @version 0.0.1
 */
public class CalendarUtil {

	/**
	 * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
	 * 
	 * @param date
	 *            Date
	 * @return Date
	 */
	public static final Date zerolizedTime(Date fullDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fullDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/** 获取date的该月份第一天* */
	public static Calendar getFirstDayOfTheMonth(Date date) {
		Calendar c = getCalendar(date);
		c.set(Calendar.DATE, 1);
		/** 变态的Calendar,12点前,必须减去12* */
		c.set(Calendar.HOUR, 0 - (c.get(Calendar.HOUR_OF_DAY) >= 12 ? 12 : 0));
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}

	/** 获取date的该月份第一天* */
	public static Calendar getLastDayOfTheMonth(Date date) {
		Calendar c = getCalendar(date);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		/** 变态的Calendar,12点前,必须减去12* */
		c.set(Calendar.HOUR, 23 - (c.get(Calendar.HOUR_OF_DAY) >= 12 ? 12 : 0));
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c;
	}

	public static Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}

	public static Calendar getCalendar(Date time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		return calendar;
	}

	public static Calendar getCalendar(long time) {
		Date tmp = new Date();
		tmp.setTime(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(tmp);
		return calendar;
	}

	public static Date getDate(int year, int month, int day) {
		if (month < 1)
			month = 1;
		if (day < 1)
			day = 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar.getTime();
	}

	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/** 从 0-11* */
	public static int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONTH);
	}

	// 获得系统当前月份时间: 0 - 11
	public static int getMonth() {
		int month = getMonth(getCalendar());
		return month;
	}

	public static int getWeek(Date time) {
		Calendar calendar = getCalendar(time);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static int getMonthWeek(Date time) {
		Calendar calendar = getCalendar(time);
		return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}

	public static int getDay(Date time) {
		Calendar calendar = getCalendar(time);
		return calendar.get(Calendar.DATE);
	}

	public static int getDayOfMonth(Date time) {
		Calendar calendar = getCalendar(time);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDayOfYear(Date time) {
		Calendar calendar = getCalendar(time);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	public static int getDayOfYear(Calendar calendar, boolean zero) {
		return calendar.get(Calendar.DAY_OF_YEAR) - (zero ? 1 : 0);
	}

	public static int getDayOfYear(Date date, int defaultnullvalue) {
		if (date == null) {
			return defaultnullvalue;
		} else {
			return getDayOfYear(date);
		}
	}

	public static int getTodayOfWeek(Date time) {
		Calendar calendar = getCalendar(time);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		if (day > 1) {
			day = day - 1;
		} else if (day == 1) {
			day = 7;
		}
		return day;
	}

	/***************************************************************************
	 * 返回昨天天在星期几
	 **************************************************************************/
	public static int getYesterdayOfWeek(Date time) {
		int day = getTodayOfWeek(time);
		if (day > 1) {
			day = day - 1;
		} else if (day == 1) {
			day = 7;
		}
		return day;
	}

	/** 获得上上个月,月份从1-12* */
	public static int getPPMonth() {
		Calendar now = getCalendar();
		int month = getMonth(now);
		month = month - 1;
		if (month <= 0)
			month = month + 12;
		return month;
	}

	/**
	 * 字符串转换到时间格式
	 * 
	 * @param fullDateString
	 * @param datePattern
	 * @return
	 */
	protected static Date toDate(String fullDateString, String datePattern) {
		DateFormat dd = new SimpleDateFormat(datePattern);
		Date date = null;
		try {
			date = dd.parse(datePattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String formatDate(Date date, String dateFormat) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		String dateStr = new SimpleDateFormat(dateFormat).format(now.getTime());
		return dateStr;
	}

	/**
	 * 日期比较，大于currDate，返回false
	 * 
	 * @param format
	 *            日期字符串格式
	 * @param baseDate
	 *            被比较的日期
	 * @param compareDate
	 *            比较日期
	 * @return
	 */
	public static boolean before(String format, String baseDate,
			String compareDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			Date base = simpleDateFormat.parse(baseDate);
			Date compare = simpleDateFormat.parse(compareDate);

			return compare.before(base);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 根据格式得到 step时间间隔以后的时间字符串。
	 * 
	 * @param format
	 * @param baseTime
	 *            基准时间
	 * @param step
	 *            以分钟为单位
	 * @return 返回的格式 为 format
	 */
	public static String getNextTime(String format, String baseTime, long step) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			Date base = simpleDateFormat.parse(baseTime);
			long nextTime = base.getTime() + step * 60 * 1000;

			Date newTime = new Date();
			newTime.setTime(nextTime);

			return simpleDateFormat.format(newTime);

		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 根据基准时间,得到新的时间
	 * 
	 * @param baseDate
	 *            基准时间
	 * @param step
	 *            新时间间隔, 以分为单位
	 * @return
	 */
	public static Date getNextTime(Date baseDate, long step) {

		long nextTime = baseDate.getTime() + step * 60 * 1000;

		Date newDate = new Date();
		newDate.setTime(nextTime);

		return newDate;
	}

	/**
	 * 取当前时间前一天和当前时间
	 * 
	 */
	public static Map<String, String> getLastCurrDay() {
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.add(Calendar.DATE, -1); // 得到前一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到前一天
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 取当月第一天和当前时间
	 * 
	 */
	public static Map<String, String> getFirstDayInMonth() {
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.set(Calendar.DAY_OF_MONTH, 1); // 得到当月第一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到当天日期
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 取当月第一天和当前时间
	 * 
	 */
	public static Map<String, String> getFirstDayInMonth(String datePattern) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.set(Calendar.DAY_OF_MONTH, 1); // 得到当月第一天
		String startDate = format.format(calendarStart.getTime());
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.add(Calendar.DATE, 0); // 得到当天日期
		String endDate = format.format(calendarEnd.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}


	/**
	 * 返回两个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDistDates(Date startDate, Date endDate) {
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);

		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();

		totalDate = (timeend - timestart) / (1000 * 60 * 60 * 24);
		return totalDate;
	}

	/**
	 * 接受YYYY-MM-DD的日期字符串参数,返回两个日期相差的天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long getDistDates(String start, String end)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		return getDistDates(startDate, endDate);
	}

	/**
	 * 接受yyyyMMddHHmmss的日期字符串参数,返回两个日期相差的毫秒数
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	public static long getDistTimeInMillis(String start, String end)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		long totalDate = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);

		long timestart = calendar.getTimeInMillis();
		calendar.setTime(endDate);
		long timeend = calendar.getTimeInMillis();

		totalDate = (timeend - timestart);
		return totalDate;
	}

	public static boolean isInBetweenDate(Date date, Date startDate,
			Date endDate) {
		if (date == null || startDate == null || endDate == null) {
			return false;
		}
		long d = date.getTime();
		long s = startDate.getTime();
		long e = endDate.getTime();
		if (d > s && d < e) {
			return true;
		}
		return false;
	}

	/**
	 * 日期转换成 月id
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static int date2MonthID(String date, String mark) {
		SimpleDateFormat sdf = new SimpleDateFormat(mark);
		Calendar C = Calendar.getInstance();// 得到当前时间
		try {
			Date date1 = sdf.parse(date);
			C.setTime(date1);
			int monthid = (C.get(C.YEAR) - 2004) * 12 + C.get(C.MONTH) + 1;
			return monthid;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
