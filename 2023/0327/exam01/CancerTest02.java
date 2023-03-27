package exam01;

import java.util.Date;
import java.util.Scanner;

public class CancerTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String jumin;
		String checkUp = "위암, 간암, 일반암";
		Date today = new Date();
		int thisYear = today.getYear()+1900;
		System.out.println("이름을 입력하세요.");
		name = sc.next();
		System.out.println("주민번호(-포함)를 입력하세요.");
		jumin = sc.next();
		int gender = Integer.parseInt(jumin.substring(7, 8));
		int year = Integer.parseInt(jumin.substring(0, 2));
		if (gender==1 || gender==2) {year+=1900;}
		else {year+=2000;}
		int age = thisYear-year;
		System.out.println("***결과 판정***");
		System.out.println("이름: "+name);
		System.out.println("주민번호: "+jumin);
		System.out.println("출생연도: "+year);
		System.out.println("나이: "+age);
		System.out.println("올해연도: "+thisYear);
		if(age<40 || thisYear%2 != year%2) {
			System.out.println("무료 암검진 대상자가 아닙니다.");
			return;
		}
		if(age>=50) {
			checkUp +=", 대장암";
		}
		if (gender ==2 || gender ==4) {
			checkUp +=", 유방암, 자궁암";
		}
		System.out.println("무료 암검진 대상자입니다.");
		System.out.println("검진 항목은 "+checkUp+"입니다.");
	}
}
