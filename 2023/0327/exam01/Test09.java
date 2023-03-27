package exam01;

import java.util.Scanner;

//문자열 데이터를 매개변수로 전달받아 그 문자열 안에 숫자가 있는지 판별하여 boolean을 반환하는 메소드를 정의
public class Test09 {
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
		String data;
		System.out.println("문자열을 입력하세요.");
		data = sc.next();
		sc.close();
		if(isContainDigit(data)) {
			System.out.println("숫자를 포함하고 있습니다.");
		}
		else {System.out.println("숫자를 포함하고 있지 않습니다.");}
	}
}
