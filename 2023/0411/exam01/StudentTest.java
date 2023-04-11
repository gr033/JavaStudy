//학생의 이름, 국어, 영어, 수학 점수를 입력받아 출력하는 프로그램
package exam01;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, math;
		System.out.println("이름 입력");
		name = sc.next();
		System.out.println("국어");
		kor = sc.nextInt();
		System.out.println("영어");
		eng = sc.nextInt();
		System.out.println("수학");
		math = sc.nextInt();
		System.out.println("이름:"+name);
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
	}
}
