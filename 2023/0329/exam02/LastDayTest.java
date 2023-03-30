package exam02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LastDayTest {
	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		int last = today.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(last);
		GregorianCalendar cal = new GregorianCalendar(2023, 1, 1);
		int last2 = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(last2);
	}
}
