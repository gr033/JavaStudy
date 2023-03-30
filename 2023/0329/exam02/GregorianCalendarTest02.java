package exam02;

import java.util.GregorianCalendar;
import java.util.Scanner;

//사용자에게 연도를 입력받아 그 해가 윤년인지 판별하는 프로그램
public class GregorianCalendarTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GregorianCalendar gr = new GregorianCalendar();
		System.out.print("연도 입력: ");
		int yy = sc.nextInt();
		if(gr.isLeapYear(yy)) {
			System.out.println("윤년입니다.");
		}else {
			System.out.println("윤년이 아닙니다.");
		}
	}
}
