package exam02;

import java.util.Date;
//2023년 3월 29일(수요일) 10시 15분 30초 
public class DateTest01 {
	public static void main(String[] args) {
		Date today = new Date();
		//System.out.println(today);
		String []day = {"일", "월", "화", "수", "목", "금", "토"};
		String day1 = day[today.getDay()];
		System.out.printf("%d년 %d월 %d일 (%s요일) %d시 %d분 %d초", 
				today.getYear()+1900, today.getMonth()+1, today.getDate(), 
				day1, today.getHours(), today.getMinutes(),
				today.getSeconds());
	}
}