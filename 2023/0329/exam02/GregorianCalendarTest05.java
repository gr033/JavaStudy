package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;
//이달의 시작일의 요일에 해당하는 숫자를 출력
public class GregorianCalendarTest05 {
	public static void main(String[] args) {
		GregorianCalendar gr = new GregorianCalendar();
		int mm = gr.get(Calendar.MONTH);
		int yy = gr.get(Calendar.YEAR);
		GregorianCalendar gr2 = new GregorianCalendar(yy, mm, 1);
		int day = gr2.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
	}
}
