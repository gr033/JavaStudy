package exam01;

import java.util.Scanner;

//사용자한테 확장자 포함 파일명 입력받아 이미지 파일인지 판별하는 프로그램
// png, jig, gif
public class EndsWithTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("확장자를 포함한 파일명을 입력하세요: ");
		String name = sc.next();
		
		boolean flag;
		if (name.endsWith(".jpg") || name.endsWith(".gif") || name.endsWith(".png")){
			System.out.println("이미지 파일입니다.");
		}
		else {System.out.println("이미지 파일이 아닙니다.");}
	}
}
