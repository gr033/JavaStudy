package exam01;

import java.util.Scanner;

//파일 이름을 입력받아 확장자만 추출
public class ExtFromFname02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명을 입력하세요: ");
		String file = sc.next();
		file = file.replace(".", ",");
		String arr[] = file.split(",");
		System.out.println(arr[1]);
	}
}