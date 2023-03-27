package exam01;

import java.util.Scanner;

//사용자에게 암호와 암호확인을 입력받아 6글자 이상, 암호와 암호확인이 동일, 숫자 포함, 특수문자 포함
//하고 있는지 판별하는 프로그램을 작성
public class Test11 {
	public static boolean special(String data) {
		boolean flag = false;
		char []sp = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', ',', '.'};
		for(int i = 0;i<data.length();i++) {
			char ch = data.charAt(i);
			for(int j = 0; j<sp.length;j++) {
				if (ch==sp[j]) {
					return true;
				}
			}
		}
		return flag;
	}
	public static boolean isContainDigit(String data) {
		boolean flag = false;
		for (int i = 0; i<data.length();i++) {
			char ch = data.charAt(i);
			if(ch >= '0' && ch<= '9') {
				flag = true;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("암호: ");
		String pwd = sc.next();
		System.out.println("암호 확인 ");
		String pwdc = sc.next();
		sc.close();
		if(pwd.length()>=6 && pwd.equalsIgnoreCase(pwdc) && isContainDigit(pwd) && special(pwd)) {
			System.out.println("올바른 암호입니다.");
		}
		else {System.out.println("올바른 암호가 아니거나 암호와 암호확인이 다릅니다.");}
	}
}
