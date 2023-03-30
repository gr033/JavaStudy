package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;

//1부터 31까지의 숫자를 출력해봅니다.
public class GregorianCalendarTest06 {
	public static void main(String[] args) {
		String []str = {"일", "월", "화", "수", "목", "금", "토"};
		
		GregorianCalendar today = new GregorianCalendar();
		int yy = today.get(Calendar.YEAR);
		int mm = today.get(Calendar.MONTH);
		System.out.printf("%d년 %d월 \n", yy, mm+1);
		for(String s:str) {
			System.out.printf("%-3s", s);
		}
		System.out.println();

		GregorianCalendar startDay = new GregorianCalendar(yy, mm, 1);
		int dy = startDay.get(Calendar.DAY_OF_WEEK);
		int last = startDay.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1;i<dy;i++) {
			System.out.printf("%3c", ' ');
		}
		for(int i=1;i<=last;i++) {
			System.out.printf("%3d", i);
			if((i+dy-1)%7 == 0) {
				System.out.println();
			}
		}
	}
}