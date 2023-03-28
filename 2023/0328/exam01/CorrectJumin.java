package exam01;

import java.util.Scanner;
public class CorrectJumin {
	//문자열을 매개변수로 전달받아 모두 숫자로 구성되었는지 판별하는 메소드
	public static boolean isDisit(String data) {
		boolean flag = true;
		for (int i =0; i<data.length();i++) {
			char ch = data.charAt(i);
			if(ch<'0' || ch>'9') {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jumin;
		int sum = 0;
		System.out.println("주민번호(-포함): ");
		jumin = sc.next();
		if(jumin.length() != 14) 
			{System.out.println("올바른 주민번호가 아닙니다.");return;}
		if(jumin.charAt(6)!='-') 
			{System.out.println("올바른 주민번호가 아닙니다.");return;}
		String []num = jumin.split("-");
		if(num.length != 2) {
			System.out.println("올바른 주민번호가 아닙니다.");
			return;
		}
		
		if(!isDisit(num[0]) || num[0].length() != 6) {
			System.out.println("올바른 주민번호가 아닙니다.");
			return;
		}
		
		if(!isDisit(num[1]) || num[1].length() != 7) {
			System.out.println("올바른 주민번호가 아닙니다.");
			return;
		}
		
		int []n = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
		for(int i = 0;i<jumin.length()-1;i++) {
			if(i!=6) {
				sum += Integer.parseInt(jumin.charAt(i)+"")*n[i];
			}
		}
		sum = sum % 11;
		sum = 11-sum;
		if (sum==10) {sum=0;}
		if (sum==11) {sum=1;}
		int check = Integer.parseInt(jumin.charAt(13)+"");
		if(sum==check) {
			System.out.println("올바른 주민번호입니다.");
		}
		else {System.out.println("올바른 주민번호가 아닙니다.");}
		sc.close();
	}
}
