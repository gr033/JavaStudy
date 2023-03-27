package exam01;

import java.util.Date;
import java.util.Scanner;

//사용자로부터 이름, 주민번호를 입력받아 무료 암검진 대상자인지 선별하여
//결과를 출력하는 프로그램
//처리조건: 40세 이상, 올해가 홀수년도이면 홀수년도에 태어나고 
//올해가 짝수연도이면 짝수연도에 태어난 사람이 무료 암검진 대상자
//무료 암검진 항목
/*
 40세 이상 -> 위암, 간암, 일반암
 40세 이상 여자 -> 위암, 간암, 일반암, 유방암, 자궁암
 50세 이상 -> 위암, 간암, 일반암, 대장암
 50세 이상 여자 -> 위암, 간암, 일반암, 유방암, 자궁암, 대장암
 */
public class CancerTeest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		System.out.println("***무료 암검진 대상자 확인***");
		System.out.println("이름: ");
		String name = sc.next();
		System.out.println("주민등록번호(-포함): ");
		String num = sc.next();
		String year = num.substring(0, 2);
		int gender = Integer.parseInt(num.substring(7, 8));
		int yy = Integer.parseInt(year);
		if(gender==3 || gender==4) {
			yy+=2000;
		}
		else if (gender==1||gender==2) {
			yy+=1900;
		}
		int thisyear = today.getYear()+1900;
		int age = thisyear-yy;
		System.out.println("***결과***");
		System.out.println("올해연도: "+thisyear+", 출생연도: "+yy);
		if(thisyear%2 == yy%2 &&age>=40) {System.out.println(name+"님 무료 암검진 대상자입니다.");}
		else {
			System.out.println(name+"님 무료 암검진 대상자가 아닙니다.");
			return;
		}
		System.out.print("가능한 암검진: ");
		System.out.print("위암, 간암, 일반암");
		if(gender == 2 || gender ==4) {System.out.print(", 유방암, 자궁암");}
		if(age>=50) {System.out.print(", 대장암");}
		
	}
}