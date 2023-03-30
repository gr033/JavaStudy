package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//사용자로부터 연도와 월을 입력받아 그 달에 시작일의 요일에 대한 정수값을 구하는 프로그램
public class GregorianCalendarTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도: ");
		int yy = sc.nextInt();
		System.out.print("월: ");
		int mm = sc.nextInt();
		GregorianCalendar gr = new GregorianCalendar(yy, mm-1, 1);
		int day = gr.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
	}
}
