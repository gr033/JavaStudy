package exam01;

import java.util.Date;
import java.util.Scanner;
//주민번호를 입력받아 나이를 구하여 출력
public class SubStringTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요: ");
		String num = sc.next();
		String year = num.substring(0, 2);
		int yy=Integer.parseInt(year);
		int gender = Integer.parseInt(num.substring(7, 8));
		if(gender == 3 || gender == 4) {
			yy += 2000;
		}
		else if (gender ==1 || gender ==2) {
			yy += 1900;
		}
		Date today = new Date();
		int thisyear = today.getYear()+1900;
		int age = thisyear - yy;
		System.out.println("태어난 해: "+yy);
		System.out.println("나이: "+age);
		sc.close();
	}
}
