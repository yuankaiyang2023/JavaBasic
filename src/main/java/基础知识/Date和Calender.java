package 基础知识;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date和Calender {
	public static void main(String[] args) {
		Date date = new Date();
		long mil = date.getTime();
		Date date2 = new Date(mil - 1000);
		long mil2 = date2.getTime();
		System.out.println(date);
		System.out.println(mil);
		System.out.println(mil - mil2);
		System.out.println(date.after(date2));

		// DateFormat
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat format2 = new SimpleDateFormat("D");
		String str = format.format(date);
		String str2 = format2.format(date);
		System.out.println(str);
		System.out.println(str2);
		try {
			Date date3 = format.parse(str);
			Date date4 = format2.parse(str2);
			System.out.println(date3);
			System.out.println(date4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Calendar
		Calendar c = new GregorianCalendar(2022, 11, 1, 5, 3, 5);// 11代表12月
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE); // DAY_OF_WEEK
		int week = c.get(Calendar.WEEK_OF_MONTH);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		String weekday2 = weekday == 1 ? "日" : weekday - 1 + ""; //1代表日，2代表星期一
		System.out.printf("%s年%s月%s日 第%s周 星期%s\n", year, month, day, week, weekday2);
		c.set(Calendar.YEAR, 2021);
		c.add(Calendar.YEAR, -100);
		
		// Calendar转化为Date
		Date date5 = c.getTime();
		System.out.println(date5);
		Calendar c2 = new GregorianCalendar();
		c2.setTime(date5);
		System.out.println(c2);
	}
}
