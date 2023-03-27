package exam01;
//문자열 데이터를 매개변수로 전달받아 그 문자열 안에 특수문자(!@#$%^&*(),.)를 포함하고 있는지 판별하는 메소드를 만들고 테스트
import java.util.Scanner;

public class Test10 {
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		String st = sc.next();
		sc.close();
		if(special(st)) {
			System.out.println("특수문자(!@#$%^&*(),.) 포함: "+st);
		}
		else {System.out.println("특수문자 미포함: "+st);} 
		
	}
}
