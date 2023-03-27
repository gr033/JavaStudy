package exam01;

import java.util.Scanner;

//파일 이름을 입력받아 확장자만 추출
public class ExtFromFname {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명을 입력하세요: ");
		String file = sc.next();
		int n = file.indexOf('.');
		String ext = file.substring(n+1);
		System.out.println("확장자: "+ext);
		if (ext.equals("png") || ext.equals("jpg")||ext.equals("gif")) {
			System.out.println("이미지 파일");
		}
		else {
			System.out.println("이미지 파일 아님");
		}
	}
}
