package exam01;

import java.util.Scanner;
//사용자에게 주민번호를 입력받아(하이폰 포함) 성별을 파악하는 프로그램
public class SubStringTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호('-'포함)를 입력하세요: ");
		String jumin = sc.next();
		String check = jumin.substring(7,8);
		if(check.equals("1")||check.equals("3")) {
			System.out.println("남자");
		}
		else if (check.equals("2")||check.equals("4")) {
			System.out.println("여자");
		}
		sc.close();
	}
}
//String num = sc.next();
//if(num.charAt(0)=='9') {
//	if(num.charAt(7)=='2') {System.out.println("여자입니다.");}
//	else if(num.charAt(7)=='1') {System.out.println("남자입니다.");}
//}
//else if(num.charAt(0)=='0') {
//	if(num.charAt(7)=='4') {System.out.println("여자입니다.");}
//	else if(num.charAt(7)=='3') {System.out.println("남자입니다.");}
//}
//sc.close();