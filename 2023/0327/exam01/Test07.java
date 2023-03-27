package exam01;

import java.util.Scanner;

//암호와 암호확인을 입력받아 서로 같은지 판별하고 또 암호의 길이가 6자 이상인지 판별하는 프로그램 작성
public class Test07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("암호 입력: ");
		String pwd1 = sc.next();
		System.out.println("암호 확인: ");
		String pwd2 = sc.next();
		sc.close();
		if(pwd1.length()<6) {System.out.println("암호는 6글자 이상");return;}
		if(!pwd2.equals(pwd2)) {System.out.println("암호와 암호확인이 다릅니다.");return;}
		System.out.println("올바른 입력입니다.");
		System.out.println("암호: "+pwd1);
	}
}
