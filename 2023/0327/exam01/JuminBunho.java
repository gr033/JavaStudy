package exam01;

import java.util.Scanner;

public class JuminBunho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 입력: ");
		String num = sc.next();
		num = num.replace("-", "");
		int sum = 0;
		for (int i = 0;i<7;i++) {
			sum += (i+2)*(Integer.parseInt(num.charAt(i)+""));
		}
		for (int i = 7;i<11;i++){
			sum += (i-5)*(Integer.parseInt(num.charAt(i)+""));
		}
		int x = (11-(sum%11))%10;
		
		if(num.endsWith(x+"")) {
			System.out.println("유효한 주민번호입니다.");
		}
		else {System.out.println("유효한 주민번호가 아닙니다.");}
	}
}