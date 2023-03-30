package exam02;

import java.util.Date;
//2023년 3월 29일(수요일) 10시 15분 30초 
public class DateTest02 {
	public static void main(String[] args) {
		Date today = new Date();
		//System.out.println(today);
		String []day = {"일", "월", "화", "수", "목", "금", "토"};
		String day1 = day[today.getDay()];
		int yy = today.getYear()+1900;
		int mm = today.getMonth()+1;
		int dd = today.getDate();
		int hh = today.getHours();
		int MM = today.getMinutes();
		int ss = today.getSeconds();
		System.out.printf("%d년 %d월 %d일 (%s요일) %d시 %d분 %d초\n", 
				today.getYear()+1900, today.getMonth()+1, today.getDate(), 
				day1, today.getHours(), today.getMinutes(),
				today.getSeconds());
		String result = String.format("%d년 %d월 %d일 (%s요일) %d시 %d분 %d초", 
				yy, mm, dd, day1, hh, MM, ss);
		System.out.println(result);
	}
}