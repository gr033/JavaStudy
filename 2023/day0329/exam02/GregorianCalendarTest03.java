package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * 사용자로부터 년, 월, 일을 받아 그 날짜의 요일을 출력하는 프로그램
 * */
public class GregorianCalendarTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String []day = {"", "일", "월", "화", "수", "목", "금", "토"};
		int yy, mm, dd;
		System.out.print("년: ");
		yy = sc.nextInt();
		System.out.print("월: ");
		mm= sc.nextInt();
		System.out.print("일: ");
		dd = sc.nextInt();
		GregorianCalendar gr = new GregorianCalendar(yy, mm-1, dd);
		int dy = gr.get(Calendar.DAY_OF_WEEK);
		String DD = day[dy];
		System.out.printf("%d년 %d월 %d일은 %s요일입니다.", yy, mm, dd, DD);
	}
}
