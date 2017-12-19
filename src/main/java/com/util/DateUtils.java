package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 日期操作工具类
 * 
 * @author qwu
 * @created 2016年2月22日 下午4:44:14
 * @version 0.0.1
 */
public class DateUtils {
	
	/** 日期格式yyyyMMddHHmmss **/
	public static String FORMAT_TIME = "yyyyMMddHHmmss";
	public static String FORMAT_TIME2 = "yyyyMMddHHmmssSSS";

	public static String FORMAT_DATE = "yyyyMMdd";
	public static String FORMAT_DATE2 = "yyyy-MM-dd";
	public static String FORMAT_DATE3 = "yyyy/MM/dd";
	public static String FORMAT_DATE4 = "yyyy年MM月dd日";

	/** 日期格式 yyyy-MM-dd HH:mm:ss **/
	public static final String FORMAT_TIME_SHOW = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy-MM-dd
	 * 
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy-MM-dd
	 */
	public static String parseToDate(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 给定指定模式，指定日期字符串
	 * 
	 * @param pattern
	 *            模式如(yyyyMMddHHmmss...)
	 * @param date
	 *            日期
	 * @return 解释后返回的日期对象
	 */
	public static Date parseDate(String pattern, String date) {
		if (StringUtils.isBlank(pattern) || StringUtils.isBlank(date))
			return null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

	/**
	 * 给定指定模式，指定日期字符串
	 * 
	 * @param pattern
	 *            模式如(yyyyMMddHHmmss...)
	 * @param date
	 *            日期
	 * @return 解释后返回的日期对象
	 */
	public static String parseDate(String pattern, Date date) {
		if (null == date || StringUtils.isBlank(pattern))
			return null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为HH:mm:ss
	 * 
	 * @param date
	 *            yyyyMMddHHmmss格式的日期
	 * @return HH:mm:ss
	 */
	public static String parseToTimeHHmmss(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmm格式 格式化为HH:mm
	 * 
	 * @param date
	 *            yyyyMMddHHmm格式
	 * @return HH:mm
	 */
	public static String parseToTimeHHMM(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy/MM/dd HH:mm:ss
	 * 
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateYYYYMMDDHHMMSS(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy年MM月dd日
	 * 
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateYYYYMMDD(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = null;
		if (date.length() > 8) {
			format = new SimpleDateFormat("yyyyMMddHHmmss");
		} else {
			format = new SimpleDateFormat("yyyyMMdd");
		}

		SimpleDateFormat fo = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 返回默认时间格式 14位:yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * 返回指定的时间格式
	 * 
	 * @return
	 */
	public static String getCurrentDate(String parrten) {
		if (StringUtils.isBlank(parrten)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(parrten);
		return format.format(new Date());
	}

	/**
	 * 将yyyy-MM-dd格式 格式化为yyyyMMdd
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return yyyyMMdd
	 */
	public static String parseToDateYYYYMMdd(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fo = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式 格式化为yyyyMMddHHmmss
	 * 
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss格式
	 * @return yyyyMMddHHmmss
	 */
	public static String parseToDateYYYYMMddHHmmss(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyyMMdd格式 格式化为yyyy-MM-dd
	 * 
	 * @param date
	 *            yyyy-MM-dd格式
	 * @return yyyy-MM-dd
	 */
	public static String parseToDate2(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 日期字符串格式转换通用方法
	 * 
	 * @param date
	 *            要转换的值
	 * @param sourceFormate
	 *            源日期格式
	 * @param objectiveFormate
	 *            目标日期格式
	 * @return
	 */
	public static String parseToDate(String date, String sourceFormate,
			String objectiveFormate) {
		SimpleDateFormat format = new SimpleDateFormat(sourceFormate);
		SimpleDateFormat fo = new SimpleDateFormat(objectiveFormate);
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 得到前两个月的最后一天的日期和 前一个月的最后一天的日期(如果为<=0取默认的) 参数可选
	 * 
	 * @param startMonth
	 *            (默认2)
	 * @param endMonth
	 *            (默认1)
	 * @param datePattern
	 *            日期格式(默认yyyy-MM-dd)
	 * @return key[startDate],key[endDate]
	 */
	public static Map<String, String> getDateForSet(Integer startMonth,
			Integer endMonth, String datePattern) {
		if (startMonth == null) {
			startMonth = -2;
		} else {
			startMonth = Integer.parseInt("-" + startMonth);
		}
		if (endMonth == null) {
			endMonth = -1;
		} else {
			endMonth = Integer.parseInt("-" + startMonth);
		}
		if (StringUtils.isBlank(datePattern)) {
			datePattern = "yyyy-MM-dd";
		}

		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		Calendar start = Calendar.getInstance();
		start.add(Calendar.MONTH, startMonth);
		start.set(Calendar.DAY_OF_MONTH,
				start.getActualMaximum(Calendar.DAY_OF_MONTH));
		String startDate = format.format(start.getTime());

		Calendar end = Calendar.getInstance();
		end.add(Calendar.MONTH, endMonth);
		end.set(Calendar.DAY_OF_MONTH,
				end.getActualMaximum(Calendar.DAY_OF_MONTH));
		String endDate = format.format(end.getTime());
		Map<String, String> rs = new HashMap<String, String>(1);
		rs.put("startDate", startDate);
		rs.put("endDate", endDate);
		return rs;
	}

	/**
	 * 将yyyyMMddHHmmss格式 格式化为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            yyyyMMddHHmmss格式
	 * @return yyyy/MM/dd HH:mm:ss
	 */
	public static String parseToDateAD(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = format.parse(date);
			return fo.format(date1);
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式 格式转化为yyyyMMddHHmmss
	 * 
	 * @param FORMAT_TIME
	 * @param date
	 * @return
	 */
	public static String parseToDateS(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat(FORMAT_TIME);

		try {
			Date date1 = format1.parse(date);
			return format2.format(date1);
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * 将yyyy-MM-dd格式 格式转化为yyyyMMdd
	 * 
	 * @param FORMAT_DATE
	 * @param date
	 * @return
	 */
	public static String parseToDateSS(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat(FORMAT_DATE);

		try {
			Date date1 = format1.parse(date);
			return format2.format(date1);
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * 把日期后的时间归为当天的最后 变成(yyyy-MM-dd 23:59:59:999)
	 * 
	 * @param fullDate
	 *            Date
	 * @return Date
	 */
	public static final Date endlizedTime(Date fullDate) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(fullDate);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/***************************************************************************
	 * 获得当前日期的 年+月 的格式： 例如:201010 2010年10月
	 * 
	 * @return
	 */
	public static Integer getYearAndMonth() {
		StringBuilder builder = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		builder.append(year);

		int month = cal.get(Calendar.MONTH) + 1;
		if (month < 10) {
			builder.append("0").append(month);
		} else {
			builder.append(month);
		}
		return Integer.parseInt(builder.toString());
	}

	/**
	 * 用于结束时间，获得当前日期的 yyyy-MM-dd hh:mm:ss 的格式：
	 * 
	 * @return
	 */
	public static String getNow() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1)
				+ "-" + now.get(Calendar.DAY_OF_MONTH) + " 00:00:00";
	}

	/**
	 * 用于结束时间，获得当前日期的 yyyy-MM-dd 的格式：
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		Calendar now = Calendar.getInstance();
		Date date = new Date();
		now.setTime(date);
		String dateVal = new SimpleDateFormat("yyyy-MM-dd").format(now
				.getTime());
		return dateVal;
	}

	/**
	 * 用于开始时间，获得month月前今天的 yyyy-MM-dd hh:mm:ss 的格式：
	 * 
	 * @return
	 */
	public static String getMonthPer(int month) {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) + "-"
				+ (now.get(Calendar.MONTH) + 1 + month) + "-"
				+ now.get(Calendar.DAY_OF_MONTH) + " 23:59:59";
	}

	/**
	 * 用于开始时间，获得year年前今天的 yyyy-MM-dd hh:mm:ss 的格式：
	 * 
	 * @return
	 */
	public static String getYearPer(int year) {
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.YEAR) + year) + "-" + now.get(Calendar.MONTH)
				+ "-" + now.get(Calendar.DAY_OF_MONTH) + " 23:59:59";
	}

	/**
	 * 根据基准时间加上天数,得到新的时间
	 * 
	 * @param baseDate
	 *            基准时间
	 * @param days
	 *            天数
	 * @return
	 */
	public static Date addDays(Date baseDate, int days) {
		Calendar expiration = Calendar.getInstance();
		expiration.setTime(baseDate);
		expiration.add(Calendar.DAY_OF_MONTH, days);

		return expiration.getTime();
	}

	/**
	 * 根据基准时间加上月数,得到新的时间
	 * 
	 * @param baseDate
	 *            基准时间
	 * @param days
	 *            月数
	 * @return
	 */
	public static Date addMonths(Date baseDate, int months) {
		Calendar expiration = Calendar.getInstance();
		expiration.setTime(baseDate);
		expiration.add(Calendar.MONTH, months);

		return expiration.getTime();
	}

	/**
	 * 增加月份
	 * 
	 * @param date
	 *            需要处理的日期
	 * @param month
	 *            增加的月份
	 * @return 处理后的日期
	 */
	public static Date addMonth(Date date, int month) {
		if (date == null) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * 计算上个月最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonthOfStartTime(Date date) {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(date);
		endCalendar.add(Calendar.MONTH, 1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算上个月最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastMonthOfStartTime() {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(new Date());
		endCalendar.add(Calendar.MONTH, 1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算日期当天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateOfStartTime(Date date) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(date);
		startCalendar.set(Calendar.HOUR_OF_DAY, 0);
		startCalendar.set(Calendar.MINUTE, 0);
		startCalendar.set(Calendar.SECOND, 0);
		startCalendar.set(Calendar.MILLISECOND, 0);
		return startCalendar.getTime();
	}

	/**
	 * 计算日期后一天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTomorrowStartTime(Date date) {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(date);
		endCalendar.add(Calendar.DAY_OF_MONTH, 1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算明天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTomorrowStartTime() {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(new Date());
		endCalendar.add(Calendar.DAY_OF_MONTH, 1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算日期前一天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYesterdayStartTime(Date date) {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(date);
		endCalendar.add(Calendar.DAY_OF_MONTH, -1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算昨天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYesterdayStartTime() {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(new Date());
		endCalendar.add(Calendar.DAY_OF_MONTH, -1);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 计算今天最早时刻，精确到毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTodayStartTime(Date date) {
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(date);
		endCalendar.set(Calendar.HOUR_OF_DAY, 0);
		endCalendar.set(Calendar.MINUTE, 0);
		endCalendar.set(Calendar.SECOND, 0);
		endCalendar.set(Calendar.MILLISECOND, 0);
		return endCalendar.getTime();
	}

	/**
	 * 获取昨天的日期,根据日期和格式
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String getYesterDay(Date date, String dateFormat) {
		if (dateFormat == null) {
			dateFormat = "yyyy-MM-dd";
		}
		if (date != null) {
			return DateUtils.parseDate(dateFormat, getYesterdayStartTime(date));
		}
		return DateUtils.parseDate(dateFormat, getYesterdayStartTime());
	}

	/**
	 * 根据传入的天数,日期格式 获取间隔日期
	 * 
	 * @param day
	 * @param dateFormat
	 * @return
	 */
	public static String getIntervalDay(String day, String dateFormat) {
		// 要间隔天数
		int intervalDay = NumberUtils.toInt(day, 1);
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, intervalDay);
		String dateVal = new SimpleDateFormat(StringUtils.defaultIfEmpty(
				dateFormat, "yyyy-MM-dd")).format(cal.getTime());
		return dateVal;
	}

	public static String getFormatYMDHMS(Date date) {
		return CalendarUtil.formatDate(date, "yyyy年MM月dd日 HH:mm:ss");
	}

	public static String getFormatYMDHMS2(Date date) {
		return CalendarUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getFormatYMD(Date date) {
		return CalendarUtil.formatDate(date, "yyyy年MM月dd日");
	}

	public static String getFormatYMD2(Date date) {
		return CalendarUtil.formatDate(date, "yyyy-MM-dd");
	}

	public static String getFormatYYYYMMddHHmmss(Date date) {
		return CalendarUtil.formatDate(date, FORMAT_TIME);
	}
	public static Date defaultIfNull(Date date, Date defaultValue) {
		return (date == null) ? defaultValue : date;
	}

	public static Date defaultIfNull(Date date) {
		return (date == null) ? Calendar.getInstance().getTime() : date;
	}
}
