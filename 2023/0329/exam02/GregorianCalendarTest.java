package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {
	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		String []day = {"", "일", "월", "화", "수", "목", "금", "토"};
		int yy = today.get(Calendar.YEAR);
		int mm = today.get(Calendar.MONTH)+1;
		int dd = today.get(Calendar.DATE);
		String DD = day[today.get(Calendar.DAY_OF_WEEK)];
		int hh = today.get(Calendar.HOUR_OF_DAY);
		int MM = today.get(Calendar.MINUTE);
		int ss = today.get(Calendar.SECOND);
		String result = String.format("%d년 %d월 %d일 (%s요일) %d시 %d분 %d초", 
				yy, mm, dd, DD, hh, MM, ss);
		System.out.println(result);
	}
}
