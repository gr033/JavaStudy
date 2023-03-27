package exam01;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pwd;
		System.out.println("암호 입력");
		pwd = sc.next();
		System.out.println("password: "+pwd);
		sc.close();
	}
}
